package org.altairretro.practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {
String browser = "chrome";
WebDriver driver=null;
/*
if(browser.equalsIgnoreCase("Firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}
else if(browser.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
else {
	System.out.println("Please Enter valid Browser Key");
}
*/
switch (browser) {
case "firefox":WebDriverManager.firefoxdriver().setup();
driver=new FirefoxDriver();
	break;
case "chrome":WebDriverManager.chromedriver().setup();
driver= new ChromeDriver();
break;
default:System.out.println("Please Enter Valid Browser Key");
	break;
}
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("http://rmgtestingserver:8888");
	}

}
