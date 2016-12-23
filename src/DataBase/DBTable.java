package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBTable {

	public Connection getConnection( String DBName){
		Connection cc = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/"+DBName;
			String user = "root";
			String password = "rsds15040060786";
			cc = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	
		return cc;
	}
	
	//根据传入的类型，生成一个示例数据
	public String generateDataOfColumn( String columnType ){
		String result = "";
		switch( columnType ){
		case "java.lang.Integer": 
			result ="1";
		case "java.lang.String":
			result ="";
		}
		
		
		return result;
	}
	
	
	
	

}
