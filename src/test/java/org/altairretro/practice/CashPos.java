package org.altairretro.practice;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.sdet40.Sales_Inventory.ObjectRepository.ProductPage;
import org.sdet40.Sales_Inventory.ObjectRepository.Summary;
import org.sdet40.Sales_Inventory.ObjectRepository.TablesNames;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.sales_inventory.Generic.BaseClass;

public class CashPos extends BaseClass{

	@Test(groups="f")
	public void main() throws InterruptedException {
//		ExcelUtility excel = new ExcelUtility();
//		WebDriverUtility web = new WebDriverUtility();
//		FileUtility file = new FileUtility();
		/*FileInputStream fileexcel = new FileInputStream("./src/test/resources/fetchdataexcel.xlsx");
		//step-2--> open the excel workbook
		Workbook work = WorkbookFactory.create(fileexcel);
		try {
		//step-3--> get the control on sheet
		Sheet page = work.getSheet("Sheet3");
		//step-4--> get the control on row
		Row row = page.getRow(1);
		Row row1 = page.getRow(2);
		//step-5--> get the control on cell
		Cell record = row.getCell(2);
		Cell record1 = row1.getCell(2);
		//step-6--> fetch the data
		String addo = record.getStringCellValue();
		String custo = record1.getStringCellValue();*/
//		String addo = excel.getDataFromExcel(IConstants.EXCEL, "Sheet3", 1, 1);
//		String custo = excel.getDataFromExcel(IConstants.EXCEL, "Sheet3", 2, 1);
		Map<String, String> map = excel.getDataFromExcelByMap("Sheet3");
//		System.out.println(addo);
//		System.out.println(custo);
		//String cashierun = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Cashierusername");
		String cashierun = file.getDataFromPropertyAfterIntialize("Cashierusername");
		System.out.println(cashierun);
		//String cashierpwd = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Cashierpassword");
		String cashierpwd = file.getDataFromPropertyAfterIntialize("Cashierpassword");
		System.out.println(cashierpwd);
		//String adminun = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Adminusername");
		String adminun = file.getDataFromPropertyAfterIntialize("Adminusername");
		System.out.println(adminun);
		//String adminpwd = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Adminpassword");
		String adminpwd = file.getDataFromPropertyAfterIntialize("Adminpassword");
		System.out.println(adminpwd);
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver= new FirefoxDriver();
		//String url = "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php";
//		String url = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Appurl");
//		WebDriver driver = new WebDriverUtility().openBrowserWithApplication("chrome", 30, url);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		/*driver.findElement(By.xpath("//input[@type='text']")).sendKeys(cashierun);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(cashierpwd);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(2000);
		/*Alert a = driver.switchTo().alert();
		a.accept();*/
//		LoginPage login = new LoginPage(driver);
//		CommonPage com = new CommonPage(driver);
		Summary sum = new Summary(driver);
		ProductPage product = new ProductPage(driver);
		login.loginIntoApplication(cashierun, cashierpwd);
		web.alertinit();
		web.toHandleAlert();
		web.verifyWebPage(com.pos(), "Point of Sale", driver,com.pos());
		//Thread.sleep(2000);
		/*driver.findElement(By.xpath("//a[.='Headset']")).click();
		//Thread.sleep(2000);
		//WebElement add = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		WebElement add = driver.findElement(By.xpath("//div[@id='headset']//div[@class='col-sm-4 col-md-2']//h6[text()='Rpee15']/following-sibling::input[@name='quantity']"));
		//add.sendKeys(Keys.CONTROL+"a");*/
		com.clickHeadsetCategoryTab();
		WebElement add = com.addQuantity();
		web.toClearDataInTextBox(add);
		add.sendKeys(map.get("add"));
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("(//input[@class='btn btn-info'])[4]")).click();
		/*driver.findElement(By.xpath("//div[@id='headset']//div[@class='col-sm-4 col-md-2']//h6[text()='Rpee15']/following-sibling::input[@name='quantity']/following-sibling::input[@value='Add']")).click();
		//Thread.sleep(2000);
		WebElement customer = driver.findElement(By.xpath("//select[@name='customer']"));
		//Thread.sleep(2000);*/
		/*Select cust = new Select(customer);
		cust.selectByVisibleText(custo);*/
		com.clickAddButton();
		WebElement customer = com.selectCustomer();
		web.selectDropdown(customer, map.get("customer"));
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[.='SUBMIT']")).click();
		com.clickSubmitButton();
		//Thread.sleep(2000);
		String cost=null;
		int count4=0;
		int duration=10;
		while(count4<duration)
		{
			try {
		//cost=driver.findElement(By.xpath("//h3[@class='font-weight-bold py-3 bg-light']")).getText();
			cost=sum.costGetText();	
		if(cost.isEmpty()) 
			continue;
		break;
			}
			catch(Exception e)
			{
		Thread.sleep(1000);    //polling period
		count4++;
			}
		}
		System.out.println(cost);
	
		/*driver.findElement(By.xpath("//input[@id='txtNumber']")).sendKeys(cost);
		
		driver.findElement(By.xpath("//button[.='PROCEED TO PAYMENT']")).click();*/
		sum.enterAmountTF(cost);
		sum.proceedToPayment();
		/*Alert b = driver.switchTo().alert();
		b.accept();*/
		web.toHandleAlert();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		com.profileImage();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400']")).click();
		com.logoutButton();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[.='Logout']")).click();
		com.logoutConfirmButton();
		//Thread.sleep(2000);
		/*driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("unguardable");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin" );
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='btnlogin']")).click();*/
		login.loginIntoApplication(adminun, adminpwd);
		/*Alert alt =driver.switchTo().alert();
		alt.accept();*/
		web.toHandleAlert();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//span[text()='Transaction']")).click();
//		com.clickTransaction();
		com.specifyCondition(TablesNames.Transaction);
		web.verifyWebPage(com.transactionText(), "Transaction", driver, com.transactionText());
		//List<WebElement> ele1 = driver.findElements(By.xpath("//ul[@class='pagination']/li"));
		//WebElement ele1 = driver.findElement(By.xpath("//li[@class='paginate_button page-item '][last()]/a"));
		String cstring = product.nextButton();
		/*int count = ele1.size();
		System.out.println(count);
		for(int i=1;i<=(count-3);i++)
		{
			driver.findElement(By.xpath("//a[text()='Next']")).click();
		}
		List<WebElement> ele = driver.findElements(By.xpath("//table//th[text()='Customer']/ancestor::thead/following-sibling::tbody//td[2]"));
		for(WebElement custom:ele)
		{
			String data = custom.getText();
			System.out.println(data);
			if(data.equals(custo))
					{
				System.out.println("testcase pass");
					}
			else
			{
				System.out.println("testcase fail");
					}
		}*/
//String cstring = ele1.getText();
int c = Integer.parseInt(cstring);
System.out.println(c);
int count=0;
for(int i=1;i<c;i++)
{
	//List<WebElement> ele = driver.findElements(By.xpath("//table//th[text()='Customer']/ancestor::thead/following-sibling::tbody//td[2]"));
	List<WebElement> ele = product.fetchTableData();
	for(WebElement r:ele)
	{
		if(r.getText().equalsIgnoreCase(map.get("customer")))
		{
			System.out.println("Tc is pass");
			count++;
			break;
		}
	}
	if(count==1)
	{
		break;
	}
//	for(WebElement r:ele)
//	{
//		String v = r.getText();
//		web.softAssertIntiallize();
//		web.compareBySoftAssert(custo, v);
//	}
//	//driver.findElement(By.xpath("//a[text()='Next']")).click();
	//com.clickOnNextButton();
	com.specifyprodcat(TablesNames.Next);
}
if(count==0)
{
	Assert.fail("Customer name is not present in the table");
}
//web.softAssertAll();
//if(count==0)
//{
//	System.out.println("Tc is fail");
//}
		//driver.quit();
//		web.closeTheApplication(driver);
	}
}
