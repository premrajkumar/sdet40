package org.altairretro.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sdet40.Sales_Inventory.ObjectRepository.AddProductPage;
import org.sdet40.Sales_Inventory.ObjectRepository.CommonPage;
import org.sdet40.Sales_Inventory.ObjectRepository.LoginPage;
import org.sdet40.Sales_Inventory.ObjectRepository.ProductPage;
import org.sdet40.Sales_Inventory.ObjectRepository.TablesNames;
import org.tyss.sales_inventory.Generic.ExcelUtility;
import org.tyss.sales_inventory.Generic.FileUtility;
import org.tyss.sales_inventory.Generic.IConstants;
import org.tyss.sales_inventory.Generic.JavaUtility;
import org.tyss.sales_inventory.Generic.WebDriverUtility;

public class Tc333 {

	public static void main(String[] args) {
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));*/
		JavaUtility jv=new JavaUtility();
		ExcelUtility excel = new ExcelUtility();
		WebDriverUtility web = new WebDriverUtility();
		FileUtility file = new FileUtility();
		//String productname = "yres"+jv.getRandomNumber(10000);
		//String productcategory = "mouse";
		int productcode = jv.getRandomNumber(1000);
		String productcode1 = Integer.toString(productcode);
		System.out.println(productcode1);
		String pname = excel.getDataFromExcel(IConstants.EXCEL, "product create", 2, 1)+jv.getRandomNumber(100);
		System.out.println(pname);
		String description = excel.getDataFromExcel(IConstants.EXCEL, "product create", 3, 1)+jv.getRandomNumber(1000);
		System.out.println(description);
		int quantity = jv.getRandomNumber(100);
		//String quantity1 = Integer.toString(quantity);
		String quantity1 = jv.convertIntTostring(quantity);
		System.out.println(quantity1);
		int onhand = jv.getRandomNumber(10);
		//String onhand1 = Integer.toString(onhand);
		String onhand1 = jv.convertIntTostring(onhand);
		System.out.println(onhand1);
		int price = jv.getRandomNumber(1000);
		//String price1 = Integer.toString(price);
		String price1 = jv.convertIntTostring(price);
		System.out.println(price1);
		String category1 = excel.getDataFromExcel(IConstants.EXCEL, "product create", 7, 1);
		System.out.println(category1);
		String supplier1 = excel.getDataFromExcel(IConstants.EXCEL, "product create", 8, 1);
		System.out.println(supplier1);
		String datestock = excel.getDataFromExcel(IConstants.EXCEL, "product create", 9, 1);
		System.out.println(datestock);
		String productid = excel.getDataFromExcel(IConstants.EXCEL, "product create", 10, 1);
		System.out.println(productid);
		String url = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Appurl");
		System.out.println(url);
		WebDriver driver = web.openBrowserWithApplication("chrome", 15, url);
		//driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		String adminun = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Adminusername");
		System.out.println(adminun);
		String adminpwd = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Adminpassword");
		System.out.println(adminpwd);
		LoginPage login = new LoginPage(driver);
		CommonPage com = new CommonPage(driver);
		ProductPage product = new ProductPage(driver);
		AddProductPage productadd = new AddProductPage(driver);
		/*driver.findElement(By.xpath("//input[@type='text']")).sendKeys(adminun);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(adminpwd);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(2000);*/
		login.loginIntoApplication(adminun, adminpwd);
		/*Alert a = driver.switchTo().alert();
		a.accept();*/
		web.alertinit();
		web.toHandleAlert();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//span[.='Product']")).click();
		com.specifyCondition(TablesNames.Product);
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
		product.clickProductAddButton();
		/*driver.findElement(By.xpath("//input[@placeholder='Product Code']")).sendKeys(productcode1);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(pname);
		driver.findElement(By.xpath("//textarea[@placeholder='Description']")).sendKeys(description);
		driver.findElement(By.xpath("//input[@placeholder='Quantity']")).sendKeys(quantity1);
		driver.findElement(By.xpath("//input[@placeholder='On Hand']")).sendKeys(onhand1);
		driver.findElement(By.xpath("//input[@placeholder='Price']")).sendKeys(price1);
		WebElement category = driver.findElement(By.xpath("//select[@name='category']"));
		category.click();*/
		productadd.sendProductCode(productcode1);
		productadd.sendProductName(pname);
		productadd.sendDescription(description);
		productadd.sendQuantity(quantity1);
		productadd.sendOnHand(onhand1);
		productadd.sendPrice(price1);
		WebElement category = productadd.fetchCategoryAddress();
		productadd.clickCategory();
		/*Select cat=new Select(category);
		cat.selectByVisibleText("Mouse");*/
		web.selectDropdown(category, category1);
		//Thread.sleep(2000);
		/*WebElement supplier = driver.findElement(By.xpath("//select[@name='supplier']"));
		supplier.click();*/
		WebElement supplier = productadd.fetchSupplierAddress();
		productadd.clickSupplier();
		/*Select supply = new Select(supplier);
		supply.selectByVisibleText("Razer Co.");*/
		web.selectDropdown(supplier, supplier1);
		//Thread.sleep(2000);
		/*WebElement dateclick = driver.findElement(By.name("datestock"));
		dateclick.click();
		dateclick.sendKeys("04082022");*/
		WebElement dateclick = productadd.fetchDateAddress();
		productadd.clickDate();
		productadd.sendDate("04082022");
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@placeholder='Date Stock In']/parent::div/following-sibling::button[@class='btn btn-success']")).click();
		productadd.clickSaveButton();
		/*driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400']")).click();
		driver.findElement(By.xpath("//a[.='Logout']")).click();*/
		com.profileImage();
		com.logoutButton();
		com.logoutConfirmButton();
		String cashun = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Cashierusername");
		System.out.println(cashun);
		String cashpwd = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Cashierpassword");
		System.out.println(cashpwd);
		/*driver.findElement(By.xpath("//input[@type='text']")).sendKeys(cashun);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(cashpwd);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(2000);*/
		login.loginIntoApplication(cashun, cashpwd);
		/*Alert b = driver.switchTo().alert();
		b.accept();*/
		web.toHandleAlert();
		//Thread.sleep(2000);
		/*driver.findElement(By.xpath("//a[text()='Mouse']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//div[@class='row']/following::h6[.='"+productname+"']/ancestor::div[@id='"+productcategory+"']"));
		String product = ele1.getText();
		String[] str=product.split("\n");
		if(str[0].toString().equalsIgnoreCase(productname))
		{
			System.out.println("TEstCAse is pass");
		}
		else
		{
			System.out.println("TC IS FAIL");
		}*/
		
		//driver.findElement(By.xpath("//a[text()='Mouse']")).click();
		com.ClickMouseCategoryTab();
		//WebElement ele2 = driver.findElement(By.xpath("//div[@id='"+productid+"']//following::h6[.='"+pname+"']"));
		String productnm = com.specifyCondition1(productid, pname);
	/*String xpathDynamic="//div[@id='%s']//following::h6[.='%s']";
	WebElement ele2 = driver.findElement(By.xpath(String.format(xpathDynamic, productid, pname)));*/
		//String productnm = ele2.getText();
		System.out.println(productnm);
		if(productnm.equalsIgnoreCase(pname))
		{
			System.out.println("Tc is pass");
		}
		else
		{
			System.out.println("Tc is fail");
		}
		
		web.closeTheApplication(driver);
		
	}

}

/*String xpathDynamic="//div[@id='%s']//following::h6[.='%s']";
WebElement ele2 = driver.findElement(By.xpath(String.format(xpathDynamic, productid, pname)));*/
//div[@id='"+productcategory+"']//following::h6[.='"+productname+"']




