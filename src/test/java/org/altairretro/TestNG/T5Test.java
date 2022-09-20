package org.altairretro.TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.tyss.sales_inventory.Generic.BaseClass;
import org.tyss.sales_inventory.Generic.WebDriverUtility;

public class T5Test extends BaseClass{

	@Test
	public void main()
	{
//		WebDriverUtility web = new WebDriverUtility();
//		String url = "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php";
//		WebDriver driver = web.openBrowserWithApplication("chrome", 15, url);
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
//		//Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
//		//Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String cashun = file.getDataFromPropertyAfterIntialize("Cashierusername");
		String cashpwd = file.getDataFromPropertyAfterIntialize("Cashierpassword");
		login.loginIntoApplication(cashun, cashpwd);
		//Thread.sleep(2000);
		/*Alert a = driver.switchTo().alert();
		a.accept();*/
		web.alertinit();
		web.toHandleAlert();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[.='Headset']")).click();
		com.clickHeadsetCategoryTab();
		//Thread.sleep(2000);
		//WebElement add = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
//		WebElement add = driver.findElement(By.xpath("//div[@id='headset']//div[@class='col-sm-4 col-md-2']//h6[text()='Rpee15']/following-sibling::input[@name='quantity']"));
		WebElement add = com.addQuantity();
		//add.sendKeys(Keys.CONTROL+"a");
		web.toClearDataInTextBox(add);
		add.sendKeys("2");
//		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//input[@class='btn btn-info'])[4]")).click();
		//driver.findElement(By.xpath("//div[@id='headset']//div[@class='col-sm-4 col-md-2']//h6[text()='Rpee15']/following-sibling::input[@name='quantity']/following-sibling::input[@value='Add']")).click();
		//Thread.sleep(2000);
		com.clickAddButton();
		//driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
		com.customerAddButton();
		driver.findElement(By.xpath("(//h5[.='Add Customer']/../following-sibling::div//input[@name='firstname'])[2]")).sendKeys("ega");
		driver.findElement(By.xpath("(//input[@placeholder='Last Name'])[2]")).sendKeys("rona");
		driver.findElement(By.xpath("(//input[@placeholder='Phone Number'])[2]")).sendKeys("855214477");
		driver.findElement(By.xpath("(//button[.='Save'])[2]")).click();
		driver.switchTo().alert().accept();
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
		/*Alert alt =driver.switchTo().alert();
		alt.accept();*/
		web.toHandleAlert();
		driver.findElement(By.xpath("//span[text()='Customer']")).click();
		String txt =driver.findElement(By.xpath("//li[@class='paginate_button page-item '][last()]/a")).getText();
		int c = Integer.parseInt(txt);
		System.out.println(c);
		int count=0;
		for(int i=1;i<c;i++) 
		{
			
			List<WebElement> ele3 = driver.findElements(By.xpath("//table//th[text()='Last Name']/ancestor::thead/following-sibling::tbody//td[2]"));
			for(WebElement a:ele3)   
			{
				//System.out.println(a.getText());
				if(a.getText().equalsIgnoreCase("rona"))
				{

					System.out.println("Tc is pass");
					count++;
					break;
				}
			}
			if(count==1) {
				break;
			}
			driver.findElement(By.xpath("//a[text()='Next']")).click();
		}
		if(count==0) {
			System.out.println("TC is Fail");
		}
	}
	}

