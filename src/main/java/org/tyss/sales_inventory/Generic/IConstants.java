package org.tyss.sales_inventory.Generic;

/**
 * this interface consists all the external file paths
 * @author PREM KUMAR R
 *
 */
public interface IConstants {
String PROJECT_PATH=System.getProperty("user.dir");
 String EXCEL=PROJECT_PATH+"/src/test/resources/fetchdataexcel.xlsx";
 String PROPERTY_FILE=PROJECT_PATH+"/src/test/resources/commondatapropertyfile.properties";
 String DB_URL="jdbc:mysql://localhost:3306/tyss";
 

}
