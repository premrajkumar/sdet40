package org.altairretro.practice;

import org.tyss.sales_inventory.Generic.ExcelUtility;
import org.tyss.sales_inventory.Generic.IConstants;

public class WriteToExcel {

	public static void main(String[] args) {
		ExcelUtility excel = new ExcelUtility();
		excel.openExcelPage(IConstants.EXCEL);
		excel.setDataToExcel("Sheet4", 0, 0, "HI");
		excel.writeDataToUpdatedExcel("Sheet4", 0, 1, "Hello");
		excel.saveData(IConstants.EXCEL);
		excel.closeExcelBook();
		System.out.println("Data printed");
	}

}
