package org.altairretro.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio1 {

	public static void main(String[] args) throws IOException {
		String ProductName = "Graphic Print Shorts & T-shirt Set";
		WebDriverManager.chromedriver().setup();
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opts);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.ajio.com/");
		driver.findElement(By.xpath("//a[text()='KIDS']")).click();
		driver.findElement(By.xpath("//a[@target='_self' and @style='position: absolute; left: 0%; top: 0%; width: 100%; height: 100%;' and @href='/s/0-to-2-years-3767-54091']")).click();
		//WebElement ele1 = driver.findElement(By.xpath("//div[text()='Graphic Shorts & T-shirt Set']"));
		WebElement ele = driver.findElement(By.xpath("//div[.='"+ProductName+"']/following-sibling::div/span[@class='price  ']"));
		String price = ele.getText();
		System.out.println(price);
		FileInputStream fileadd = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		Workbook work = WorkbookFactory.create(fileadd);
		Sheet page = work.getSheet("organisation");
		Row row = page.getRow(1);
		row.createCell(1).setCellValue(price);
		FileOutputStream fout = new FileOutputStream("./src/test/resources/fetchdataexcel.xlsx");
		work.write(fout);
		work.close();
		System.out.println("data uploaded successfully");
	}

}
