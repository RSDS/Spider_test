
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatch {

	static Pattern imageFormat = Pattern.compile("src=[^ ]*");
	static Pattern scienceFictionFormat = Pattern.compile("类型:</span> <span property=\"v:genre\">科幻</span>");
	static Pattern questionFormat = Pattern.compile("question_link.+?>(.+?)<");
	static Pattern zhihuUrlFormat = Pattern.compile("question_link.+?href=\"(.+?)\"");

	// 通用匹配方法
	public static String match(Pattern p, String parameter) {
		Matcher matcher = p.matcher(parameter);
		String result = "";
		while (matcher.find()) {
			result += ("\n" + matcher.group(1));
		}
		return result;
	}

	// 图像匹配
	public static String imageMatch(String str) {
		return match(imageFormat, str);
	}

	// 科幻类型的资源
	public static String SFMatch(String str) {
		return match(scienceFictionFormat, str);
	}

	// 问题匹配
	public static String questionMatch(String str) {
		return match(questionFormat, str);
	}

	// 知乎问题url
	public static String zhihuUrlMatch(String str) {
		return match(zhihuUrlFormat, str);
	}

}
