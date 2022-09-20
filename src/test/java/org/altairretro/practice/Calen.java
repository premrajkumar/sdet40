package org.altairretro.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tyss.sales_inventory.Generic.WebDriverUtility;

public class Calen {
public static void main(String[] args) throws ParseException {
	String reqdate = "20";
String reqmonthandYea="September 2021";
String url = "https://testleaf.herokuapp.com/pages/Calendar.html";
WebDriver driver = new WebDriverUtility().openBrowserWithApplication("chrome", 15, url);
driver.findElement(By.xpath("//input[@id='datepicker']")).click();
SimpleDateFormat sdf=new SimpleDateFormat("MMMM yyyy");
Date req = sdf.parse(reqmonthandYea);
while(true)
{
String ele = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
 Date cur = sdf.parse(ele);	
if(ele.equalsIgnoreCase(reqmonthandYea))
{
	break;
	}
else if(req.after(cur))
{
//Inspect Next button and click here
	driver.findElement(By.xpath("//span[.='Next']")).click();
}
else
{
//Inspect Previous button and click here
	driver.findElement(By.xpath("//span[.='Prev']")).click();
}
}
// click on reqdate here
driver.findElement(By.xpath("//a[text()='"+reqdate+"']")).click();
}
}
