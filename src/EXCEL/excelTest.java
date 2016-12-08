package EXCEL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelTest {
	public static boolean write(String outPath) throws IOException{
		Boolean result = true;
		String fileType = outPath.substring(outPath.lastIndexOf('.')+1);
		Workbook newExcel = null;
		if("xls".equals(fileType)){
			newExcel = new HSSFWorkbook();
		}else if("xlsx".equals(fileType)){
			newExcel = new XSSFWorkbook();
		}else{
			System.out.println("There is a error in fileType");
			result = false;
		}
		
		CreationHelper create = newExcel.getCreationHelper();
		CellStyle cellstyle = newExcel.createCellStyle();
		cellstyle.setDataFormat(create.createDataFormat().getFormat("yyyy-mm-dd HH:mm:ss:SSS"));
		
//		//创建表
//		Sheet sheet1 = (Sheet) newExcel.createSheet("第一个表");
//		for(int i=0; i<533; ++i){
//			Row rowTest = sheet1.createRow(i);
//			
//			for(int j=0; j<10; ++j){
//				Cell cellTest = rowTest.createCell(j);
//				cellTest.setCellValue( new Date());
//				cellTest.setCellStyle(cellstyle);
//			}
//		}
		
		
		//随访覆盖率统计表
		Sheet sheet2 = (Sheet) newExcel.createSheet("随访覆盖率");
		//设定字体
		Font font = newExcel.createFont();
		font.setFontHeightInPoints((short)15);
		font.setFontName("等线");
		
		CellStyle fontStyle1 = newExcel.createCellStyle();
		fontStyle1.setFont(font);
		fontStyle1.setAlignment(CellStyle.ALIGN_CENTER);
		fontStyle1.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		
		sheet2.addMergedRegion(new CellRangeAddress(0,1,0,3));
		Row row1 = sheet2.createRow(0);
		Cell cell11 = row1.createCell(0);
		cell11.setCellValue("随访覆盖率统计报表");
		cell11.setCellStyle(fontStyle1);
		
		
		Row row2 = sheet2.createRow(2);
		Cell cell21 = row2.createCell(0);
		cell21.setCellValue("出院人次：");
		sheet2.addMergedRegion(new CellRangeAddress(2,2,0,3));
		
		
		
		
		
		//创建文件流
		OutputStream stream = new FileOutputStream( outPath );
		newExcel.write(stream);
		stream.close();
		
		System.out.println("创建EXCEL成功");
		return result;
	}
	
	
	
	
	public static void read(String filePath) throws IOException{
		
	}
	
	

	public static void main(String[] args) {
		try{
			System.out.println("2016-01-01".substring(5,7));
			
			System.out.println("499".length());
			
			
			
//			excelTest.write("D:/xx3.xls");
		}catch (Exception e){
			e.printStackTrace();
		}
		

	}

}
