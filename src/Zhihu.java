


import java.util.Map;
import java.util.HashMap;

public class Zhihu {
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
