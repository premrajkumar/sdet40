package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step-1--> convert the physical file into java readable object
		FileInputStream fileexcel = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		//step-2--> open the excel workbook
		Workbook work = WorkbookFactory.create(fileexcel);
		try {
		//step-3--> get the control on sheet
		Sheet page = work.getSheet("commondata");
		//step-4--> get the control on row
		Row row = page.getRow(1);
		Row row1 = page.getRow(2);
		Row row2 = page.getRow(3);
		//step-5--> get the control on cell
		Cell record = row.getCell(2);
		Cell record1 = row1.getCell(2);
		Cell record2 = row2.getCell(2);
		//step-6--> fetch the data
		String firstname = record.getStringCellValue();
		String gender = record1.getStringCellValue();
		String password = record2.getStringCellValue();
		System.out.println(firstname);
		System.out.println(gender);
		System.out.println(password);
		}
		finally {
		//step-7--> close the workbook
		work.close();
		}

	}

}
