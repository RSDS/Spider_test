package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import DataBase.DBTable;

public class Main {

	public static void main(String[] args) {
		String DBName ="hcrm2";
		String tableName = "CT_PATIENT_INFO";
		
		Connection ccon = new DBTable().getConnection( DBName );
		String sql = "select * from "+tableName;
		PreparedStatement stmt;
		
		try{
			stmt = ccon.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData data = rs.getMetaData();
			for (int i = 1; i <= data.getColumnCount(); i++) {
				System.out.println("列名-----------------------"+data.getColumnName(i));
				System.out.println("列类型---------------------"+data.getColumnTypeName(i));
				System.out.println("列类型所属类---------------"+data.getColumnClassName(i));
//				System.out.println("列类型定义的最大字符个数----"+data.getColumnDisplaySize(i));
//				
//				System.out.println("列标题-----------------------"+data.getColumnLabel(i));
//				System.out.println("列模式-----------------------"+data.getSchemaName(i));
//				System.out.println("某列类型的精确度(类型的长度)-----------------------"+data.getPrecision(i));
//				System.out.println("列数点后的位数-----------------------"+data.getScale(i));
				

			}
			
			int dataNumber = 10;
			for( int i=0; i< dataNumber; ++i){
				System.out.println("INSERT INTO "+tableName +"VALUES(");
				for( int j=1; j<= data.getColumnCount(); ++j){
					System.out.println( new DBTable().generateDataOfColumn( data.getColumnClassName(j) ));
				}
				System.out.println(");");
			}
			
			
			
			
			
				
				
//			// 获得所有列的数目及实际列数
//			int columnCount = data.getColumnCount();
//			// 获得指定列的列名
//			String columnName = data.getColumnName(i);
//			// 获得指定列的列值
//			int columnType = data.getColumnType(i);
//			// 获得指定列的数据类型名
//			String columnTypeName = data.getColumnTypeName(i);
//			// 所在的Catalog名字---库名
//			String catalogName = data.getCatalogName(i);
//			// 对应数据类型的类
//			String columnClassName = data.getColumnClassName(i);
//			// 在数据库中类型的最大字符个数
//			int columnDisplaySize = data.getColumnDisplaySize(i);
//			// 默认的列的标题
//			String columnLabel = data.getColumnLabel(i);
//			// 获得列的模式
//			String schemaName = data.getSchemaName(i);
//			// 某列类型的精确度(类型的长度)
//			int precision = data.getPrecision(i);
//			// 小数点后的位数
//			int scale = data.getScale(i);
//			// 获取某列对应的表名
//			String tableName = data.getTableName(i);
//			// 是否自动递增
//			boolean isAutoInctement = data.isAutoIncrement(i);
//			// 在数据库中是否为货币型
//			boolean isCurrency = data.isCurrency(i);
//			// 是否为空
//			int isNullable = data.isNullable(i);
//			// 是否为只读
//			boolean isReadOnly = data.isReadOnly(i);
//			// 能否出现在where中
//			boolean isSearchable = data.isSearchable(i);
//			System.out.println(columnCount);
//			System.out.println("获得列" + i + "的字段名称:" + columnName);
//			System.out.println("获得列" + i + "的类型,返回SqlType中的编号:"+ columnType);
//			System.out.println("获得列" + i + "的数据类型名:" + columnTypeName);
//			System.out.println("获得列" + i + "所在的Catalog名字:"+ catalogName);
//			System.out.println("获得列" + i + "对应数据类型的类:"+ columnClassName);
//			System.out.println("获得列" + i + "在数据库中类型的最大字符个数:"+ columnDisplaySize);
//			System.out.println("获得列" + i + "的默认的列的标题:" + columnLabel);
//			System.out.println("获得列" + i + "的模式:" + schemaName);
//			System.out.println("获得列" + i + "类型的精确度(类型的长度):" + precision);
//			System.out.println("获得列" + i + "小数点后的位数:" + scale);
//			System.out.println("获得列" + i + "对应的表名:" + tableName);
//			System.out.println("获得列" + i + "是否自动递增:" + isAutoInctement);
//			System.out.println("获得列" + i + "在数据库中是否为货币型:" + isCurrency);
//			System.out.println("获得列" + i + "是否为空:" + isNullable);
//			System.out.println("获得列" + i + "是否为只读:" + isReadOnly);
//			System.out.println("获得列" + i + "能否出现在where中:"+ isSearchable);
  
		} catch (SQLException e) {
		e.printStackTrace();
		}
			


	}

}
