package Corepages;
import org.apache.poi.hssf.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
public class Excelread{
	public static File file;
	public static FileInputStream inputStream;
	public  static Workbook testdataworkbook;
	public  static Sheet testdatasheet;
	public static Row row;
	public  static ArrayList<Object[]> l= new ArrayList<Object[]>();
	public static Object k[];
	public  static int rowcount;
	public static int colcount;
	public static Cell cell;
	
	
public static ArrayList<Object[]> initialize(String filepath,String filename,String sheetname)throws Exception {
	//Create an object of File class to open xlsx file
		File file = new File(filepath+"//"+filename);
		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		
		//Find the file extension by splitting file name in substring  and getting only extension name
		String fileExtensionName = filename.substring(filename.indexOf("."));
	    //Check condition if the file is xlsx file
		if(fileExtensionName.equals(".xlsx")){
			//If it is xlsx file then create object of XSSFWorkbook class
			testdataworkbook=new XSSFWorkbook(inputStream);
		}
		//Check condition if the file is xls file
		else if(fileExtensionName.equals(".xls")){
			//If it is xls file then create object of HSSFWorkbook class
			testdataworkbook=new HSSFWorkbook(inputStream);
		}
		//Read sheet inside the workbook by its name
		
	//Create a loop over all the rows of excel file to read it
	//DataFormatter fmt = new DataFormatter();
		Sheet testdatasheet=testdataworkbook.getSheet(sheetname);
		rowcount=testdatasheet.getLastRowNum();
		colcount=testdatasheet.getRow(1).getLastCellNum();
	System.out.println(rowcount);
	System.out.println(colcount);
	for (int i = 1; i <=rowcount; i++) {
		Row row=testdatasheet.getRow(i);
		k=new Object[colcount];
		for(int j=0;j<colcount;j++) {
			cell=row.getCell(j);
			switch(cell.getCellType()) {
			case STRING: {System.out.print(cell.getStringCellValue());
			k[j]=cell.getStringCellValue();
			}break;
			case BOOLEAN:{ System.out.print(cell.getBooleanCellValue());
			k[j]=cell.getBooleanCellValue();
			}break;
			case NUMERIC: {System.out.print(cell.getNumericCellValue());
			k[j]=cell.getNumericCellValue();
			}break;
			}
			System.out.print(" | ");
		}
		l.add(k);
		System.out.println();
}
	return l;
}
}