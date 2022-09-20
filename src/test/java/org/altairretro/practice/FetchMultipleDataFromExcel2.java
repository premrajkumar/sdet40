package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcel2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fileexcel = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		//step-2--> open the excel workbook
		Workbook work = WorkbookFactory.create(fileexcel);
		//step-3--> get the control on sheet
		Sheet page = work.getSheet("commondata");
		DataFormatter df = new DataFormatter();
		for(int i=0;i<=page.getLastRowNum();i++) {
			for(int j=0;j<page.getRow(i).getLastCellNum();j++) {
				System.out.print(df.formatCellValue(page.getRow(i).getCell(j))+"  ||  ");
			}
			System.out.println();
		}
	}

}
