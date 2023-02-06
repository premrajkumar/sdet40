package org.altairretro.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.tyss.sales_inventory.Generic.ExcelUtility;
import org.tyss.sales_inventory.Generic.IConstants;

public class DataProviderPractice {
	@Test(dataProvider ="efgh")
	public void main(String a, String b)
	{
		System.out.println("username is "+a);
		System.out.println("password is "+b);
	}
	
	
	@DataProvider(name = "efgh")
	public Object[][] getData()
	{
		ExcelUtility excel = new ExcelUtility();
		excel.openExcelPage(IConstants.EXCEL);
		String[][] data = excel.getTwoDimensionalData("Sheet5");
		return data;
		
	}

}
