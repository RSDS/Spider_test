package Spider_jsoup;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider_jsoup_Main {

	public static void main(String[] args) throws IOException {
		
		
		
		
		
		
		
		Document doc = Jsoup.connect("https://book.douban.com/tag/%E7%BC%96%E7%A8%8B").timeout(100000).get();
		String text = doc.body().text();
		System.out.println(text);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//		String url = "";
		
//		Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
//		Document doc = Jsoup.connect("https://www.zhihu.com/question/43500794").get();
//		Document doc = Jsoup.connect("https://zhuanlan.zhihu.com/p/23676139").get();
//		Pattern bookFormat = Pattern.compile("title=\"(.+?)\"");
//		Pattern nextPageFormat = Pattern.compile("href=\"(.+?)\"");
//		Pattern ratingNumFormat = Pattern.compile("rating_nums\">(.+?)<");
//		String next = "/tag/%E7%BC%96%E7%A8%8B";
//		
//		while(next != null){
//			Document doc = Jsoup.connect("https://book.douban.com"+next).timeout(100000).get();
////			System.out.println(doc+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//			Matcher bookMatch = bookFormat.matcher(doc+"");
//			Matcher ratingNumMatch = ratingNumFormat.matcher(doc+"");
//			while(bookMatch.find()&& ratingNumMatch.find()){
//				System.out.println(bookMatch.group(1)+"\t"+ratingNumMatch.group(1));
//			}
//			Elements nextPage = doc.getElementsByClass("next");
//			Matcher nextPageMatch = nextPageFormat.matcher(nextPage+"");
//			if(nextPageMatch.find()){
//				next = nextPageMatch.group(1);
//			}else next =null;
//		}
//
//		
	}

}
