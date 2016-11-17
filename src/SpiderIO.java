import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 */

/**
 * @author XXX
 *
 */
public class SpiderIO {
	
	
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


	//创建写入文件
	public static boolean createNewFile(String filePath, String content, boolean isAppend){
		boolean result = true;
		//将"\\"转为"/"
		String filePathTurn = filePath.replaceAll("\\\\", "/");
		//取出文件路径
		int index = filePathTurn.lastIndexOf("/");
		String pathName = filePathTurn.substring(0, index);
		//创建文件夹
		File fileDirectory = new File(pathName);
		result = fileDirectory.mkdirs();
		//创建文件
		File file = new File(filePathTurn);
		try{
			result = file.createNewFile();
		} catch (Exception e){
			result = false;
			e.printStackTrace();
		}
		
		//写入文件
		FileWriter fileWriter = null;
		try{
			fileWriter = new FileWriter(file, isAppend);
			fileWriter.write(content);
			fileWriter.flush();
		} catch (Exception e){
			result = false;
			e.printStackTrace();
		} finally {
			try{
				if(fileWriter != null){
					fileWriter.close();
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
		return result;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
