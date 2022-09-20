package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc2 {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		FileInputStream fileexcel = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		//step-2--> open the excel workbook
		Workbook work = WorkbookFactory.create(fileexcel);
		try {
		//step-3--> get the control on sheet
		Sheet page = work.getSheet("Sheet3");
		//step-4--> get the control on row
		Row row = page.getRow(1);
		Row row1 = page.getRow(2);
		//step-5--> get the control on cell
		Cell record = row.getCell(2);
		Cell record1 = row1.getCell(2);
		//step-6--> fetch the data
		String addo = record.getStringCellValue();
		String custo = record1.getStringCellValue();
		System.out.println(addo);
		System.out.println(custo);
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(2000);
		Alert a = driver.switchTo().alert();
		a.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Headset']")).click();
		//Thread.sleep(2000);
		WebElement add = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		add.sendKeys(Keys.CONTROL+"a");
		add.sendKeys(addo);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='btn btn-info'])[4]")).click();
		//Thread.sleep(2000);
		WebElement customer = driver.findElement(By.xpath("//select[@name='customer']"));
		//Thread.sleep(2000);
		Select cust = new Select(customer);
		cust.selectByVisibleText(custo);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='SUBMIT']")).click();
		//Thread.sleep(2000);
		WebElement cost = driver.findElement(By.xpath("//h3[@class='font-weight-bold py-3 bg-light']"));
		Thread.sleep(2000);
		String amount = cost.getText();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtNumber']")).sendKeys(amount);
		Thread.sleep(20000);
		driver.findElement(By.xpath("//button[.='PROCEED TO PAYMENT']")).click();
		Thread.sleep(2000);
		Alert b = driver.switchTo().alert();
		b.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("unguardable");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin" );
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='btnlogin']")).click();
		Alert alt =driver.switchTo().alert();
		alt.accept();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Transaction']")).click();
		List<WebElement> ele1 = driver.findElements(By.xpath("//ul[@class='pagination']/li"));
		int count = ele1.size();
		System.out.println(count);
		for(int i=1;i<=(count-3);i++)
		{
			driver.findElement(By.xpath("//a[text()='Next']")).click();
		}
		List<WebElement> ele = driver.findElements(By.xpath("//table//th[text()='Customer']/ancestor::thead/following-sibling::tbody//td[2]"));
		for(WebElement custom:ele)
		{
			String data = custom.getText();
			System.out.println(data);
			if(data.equals(custo))
					{
				System.out.println("testcase pass");
					}
			else
			{
				System.out.println("testcase fail");
					}
		}
		driver.quit();
		}
		finally {
			work.close();
		}

	}

}
