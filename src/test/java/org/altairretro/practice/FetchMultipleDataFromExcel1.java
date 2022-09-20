package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcel1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		Workbook work = WorkbookFactory.create(file);
		Sheet page = work.getSheet("Sheet2");
		DataFormatter df = new DataFormatter();
		String[][] crr= new String[page.getLastRowNum()+1][page.getRow(5).getLastCellNum()];
		for(int i=0;i<=page.getLastRowNum();i++)
		{
			for(int j=0;j<page.getRow(5).getLastCellNum();j++) {
				crr[i][j]=df.formatCellValue(page.getRow(i).getCell(j));
			}
		}
		for(int i=0;i<=page.getLastRowNum();i++) {
			for(int j=0;j<page.getRow(5).getLastCellNum();j++) {
				System.out.println(crr[i][j]);
			}
			
		}

	}

}
