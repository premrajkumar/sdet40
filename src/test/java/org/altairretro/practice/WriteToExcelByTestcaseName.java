package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteToExcelByTestcaseName {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		Workbook work = WorkbookFactory.create(fis);
		Sheet sheet = work.getSheet("Sheet4");
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			String actualTC = sheet.getRow(i).getCell(0).getStringCellValue();
			if(actualTC.equalsIgnoreCase("HI"))
			{
				for(int j=1;j<sheet.getRow(i).getLastCellNum();j++)
				{
					String actualkey = sheet.getRow(i).getCell(j).getStringCellValue();
					if(actualkey.equalsIgnoreCase("Hello"))
					{
						sheet.createRow(i+1).createCell(j).setCellValue("pass");
						break;
					}
				}
				break;
			}	
		}
		FileOutputStream fout = new FileOutputStream("./src/test/resources/fetchdataexcel.xlsx");
		work.write(fout);
		System.out.println("written");
		
	}

}
