package org.tyss.sales_inventory.Generic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * this class consists all java reusable actions
 * @author PREM KUMAR R
 *
 */
public class JavaUtility {
	
	/**
	 * this method is used to generate the random number
	 * @param bound
	 * @return
	 */
	public int getRandomNumber(int bound)
	{
	return new Random().nextInt(bound);
	}
	
	/**
	 * this method is used to convert a string data into any data type format
	 * @param value1
	 * @param strategy
	 * @return
	 */
	public Object convertstringToanyDataType(String value1,DataType strategy)
	{   
		Object obj=null;
		if(strategy.toString().equalsIgnoreCase("long"))
		{
			obj = Long.parseLong(value1);
		}
		if(strategy.toString().equalsIgnoreCase("int"))
		{
			obj = Integer.parseInt(value1);
		}
		
		return obj;
	}
	
	/**
	 * this method is used to convert the integer data into string format
	 * @param i
	 * @return
	 */
	public String convertIntTostring(int i)
	{
		String value = Integer.toString(i);
		return value;
	}
	
	/**
	 * this method is used to display system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date date = new Date();
		return date.toString();
	}
	
	/**
	 * this method is used to give custom time duration and to handle the exception and perform click action
	 * @param element
	 */
	public void toGiveCustomTimeAndClick(WebElement element)
	{
		int count=0;
		int duration=15;
		while(count<duration)
		{
			try {
			element.click();
			break;
			}
			catch(Exception e)
			{
				try {
					Thread.sleep(1000);			//polling time
				} 
				catch (InterruptedException e1) 
				{
					e1.printStackTrace();
				}
				count++;
			}	
		}
	}
	
	
	public String toGiveCustomTimeOnElement(WebElement element1)
	{
		String text=null;
		int count1=0;
		int duration1=15;
		while(count1<duration1)
		{
			try {
			text = element1.getText();
			break;
			}
			catch(Exception e)
			{
				try {
					Thread.sleep(1000);			//polling time
				} 
				catch (InterruptedException e1) 
				{
					e1.printStackTrace();
				}
				count1++;
			}	
		}
		return text;
	}
	
	public String currentTime()
	{
		Date dat = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
		String actDate = sf.format(dat);
		return actDate;
		
	}
}
