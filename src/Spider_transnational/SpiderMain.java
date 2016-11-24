package Spider_transnational;

import java.time.LocalDateTime;

public class SpiderMain {

	public static void main(String[] args) {
			
		//造假数据
		System.out.println(autoSql.createFakeData());
		String filePath = "D:\\迭代工作\\2016-11-14--知识库_疾病信息_旧版\\HCRMYF-4022-4030-4031.sql";
		String content = autoSql.createFakeData();
		SpiderIO.createNewFile(filePath, content, true);
		
//		String filePath = "D:\\工作_学习\\爬虫\\知乎编辑推荐问题与回答.txt";
//
//		//定义即将访问的链接
//		String url = "https://www.zhihu.com/explore/recommendations";
//		
//		//获取页面
//		String urlResult = SpiderIO.SendGet(url);
//		System.out.println(urlResult + "\n");
//		
//		//匹配页面中的所有问题
//		String result = RegexMatch.questionMatch(urlResult) + "\n";
//		System.out.println(result);
//		
//		// 获取知乎问题答案列表并写入文件
//		String content = "";
//		for(Zhihu i: Zhihu.getZhihu(urlResult)){
//			content += i.toString()+"\n\n";
//		}
//		SpiderIO.createNewFile(filePath, content, true);
//		
//
//		//输出时间
//		System.out.println(LocalDateTime.now());
	}

	





}
