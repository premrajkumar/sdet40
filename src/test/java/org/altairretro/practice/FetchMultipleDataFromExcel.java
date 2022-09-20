package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		Workbook work = WorkbookFactory.create(file);
		Sheet page = work.getSheet("Sheet2");
		DataFormatter df = new DataFormatter();
		for(int i=0;i<=page.getLastRowNum();i++)
		{
			for(int j=0;j<page.getRow(i).getLastCellNum();j++)
			{
				System.out.println(df.formatCellValue(page.getRow(i).getCell(j))+"  ||  ");
			}
			System.out.println();
		}

	}

}
