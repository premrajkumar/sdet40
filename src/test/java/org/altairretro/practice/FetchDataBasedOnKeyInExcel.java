package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataBasedOnKeyInExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		Workbook work = WorkbookFactory.create(file);
		Sheet page = work.getSheet("Sheet2");
		DataFormatter df = new DataFormatter();
		String value=null;
		int i=0;
		while(i<page.getLastRowNum())
		/*for(int i=0;i<=page.getLastRowNum();i++) */{
			String key = df.formatCellValue(page.getRow(i).getCell(0));
			if(key.equalsIgnoreCase("gender")) {
				value = df.formatCellValue(page.getRow(i).getCell(1));
				break;
			}
			i++;
		}
System.out.println(value);
	}

}
