package Spider_transnational;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zhihu {
	// 问题格式
	public static Pattern questionFormat = Pattern.compile("question_link.+?>(.+?)<");
	// 问题超链接格式
	public static Pattern zhihuUrlFormat = Pattern.compile("question_link.+?href=\"(.+?)\"");
	// 问题描述格式
	public static Pattern questionDescriptionFormat = Pattern.compile("question/detail\"><div class=\"zm-editable-content\">(.+?)</div>");
	// 问题答案格式
	public static Pattern answerFormat = Pattern.compile("zm-editable-content clearfix\">(.+?)</div>.+?zg-anchor-hidden ac");
	// 问题回答人ID格式
	public static Pattern answerIDFormat = Pattern.compile("data-author-name=\"(.+?)\"");

	// 获取知乎问题答案列表
	public static List<Zhihu> getZhihu(String parameter) {
		List<Zhihu> resultList = new ArrayList<Zhihu>();
		Matcher questionMatcher = questionFormat.matcher(parameter);
		Matcher zhihuUrlMatcher = zhihuUrlFormat.matcher(parameter);
		Matcher quesDescriptionMatcher = questionDescriptionFormat.matcher(parameter);
		while (questionMatcher.find() && zhihuUrlMatcher.find()) {
			Zhihu zhihuTemp = new Zhihu();
			zhihuTemp.question = questionMatcher.group(1);
			zhihuTemp.zhihuUrl = "https://www.zhihu.com/question/" + uniUrl(zhihuUrlMatcher.group(1));
			//问题可能没有具体描述
			if(quesDescriptionMatcher.find()){
				zhihuTemp.questionDesperation = quesDescriptionMatcher.group(1);
			}
			getZhihuAnwser(zhihuTemp);
			resultList.add(zhihuTemp);
		}
		//输出问题与链接
		for (Zhihu i : resultList) {
			System.out.println("\n问题：" + i.question);
			System.out.println("链接：" + i.zhihuUrl );
			System.out.println("问题描述："+ i.questionDesperation +"\n");
			for(Entry<String, String> entry : i.answerMap.entrySet()){
				System.out.println("回答人："+entry.getKey());
				System.out.println("答案："+entry.getValue()+"\n");
			}
		}

		return resultList;
	}
	
	// 知乎问题链接统一
	public static String uniUrl(String url) {
		Pattern questionUrlShortFormat = Pattern.compile("question/([0-9]*)");
		Matcher UrlMatcher = questionUrlShortFormat.matcher(url);
		if(UrlMatcher.find()){
			return UrlMatcher.group(1);
		}
		return "";
	}
	
	// 获取某个知乎问题的描述与所有答案
	public static void getZhihuAnwser(Zhihu zhihuParameter) {
		//把某个知乎问题链接去爬取所有回答
		String htmlStr = SpiderIO.SendGet(zhihuParameter.zhihuUrl);
		System.out.println(htmlStr + "\n");
		Matcher quesDescriptionMatcher = questionDescriptionFormat.matcher(htmlStr);
		if(quesDescriptionMatcher.find()){
			zhihuParameter.questionDesperation = quesDescriptionMatcher.group(1);
		}
		
		Matcher answerMatcher = answerFormat.matcher(htmlStr);
		Matcher answerIDMatcher = answerIDFormat.matcher(htmlStr);
		while(answerMatcher.find() && answerIDMatcher.find()){
			zhihuParameter.answerMap.put(answerIDMatcher.group(1), answerMatcher.group(1));
		}
		
	}
	
	
	
	//类实例
	public String question;
	public String zhihuUrl;
	public String questionDesperation;
	public Map<String, String> answerMap;
	
	public Zhihu() {
		this.question = "";
		this.zhihuUrl = "";
		this.questionDesperation = "";
		this.answerMap = new HashMap<String, String>();
	}
	
	public String getQuestion(){
		return this.question;
	}
	
	public String getZhihuUrl(){
		return this.zhihuUrl;
	}
	
	
	
	@Override
	public String toString(){
		String result = "问题："+question+"\n链接："+zhihuUrl+"\n问题描述："+questionDesperation+"\n";
		result += "所有回答：\n";
		for(Entry<String, String> entry: answerMap.entrySet()){
			result += "\n\t回答者："+entry.getKey();
			result += "\n\t回答详情：\r\t"+entry.getValue()+"\n";
		}
		 
		return result;
	}

}
