package org.altairretro.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.tyss.sales_inventory.Generic.ExcelUtility;
import org.tyss.sales_inventory.Generic.IConstants;

public class TestngBasicTest {
	
	@BeforeClass
	public void main3test()
	{
	System.out.println("Beforeclass basic");	
	}
	
	@AfterClass
	public void main4test()
	{
		System.out.println("Afterclass basic");
	}
	
	@Test(dataProvider = "abcd")
	public void main1test(String un, String pwd)
	{
		//Reporter.log("test1", true);
		System.out.println(un);
		System.out.println(pwd);
		System.out.println("this is thread id"+Thread.currentThread().getId());
	}

	@Test(enabled = false)
	public void main2test()
	{
		Reporter.log("test2", true);
	}
	
	@DataProvider(name = "abcd",parallel = true)
	public Object[][] getData()
	{
		ExcelUtility excel = new ExcelUtility();
		excel.openExcelPage(IConstants.EXCEL);
		String[][] ex = excel.getTwoDimensionalData("Sheet5");
		return ex;
		
	}
}
