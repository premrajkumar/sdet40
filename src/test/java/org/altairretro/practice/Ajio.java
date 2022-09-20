package org.altairretro.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws AWTException, EncryptedDocumentException, IOException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/");
		//driver.findElement(By.xpath("//div[@class='ic-close-quickview']")).click();
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_ESCAPE);
		rb.keyRelease(KeyEvent.VK_ESCAPE);
		//driver.findElement(By.xpath("//span[text()='Allow Location']")).click();
		driver.findElement(By.xpath("//a[text()='KIDS']")).click();
		driver.findElement(By.xpath("//a[@target='_self' and @style='position: absolute; left: 0%; top: 0%; width: 100%; height: 100%;' and @href='/s/0-to-2-years-3767-54091']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//div[text()='Graphic Shorts & T-shirt Set']"));
		String text1 = ele1.getText();
		WebElement ele = driver.findElement(By.xpath("//div[.='Graphic Shorts & T-shirt Set']/following-sibling::div/span[@class='price  ']"));
		String text = ele.getText();
		System.out.println(text1);
		System.out.println(text);
		driver.close();
		FileInputStream fileadd = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		Workbook work = WorkbookFactory.create(fileadd);
		Sheet page = work.getSheet("organisation");
		Row row = page.createRow(1);
		row.createCell(0).setCellValue(text1);
		row.createCell(1).setCellValue(text);
		FileOutputStream fout = new FileOutputStream("./src/test/resources/fetchdataexcel.xlsx");
		work.write(fout);
		work.close();
		System.out.println("data uploaded successfully");
	}

}
