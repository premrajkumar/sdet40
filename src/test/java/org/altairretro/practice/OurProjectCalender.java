package org.altairretro.practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OurProjectCalender {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("//span[text()='Employee']")).click();
		
		/*WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElements());*/
		
	}

}
