package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.altairretro.practice.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc1{

	public static void main(String[] args) throws InterruptedException, IOException
	{
		FileInputStream fileexcel = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		//step-2--> open the excel workbook
		Workbook work = WorkbookFactory.create(fileexcel);
		try {
		//step-3--> get the control on sheet
		Sheet page = work.getSheet("commondata");
		//step-4--> get the control on row
		Row row = page.getRow(1);
		Row row1 = page.getRow(2);
		Row row2 = page.getRow(3);
		//step-5--> get the control on cell
		Cell record = row.getCell(2);
		Cell record1 = row1.getCell(2);
		Cell record2 = row2.getCell(2);
		//step-6--> fetch the data
		String firstname = record.getStringCellValue();
		String gender = record1.getStringCellValue();
		String password = record2.getStringCellValue();
		System.out.println(firstname);
		System.out.println(gender);
		System.out.println(password);
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver= new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("unguardable");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Alert a = driver.switchTo().alert();
	a.accept();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//i[@class='fas fa-user fa-sm fa-fw mr-2 text-gray-400']")).click();
	Thread.sleep(2000);
	WebElement name1 = driver.findElement(By.xpath("//div[@id='text']"));
	String r = name1.getText();
	name1.click();
	driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//i[@class='fas fa-cogs fa-sm fa-fw mr-2 text-gray-400']")).click();
	Thread.sleep(2000);
	WebElement ele = driver.findElement(By.xpath("//input[@name='firstname']"));
	ele.sendKeys(Keys.CONTROL+"a");
	ele.sendKeys(firstname);
	WebElement d = driver.findElement(By.xpath("//select[@name='gender']"));
	Select s1=new Select(d);
	s1.selectByVisibleText(gender);
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys(password);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Alert b = driver.switchTo().alert();
	b.accept();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[.='Logout']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("unguardable");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(2000);
	Alert c = driver.switchTo().alert();
	c.accept();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//i[@class='fas fa-user fa-sm fa-fw mr-2 text-gray-400']")).click();
	Thread.sleep(2000);
	WebElement name = driver.findElement(By.xpath("(//div[@id='overlay'])[last()]"));
	String g = name.getText();
	name.click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[.='Logout']")).click();	
	if(g.equals(r))
	{System.out.println("tc is fail");}
	else {
		System.out.println("tc is pass");
	}
	driver.quit();
		}
		finally {
			//step-7--> close the workbook
			work.close();
		}
	}

}
