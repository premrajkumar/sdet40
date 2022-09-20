package org.altairretro.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataIntoDataBase {

	public static void main(String[] args) throws SQLException {
		//step1--> create the object for driver
				Driver dbdriver=new Driver();
				//step2--> register the driver instance to the jdbc
				DriverManager.registerDriver(dbdriver);
				//step3--> get/establish the database connection
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
				try {
					//step4--> create the statement
					Statement statement = connection.createStatement();
					//step5--> execute the query 
					int result = statement.executeUpdate("insert into sdet40 values(3000, 'swaraj',99987451,'bangalur');");
					//step6-->verify or iterate or fetch the data
					if(result==1) {
						System.out.println(result+"dataupdated succesfully");
				}}
				finally {
					connection.close();
					System.out.println("connection closed successfully");
					
	}
				
				}

}
