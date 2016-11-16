
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpiderMain {

	public static void main(String[] args) {
		
		Pattern questionUrlShortFormat = Pattern.compile("[0-9]{4}");
		Matcher UrlMatcher = questionUrlShortFormat.matcher("5555");
		Pattern zhihuUrlFormat = Pattern.compile("question_link.+?href=\"(.+?)\"");
		Matcher x1 = zhihuUrlFormat.matcher("question_link\" href=\"/question/51783509/answer/128688529\" data-id=\"12931354\"");
		
		// 定义即将访问的链接
		String url = "https://www.zhihu.com/explore/recommendations";
		String urlResult = SendGet(url);
		System.out.println(urlResult + "\n");
		String result = RegexMatch.questionMatch(urlResult) + "\n";
		// if(result !=null && result !=""){
		//
		// }
		System.out.println(result);

		// 知乎
		getZhihu(urlResult);

		System.out.println(LocalDateTime.now());
	}

	// SendGet请求
	public static String SendGet(String url) {
		// 定义一个字符串用来存储网页内容
		String result = "";
		// 定义一个缓冲字符输入流
		BufferedReader in = null;
		try {
			// 将string转成url对象
			URL realUrl = new URL(url);
			// 初始化一个链接到那个url的连接
			URLConnection connection = realUrl.openConnection();
			// 开始实际的连接
			connection.connect();
			// 初始化 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			// 用来临时存储抓取到的每一行的数据
			String line;
			while ((line = in.readLine()) != null) {
				// 遍历抓取到的每一行并将其存储到result里面
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;

	}

	// getZhihuAnwser
	public static Map<String, String> getZhihuAnwser(Zhihu zhihuParameter) {
		Map<String, String> resultMap = new HashMap();
		String htmlStr = SendGet(zhihuParameter.zhihuUrl);
		System.out.println(htmlStr + "\n");

		return resultMap;
	}

	// 知乎问题链接统一
	public static String uniUrl(String url) {
		Pattern questionUrlShortFormat = Pattern.compile("[0-9]{4}");
		Matcher UrlMatcher = questionUrlShortFormat.matcher("5555");
		return UrlMatcher.group(1);
	}

	// getZhihu
	public static List<Zhihu> getZhihu(String parameter) {
		Pattern questionFormat = Pattern.compile("question_link.+?>(.+?)<");
		Pattern zhihuUrlFormat = Pattern.compile("question_link.+?href=\"(.+?)\"");

		List<Zhihu> resultList = new ArrayList<Zhihu>();
		Matcher questionMatcher = questionFormat.matcher(parameter);
		Matcher zhihuUrlMatcher = zhihuUrlFormat.matcher(parameter);
		while (questionMatcher.find() && zhihuUrlMatcher.find()) {
			Zhihu zhihuTemp = new Zhihu();
			zhihuTemp.question = questionMatcher.group(1);
			zhihuTemp.zhihuUrl = "https://www.zhihu.com/question/" + uniUrl(zhihuUrlMatcher.group(1));
			getZhihuAnwser(zhihuTemp);
			resultList.add(zhihuTemp);
		}
		for (Zhihu i : resultList) {
			System.out.println("问题：" + i.question);
			System.out.println("链接：" + i.zhihuUrl + "\n");
		}

		return resultList;
	}

}
