package org.altairretro.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.tyss.sales_inventory.Generic.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc3 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		JavaUtility jv=new JavaUtility();
		String productname = "dsacd"+jv.getRandomNumber(2000);
		String productcategory = "mouse";
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		/*driver.findElement(By.xpath("//input[@type='text']")).sendKeys("unguardable");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		Alert a = driver.switchTo().alert();
		a.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Product']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Product Code']")).sendKeys("74454");
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(productname);
		driver.findElement(By.xpath("//textarea[@placeholder='Description']")).sendKeys("vfvf");
		driver.findElement(By.xpath("//input[@placeholder='Quantity']")).sendKeys("4");
		driver.findElement(By.xpath("//input[@placeholder='On Hand']")).sendKeys("2");
		driver.findElement(By.xpath("//input[@placeholder='Price']")).sendKeys("300");
		WebElement category = driver.findElement(By.xpath("//select[@name='category']"));
		category.click();
		Select cat=new Select(category);
		cat.selectByVisibleText("Mouse");
		Thread.sleep(2000);
		WebElement supplier = driver.findElement(By.xpath("//select[@name='supplier']"));
		supplier.click();
		Select supply = new Select(supplier);
		supply.selectByVisibleText("Razer Co.");
		Thread.sleep(2000);
		WebElement dateclick = driver.findElement(By.name("datestock"));
		dateclick.click();
		dateclick.sendKeys("04082022");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Date Stock In']/parent::div/following-sibling::button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400']")).click();
		driver.findElement(By.xpath("//a[.='Logout']")).click();*/
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		Alert b = driver.switchTo().alert();
		b.accept();
		Thread.sleep(2000);
		/*driver.findElement(By.xpath("//a[text()='Mouse']")).click();
		//WebElement ele1 = driver.findElement(By.xpath("//div[@class='row']/following::h6[.='"+productname+"']/ancestor::div[@id='"+productcategory+"']"));
		WebElement ele1 = driver.findElement(By.xpath("//div[@id='"+productcategory+"']//following::h6[.='"+productname+"']"));
		String product = ele1.getText();
		String[] str=product.split("\n");
		if(str[0].toString().equalsIgnoreCase(productname))
		{
			System.out.println("TEstCAse is pass");
		}
		else
		{
			System.out.println("TC IS FAIL");
		}*/
		driver.findElement(By.xpath("//a[text()='Headset']")).click();
		WebElement ele2 = driver.findElement(By.xpath("//div[@id='headset']//following::h6[.='Rpee15']"));
		String productnm = ele2.getText();
		System.out.println(productnm);
		if(productnm.equalsIgnoreCase("Rpee15"))
		{
			System.out.println("Tc is pass");
		}
		else
		{
			System.out.println("Tc is fail");
		}
	}

}
