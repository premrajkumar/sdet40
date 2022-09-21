package org.altairretro.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Makemytrip1 {

	public static void main(String[] args) {
		//changes done by engg1
		//changes done by engg-2
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String Fromdata = "BOM";
		String Todata = "DEL";
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Fromdata);
		driver.findElement(By.xpath("//div[text()='"+Fromdata+"']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(Todata);
		driver.findElement(By.xpath("//div[text()='"+Todata+"']")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
	}

}
