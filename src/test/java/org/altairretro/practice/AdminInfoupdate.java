package org.altairretro.practice;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.sdet40.Sales_Inventory.ObjectRepository.EditUserInfo;
import org.testng.annotations.Test;
import org.tyss.sales_inventory.Generic.BaseClass;

public class AdminInfoupdate extends BaseClass{

	@Test(groups="e")
	public void main() throws EncryptedDocumentException, IOException, InterruptedException
	{
//		ExcelUtility excel = new ExcelUtility();
//		WebDriverUtility web = new WebDriverUtility();
//		FileUtility file = new FileUtility();
		/*String firstname = excel.getDataFromExcel(IConstants.EXCEL, "commondata", 1, 2);
		System.out.println(firstname);
		String gender = excel.getDataFromExcel(IConstants.EXCEL, "commondata", 2, 2);
		System.out.println(gender);
		String password = excel.getDataFromExcel(IConstants.EXCEL, "commondata", 3, 2);
		System.out.println(password);*/
		Map<String, String> map = excel.getDataFromExcelByMap("commondata");
		System.out.println(map);
//		String adminusername = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Adminusername");
//		System.out.println(adminusername);
//		 String adminpassword = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Adminpassword");
//		 System.out.println(adminpassword);
		String adminusername = file.getDataFromPropertyAfterIntialize("Adminusername");
		String adminpassword = file.getDataFromPropertyAfterIntialize("Adminpassword");
		/*FileInputStream fileexcel = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		//step-2--> open the excel workbook
		Workbook work = WorkbookFactory.create(fileexcel);
		try {
		//step-3--> get the control on sheet
		Sheet page = work.getSheet("commondata");
		//step-4--> get the control on row
		Row row = page.getRow(1);
		Row row1 = page.getRow(2);
		Row row2 = page.getRow(3);
		//step-5--> get the control on cell
		Cell record = row.getCell(2);
		Cell record1 = row1.getCell(2);
		Cell record2 = row2.getCell(2);
		//step-6--> fetch the data
		String firstname = record.getStringCellValue();
		String gender = record1.getStringCellValue();
		String password = record2.getStringCellValue();
		System.out.println(firstname);
		System.out.println(gender);
		System.out.println(password);*/
	//WebDriverManager.firefoxdriver().setup();
	//WebDriver driver= new FirefoxDriver();
	//String url = "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php";
//	String url = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Appurl");
//	System.out.println(url);
//	WebDriver driver = web.openBrowserWithApplication("chrome", 30, url);
	//driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	/*driver.findElement(By.xpath("//input[@type='text']")).sendKeys(adminusername);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(adminpassword);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	/*Alert a = driver.switchTo().alert();
	a.accept();*/
//	LoginPage login=new LoginPage(driver);
//	CommonPage com= new CommonPage(driver);
	EditUserInfo edit= new EditUserInfo(driver);
	login.loginIntoApplication(adminusername, adminpassword);
	web.alertinit();
	web.toHandleAlert();
	web.verifyWebPage(com.homebutton(), "Home", driver, com.homebutton());
	//Thread.sleep(2000);
	/*driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
	//Thread.sleep(2000);
	driver.findElement(By.xpath("//i[@class='fas fa-user fa-sm fa-fw mr-2 text-gray-400']")).click();
	//Thread.sleep(2000);
	WebElement name1 = driver.findElement(By.xpath("//div[@id='text']"));*/
	com.profileImage();
	com.profileButton();
	String r = com.getProfileText();
	//String r = name1.getText();
	//name1.click();
	com.clickOnProfileText();
	/*driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
	//Thread.sleep(2000);
	driver.findElement(By.xpath("//i[@class='fas fa-cogs fa-sm fa-fw mr-2 text-gray-400']")).click();
	//Thread.sleep(2000);*/
	com.profileImage();
	com.settingButton();
	web.verifyWebPage(com.accountInfoValidation(), "Edit Account Info", driver, com.accountInfoValidation());
	WebElement ele = edit.fetchAddressAdminFNTF();
	//WebElement ele = driver.findElement(By.xpath("//input[@name='firstname']"));
	web.toClearDataInTextBox(ele);
	//ele.sendKeys(Keys.CONTROL+"a");
	//ele.sendKeys(firstname);
	edit.adminFirstNameTF(map.get("firstname"));
	//WebElement d = driver.findElement(By.xpath("//select[@name='gender']"));
	WebElement d = edit.fetchAdminGenderTF();
	web.selectDropdown(d, map.get("gender"));
	/*Select s1=new Select(d);
	s1.selectByVisibleText(gender);*/
	//Thread.sleep(2000);
	//driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys(password);
	//driver.findElement(By.xpath("//button[text()='Update']/preceding::div[@class='col-sm-9']/input[@placeholder='Password']")).sendKeys(password);
	edit.adminPasswordTF(map.get("password"));
	//driver.findElement(By.xpath("//button[@type='submit']")).click();
	edit.clickUpdateButton();
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
	/*driver.findElement(By.xpath("//input[@type='text']")).sendKeys(adminusername);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(adminpassword);
	driver.findElement(By.xpath("//button[@type='submit']")).click();*/
	login.loginIntoApplication(adminusername, adminpassword);
	//Thread.sleep(2000);
	/*Alert c = driver.switchTo().alert();
	c.accept();*/
	web.toHandleAlert();
	web.verifyWebPage(com.homebutton(), "Home", driver, com.homebutton());
	//Thread.sleep(2000);
	/*driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
	//Thread.sleep(2000);
	driver.findElement(By.xpath("//i[@class='fas fa-user fa-sm fa-fw mr-2 text-gray-400']")).click();
	//Thread.sleep(2000);
	WebElement name = driver.findElement(By.xpath("(//div[@id='overlay'])[last()]"));
	String g = name.getText();*/
	com.profileImage();
	com.profileButton();
	String g = com.getProfileText();
	//name.click();
	com.clickOnProfileText();
	//Thread.sleep(2000);
	/*driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
	//Thread.sleep(2000);
	driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400']")).click();
	//Thread.sleep(2000);
	driver.findElement(By.xpath("//a[.='Logout']")).click();*/
//	com.profileImage();
//	com.logoutButton();
//	com.logoutConfirmButton();
	/*if(g.equals(r))
	{System.out.println("tc is fail");}
	else {
		System.out.println("tc is pass");
	}*/
	//web.toPerformVerficationByAssertEquals(r, g);
	web.toperformVerificationByAssertNotEquals(r, g);
	//driver.quit();
//	web.closeTheApplication(driver);
		}
}
