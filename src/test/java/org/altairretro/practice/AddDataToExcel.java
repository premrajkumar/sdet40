package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AddDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step-1--> convert the physical file into java readable object
		FileInputStream fileadd = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		//step-2--
		Workbook work = WorkbookFactory.create(fileadd);
		Sheet page = work.getSheet("organisation");
		page.createRow(0).createCell(2).setCellValue("1234");
		FileOutputStream fout = new FileOutputStream("./src/test/resources/fetchdataexcel.xlsx");
		work.write(fout);
		work.close();
		

	}

}
