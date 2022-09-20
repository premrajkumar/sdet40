package org.altairretro.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.tyss.sales_inventory.Generic.ExcelUtility;
import org.tyss.sales_inventory.Generic.IConstants;

public class FetchDatabyGenericExcel {

	public static void main(String[] args) {
		String firstname = new ExcelUtility().getDataFromExcel(IConstants.EXCEL,"commondata", 1, 2);
		System.out.println(firstname);
		String gender = new ExcelUtility().getDataFromExcel(IConstants.EXCEL,"commondata", 2, 2);
		System.out.println(gender);
		String password = new ExcelUtility().getDataFromExcel(IConstants.EXCEL,"commondata", 3, 2);
		System.out.println(password);
		
				/*FileInputStream fileexcel = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
				Workbook work = WorkbookFactory.create(fileexcel);
				Sheet page = work.getSheet("commondata");
				Row row = page.getRow(1);
				Row row1 = page.getRow(2);
				Row row2 = page.getRow(3);
				
				Cell record = row.getCell(2);
				Cell record1 = row1.getCell(2);
				Cell record2 = row2.getCell(2);
				String firstname = record.getStringCellValue();
				String gender = record1.getStringCellValue();
				String password = record2.getStringCellValue();
				System.out.println(firstname);
				System.out.println(gender);
				System.out.println(password);*/

	}

}
