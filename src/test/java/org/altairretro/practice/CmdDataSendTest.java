package org.altairretro.practice;

import org.testng.annotations.Test;
import org.tyss.sales_inventory.Generic.WebDriverUtility;

public class CmdDataSendTest {
	@Test
	public void step1Test()
	{
		String browser=System.getProperty("b");
		String url=System.getProperty("u");
		System.out.println("browser name is ===> " +browser);
		System.out.println("ur is ===> "+url);
		WebDriverUtility webdriverutility= new WebDriverUtility();
		webdriverutility.openBrowserWithApplication(browser, 10l, url);
	}

}
