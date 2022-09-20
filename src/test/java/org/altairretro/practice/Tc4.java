package org.altairretro.practice;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sdet40.Sales_Inventory.ObjectRepository.CommonPage;
import org.sdet40.Sales_Inventory.ObjectRepository.EditUserInfo;
import org.sdet40.Sales_Inventory.ObjectRepository.LoginPage;
import org.tyss.sales_inventory.Generic.ExcelUtility;
import org.tyss.sales_inventory.Generic.FileUtility;
import org.tyss.sales_inventory.Generic.IConstants;
import org.tyss.sales_inventory.Generic.JavaUtility;
import org.tyss.sales_inventory.Generic.WebDriverUtility;

public class Tc4 {

	public static void main(String[] args) throws InterruptedException {
		JavaUtility jv=new JavaUtility();
		ExcelUtility excel = new ExcelUtility();
		WebDriverUtility web = new WebDriverUtility();
		FileUtility file = new FileUtility();
		String cashun = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Cashierusername");
		System.out.println(cashun);
		String cashpwd = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Cashierpassword");
		System.out.println(cashpwd);
		String url = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Appurl");
		System.out.println(url);
		excel.openExcelPage(IConstants.EXCEL);
		Map<String, String> data = excel.getDataFromExcelByMap("Cashier");
		System.out.println(data);
		String cashfirstname = excel.getDataFromExcel(IConstants.EXCEL, "Cashier", 1, 1);
		System.out.println(cashfirstname);
		String cashgender = excel.getDataFromExcel(IConstants.EXCEL, "Cashier", 2, 1);
		System.out.println(cashgender);
		String cashpassword = excel.getDataFromExcel(IConstants.EXCEL, "Cashier", 3, 1);
		System.out.println(cashpassword);
		WebDriver driver = web.openBrowserWithApplication("chrome", 15, url);
		LoginPage login = new LoginPage(driver);
		CommonPage com = new CommonPage(driver);
		EditUserInfo edit = new EditUserInfo(driver);
		/*driver.findElement(By.xpath("//input[@type='text']")).sendKeys(cashun);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(cashpwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();*/
		/*Alert b = driver.switchTo().alert();
		b.accept();*/
		login.loginIntoApplication(cashun, cashpwd);
		web.alertinit();
		web.toHandleAlert();
		//Thread.sleep(2000);
		/*driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fas fa-user fa-sm fa-fw mr-2 text-gray-400']")).click();
		//Thread.sleep(2000);
		WebElement name1 = driver.findElement(By.xpath("//div[@id='text']"));
		String r = name1.getText();
		name1.click();
		driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fas fa-cogs fa-sm fa-fw mr-2 text-gray-400']")).click();
		//Thread.sleep(2000);*/
		com.profileImage();
		com.profileButton();
		String r = com.getProfileText();
		com.clickOnProfileText();
		com.profileImage();
		com.settingButton();
		
		//WebElement ele = driver.findElement(By.xpath("(//input[@placeholder='First Name'])[4]"));
		WebElement ele = edit.fetchCashFirstNameTF();
		web.toClearDataInTextBox(ele);
		edit.cashFirstNameTF(cashfirstname);
		//ele.sendKeys(Keys.CONTROL+"a");
		//ele.sendKeys(cashfirstname);
		//WebElement d = driver.findElement(By.xpath("(//select[@name='gender'])[2]"));
		WebElement d = edit.fetchCashGenderTF();
		web.selectDropdown(d, cashgender);
		/*Select s1=new Select(d);
		s1.selectByVisibleText(gender);*/
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys(password);
		/*driver.findElement(By.xpath("//input[@name='password']")).sendKeys(cashpassword);
		driver.findElement(By.xpath("(//button[text()='Save'])[4]")).click();*/
		edit.cashPasswordTF(cashpassword);
		edit.clickCashSaveButton();
		/*Alert b = driver.switchTo().alert();
		b.accept();*/
		web.toHandleAlert();
		//Thread.sleep(2000);
		/*driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		//Thread.sleep(2000);*/
		com.profileImage();
		com.logoutButton();
		com.logoutConfirmButton();
		login.loginIntoApplication(cashun, cashpwd);
		/*driver.findElement(By.xpath("//input[@type='text']")).sendKeys(cashun);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(cashpwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();*/
		//Thread.sleep(2000);
		/*Alert c = driver.switchTo().alert();
		c.accept();*/
		web.toHandleAlert();
		/*Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fas fa-user fa-sm fa-fw mr-2 text-gray-400']")).click();
		//Thread.sleep(2000);
		WebElement name = driver.findElement(By.xpath("(//div[@id='overlay'])[last()]"));*/
		com.profileImage();
		com.profileButton();
		String g = com.getProfileText();
		com.clickOnProfileText();
		//String g = name.getText();
		//name.click();
		//Thread.sleep(2000);
		/*driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Logout']")).click();*/
		com.profileImage();
		com.logoutButton();
		com.logoutConfirmButton();
		if(g.equals(r))
		{System.out.println("tc is fail");
		}
		else {
			System.out.println("tc is pass");
		}
		//driver.quit();
		web.closeTheApplication(driver);
			}
	}

