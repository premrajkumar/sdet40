package org.altairretro.practice;

import java.util.List;

import org.tyss.sales_inventory.Generic.DB_Utility;

public class Get_and_SetDataInto_DB {

	public static void main(String[] args) {
		DB_Utility DBU = new DB_Utility();
		DBU.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
		List<String> arr = DBU.getDataFromDb("select * from sdet40;", "Emp_name");
		for(String d:arr)
		{
			System.out.println(d);
		}
		DBU.setDataToDataBase("insert into sdet40 values(901,'raju', 41785236,'bagalkot');");
		List<String> brr = DBU.getDataFromDb("select * from sdet40;", "Emp_name");
		for(String b:brr)
		{
			System.out.println(b);
		}
		boolean result = DBU.verifyDataInsideDatabase("select * from sdet40;", "Emp_name", "raju");
		System.out.println(result);
		DBU.closeConnection();
	}

}
