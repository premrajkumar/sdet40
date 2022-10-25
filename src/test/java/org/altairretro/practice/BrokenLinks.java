package org.altairretro.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.tyss.sales_inventory.Generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BrokenLinks {

	@Test
	public void brokenlinks()
	{
		WebDriverUtility web= new WebDriverUtility();
		WebDriver driver = web.openBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[.='x']")).click();
		
	}
}
