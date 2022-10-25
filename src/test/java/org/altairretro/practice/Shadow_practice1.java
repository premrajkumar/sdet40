package org.altairretro.practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shadow_practice1 {
	
	@Test
	public void main1()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://watir.com/examples/shadow_dom.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = (WebElement)js.executeScript("return document.querySelector('#shadow_host').shadowRoot.querySelector('input[type=text]:nth-child(4)')");
		ele.sendKeys("hello");
		
	}

}
