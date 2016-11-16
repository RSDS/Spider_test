
import java.io.*;
import java.net.*;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpiderMain {

	public static void main(String[] args) {
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

	// SendGet
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
	
	//知乎问题链接统一

	// getZhihu
	public static List<Zhihu> getZhihu(String parameter) {
		Pattern questionFormat = Pattern.compile("question_link.+?>(.+?)<");
		Pattern zhihuUrlFormat = Pattern.compile("question_link.+?href=\"(.+?)\"");
		Pattern questionUrlShortFormat = Pattern.compile("question/([0-9]+?)");
		List<Zhihu> resultList = new ArrayList<Zhihu>();
		Matcher questionMatcher = questionFormat.matcher(parameter);
		Matcher zhihuUrlMatcher = zhihuUrlFormat.matcher(parameter);
		while (questionMatcher.find() && zhihuUrlMatcher.find()) {
			String ss = zhihuUrlMatcher.group(1);
			Matcher qUrlMatcher = questionUrlShortFormat.matcher(ss);
			Zhihu zhihuTemp = new Zhihu();
			zhihuTemp.question = questionMatcher.group(1);
			String ss222222 = qUrlMatcher.group(1);
			zhihuTemp.zhihuUrl = "https://www.zhihu.com/question/" + ss222222;
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
