package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fetchbydataformatter {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fileexcel = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		Workbook work = WorkbookFactory.create(fileexcel);
		DataFormatter df = new DataFormatter();
		
		String data = df.formatCellValue(work.getSheet("Sheet1").getRow(0).getCell(0));
		System.out.println(data);
		

	}

}
