package org.altairretro.practice;

import java.util.Map;

import org.tyss.sales_inventory.Generic.ExcelUtility;
import org.tyss.sales_inventory.Generic.IConstants;

public class FetchDataFromMap {

	public static void main(String[] args) {
		ExcelUtility excel = new ExcelUtility();
		excel.openExcelPage(IConstants.EXCEL);
		Map<String, String> map = excel.getDataFromExcelByMap("commondata");
		excel.closeExcelBook();
		System.out.println(map);
	}

}
