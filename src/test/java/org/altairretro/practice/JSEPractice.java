package org.altairretro.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tyss.sales_inventory.Generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSEPractice {

	public static void main(String[] args) {
		WebDriverUtility wdu = new WebDriverUtility();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        wdu.intializeJavascriptExecutor(driver);
        wdu.launchApplication("https://www.makemytrip.com/");
        driver.manage().window().maximize();
    	//driver.findElement(By.xpath("//span[@class='langCardClose']"));
        wdu.clickUsingJS(driver.findElement(By.xpath("//span[@class='langCardClose']")));
        //driver.findElement(By.xpath("//span[text()='From']")).click();
        wdu.clickUsingJS(driver.findElement(By.xpath("//span[text()='From']")));
        //driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("BOM");
        wdu.sendKeysUsingJS(driver.findElement(By.xpath("//input[@placeholder='From']")), "BOM");
        //driver.findElement(By.xpath("//div[text()='BOM']")).click();
        wdu.clickUsingJS(driver.findElement(By.xpath("//div[text()='BOM']")));
        //driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("DEL");
        String To = "DEL";
        wdu.sendKeysUsingJS(driver.findElement(By.xpath("//input[@placeholder='To']")), To);
        //driver.findElement(By.xpath("//div[text()='"+To+"']")).click();
        wdu.clickUsingJS(driver.findElement(By.xpath("//div[text()='"+To+"']")));
        wdu.scrollTillElementUsingJS(driver.findElement(By.xpath("//p[text()='Product Offering']")));
	}

}
