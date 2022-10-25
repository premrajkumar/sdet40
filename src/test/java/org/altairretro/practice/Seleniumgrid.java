package org.altairretro.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Seleniumgrid {

	@Test
	public void test1()
	{
		URL url=null;
		try {
			url = new URL("http://192.168.218.132:4444/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DesiredCapabilities dir= new DesiredCapabilities();
		dir.setBrowserName("chrome");
		dir.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver = new RemoteWebDriver(url, dir);
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
	}
}
