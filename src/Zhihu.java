


import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Zhihu {
	
	// 知乎问题链接统一
	public static String uniUrl(String url) {
		Pattern questionUrlShortFormat = Pattern.compile("question/([0-9]*)");
		Matcher UrlMatcher = questionUrlShortFormat.matcher(url);
		if(UrlMatcher.find()){
			return UrlMatcher.group(1);
		}
		return "";
	}
	
	// 获取某个知乎问题的答案
	public static Map<String, String> getZhihuAnwser(Zhihu zhihuParameter) {
		Map<String, String> resultMap = new HashMap();
		String htmlStr = SpiderMain.SendGet(zhihuParameter.zhihuUrl);
		System.out.println(htmlStr + "\n");

		return resultMap;
	}

	// 获取知乎问题答案列表
	public static List<Zhihu> getZhihu(String parameter) {
		Pattern questionFormat = Pattern.compile("question_link.+?>(.+?)<");
		Pattern zhihuUrlFormat = Pattern.compile("question_link.+?href=\"(.+?)\"");
		List<Zhihu> resultList = new ArrayList<Zhihu>();
		Matcher questionMatcher = questionFormat.matcher(parameter);
		Matcher zhihuUrlMatcher = zhihuUrlFormat.matcher(parameter);
		while (questionMatcher.find() && zhihuUrlMatcher.find()) {
			Zhihu zhihuTemp = new Zhihu();
			zhihuTemp.question = questionMatcher.group(1);
			zhihuTemp.zhihuUrl = "https://www.zhihu.com/question/" + Zhihu.uniUrl(zhihuUrlMatcher.group(1));
			getZhihuAnwser(zhihuTemp);
			resultList.add(zhihuTemp);
		}
		for (Zhihu i : resultList) {
			System.out.println("问题：" + i.question);
			System.out.println("链接：" + i.zhihuUrl + "\n");
		}

		return resultList;
	}
	
	
	
	//类实例
	public String question;
	public String zhihuUrl;
	public String questionDesperation;
	public Map<String, String> anwserMap;
	
	public Zhihu() {
		this.question = "";
		this.zhihuUrl = "";
		this.questionDesperation = "";
		this.anwserMap = new HashMap<String, String>();
	}
	
	
	
	public String getQuestion(){
		return this.question;
	}
	
	public String getZhihuUrl(){
		return this.zhihuUrl;
	}
	
	public String anwserToString(){
		Map<String, String> temMap = this.anwserMap;
		String result = "";
		
		
		return result;
	}
	
	
	@Override
	public String toString(){
		return "问题："+question+"\n链接："+zhihuUrl+"\n";
	}

}
