package Spider_jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Spider_jsoup_Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String url = "https://www.zhihu.com/explore/recommendations";
		
		Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
		
		System.out.println(doc);
		
//		Elements newsHeadlines = doc.getElementsByAttributeValue(key, value);
		
//		System.out.println(newsHeadlines);
		
		
	}

}
