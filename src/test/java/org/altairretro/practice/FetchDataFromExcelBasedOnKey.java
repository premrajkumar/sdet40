package org.altairretro.practice;

import org.tyss.sales_inventory.Generic.ExcelUtility;
import org.tyss.sales_inventory.Generic.IConstants;

public class FetchDataFromExcelBasedOnKey {

	public static void main(String[] args) {
		ExcelUtility excel = new ExcelUtility();
		excel.openExcelPage(IConstants.EXCEL);
		String value = excel.getDataFromExcel("Sheet3", "customer");
	System.out.println(value);
	}
	

}
