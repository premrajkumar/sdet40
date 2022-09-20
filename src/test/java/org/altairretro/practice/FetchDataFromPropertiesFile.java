package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		//step-1-->convert the physical file into java readable object 
		FileInputStream file = new FileInputStream("./src/test/resources/commondatapropertyfile.properties");
		//step-2--> create the object for properties
		Properties pro = new Properties();
		//step-3--> Load all the keys(it will load all the keys and values in hashmap tables)
		pro.load(file);
		//step-4--> fetch the data
		String url = pro.getProperty("url").trim();
		String username = pro.getProperty("username").trim();
		
		System.out.println(url);
		System.out.println(username);
		
	}

}
