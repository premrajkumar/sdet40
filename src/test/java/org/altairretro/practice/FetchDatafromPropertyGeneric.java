package org.altairretro.practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.tyss.sales_inventory.Generic.FileUtility;
import org.tyss.sales_inventory.Generic.IConstants;

public class FetchDatafromPropertyGeneric {

	public static void main(String[] args) {
		String url = new FileUtility().getDataFromProperty(IConstants.PROPERTY_FILE, "url");
		System.out.println(url);
		String username = new FileUtility().getDataFromProperty(IConstants.PROPERTY_FILE, "username");
		System.out.println(username);
		String password = new FileUtility().getDataFromProperty(IConstants.PROPERTY_FILE, "password");
		System.out.println(password);
		/*//step-1-->convert the physical file into java readable object 
				FileInputStream file = new FileInputStream("./src/test/resources/commondatapropertyfile.properties");
				//step-2--> create the object for properties
				Properties pro = new Properties();
				//step-3--> Load all the keys(it will load all the keys and values in hashmap tables)
				pro.load(file);
				//step-4--> fetch the data
				String url = pro.getProperty("url").trim();
				String username = pro.getProperty("username").trim();
				
				System.out.println(url);
				System.out.println(username);*/
				

	}

}
