package org.altairretro.practice;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopup {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String requiredDate = "20";//DD
		String requiredMonth = "October";//MMMM--> February, MM--> 02, MMM-->Feb
		String requiredYear = "2021";//yyyy
		int requiredMonthInNumber = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(requiredMonth)
				.get(ChronoField.MONTH_OF_YEAR);
		int requiredyearInNum = Integer.parseInt(requiredYear);
		
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		String actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		String[] str = actualMonthYear.split(" ");
		String actualMonth = str[0];
		String actualYear = str[1];
		int actualMonthInNumber = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth)
				.get(ChronoField.MONTH_OF_YEAR);
		int actualyearInNum = Integer.parseInt(actualYear);
		while(requiredMonthInNumber>actualMonthInNumber || requiredyearInNum>actualyearInNum)
		{
			driver.findElement(By.xpath("//span[.='Next']")).click();
		    actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str = actualMonthYear.split(" ");
			actualMonth = str[0];
			actualYear = str[1];
			actualMonthInNumber = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth)
					.get(ChronoField.MONTH_OF_YEAR);
			actualyearInNum = Integer.parseInt(actualYear);
		}
		while(requiredMonthInNumber<actualMonthInNumber || requiredyearInNum<actualyearInNum)
		{
			driver.findElement(By.xpath("//span[.='Prev']")).click();
		    actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str = actualMonthYear.split(" ");
			actualMonth = str[0];
			actualYear = str[1];
			actualMonthInNumber = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth)
					.get(ChronoField.MONTH_OF_YEAR);
			actualyearInNum = Integer.parseInt(actualYear);
		}
		driver.findElement(By.xpath("//a[text()='"+requiredDate+"']")).click();
	}

}
