package org.altairretro.practice;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.sdet40.Sales_Inventory.ObjectRepository.AddProductPage;
import org.sdet40.Sales_Inventory.ObjectRepository.ProductPage;
import org.sdet40.Sales_Inventory.ObjectRepository.TablesNames;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.tyss.sales_inventory.Generic.BaseClass;

public class DataprovideImpOnPro extends BaseClass
{
	@Test(dataProvider="abcd")
	public void main(String pn1,String des,String cat,String sup,String dat) throws InterruptedException {
		Map<String, String> value = excel.getDataFromExcelByMap("product create");
		System.out.println(value);
		int productcode = jv.getRandomNumber(1000);
		String productcode1=jv.convertIntTostring(productcode);
		System.out.println(productcode1);
		String pname = pn1+jv.getRandomNumber(100);
		int quantity = jv.getRandomNumber(100);
		String quantity1 = jv.convertIntTostring(quantity);
		System.out.println(quantity1);
		int onhand = jv.getRandomNumber(10);
		String onhand1 = jv.convertIntTostring(onhand);
		System.out.println(onhand1);
		int price = jv.getRandomNumber(1000);
		String price1 = jv.convertIntTostring(price);
		System.out.println(price1);
		String adminun = file.getDataFromPropertyAfterIntialize("Adminusername");
		System.out.println(adminun);
		String adminpwd = file.getDataFromPropertyAfterIntialize("Adminpassword");
		System.out.println(adminpwd);
		ProductPage product = new ProductPage(driver);
		AddProductPage productadd = new AddProductPage(driver);
		login.loginIntoApplication(adminun, adminpwd);
		web.alertinit();
		web.toHandleAlert();
		web.verifyWebPage(com.homebutton(), "Home", driver, com.homebutton());
		com.specifyCondition(TablesNames.Product);
		web.verifyWebPage(com.productText(), "Product ", driver, com.productText());
		product.clickProductAddButton();
		productadd.sendProductCode(productcode1);
		productadd.sendProductName(pname);
		productadd.sendDescription(des+jv.getRandomNumber(1000));
		productadd.sendQuantity(quantity1);
		productadd.sendOnHand(onhand1);
		productadd.sendPrice(price1);
		WebElement category = productadd.fetchCategoryAddress();
		productadd.clickCategory();
		web.selectDropdown(category, cat);
		WebElement supplier = productadd.fetchSupplierAddress();
		productadd.clickSupplier();
		web.selectDropdown(supplier, sup);
		WebElement dateclick = productadd.fetchDateAddress();
		productadd.clickDate();
		productadd.sendDate(dat);
		//driver.findElement(By.xpath("//input[@placeholder='Date Stock In']/parent::div/following-sibling::button[@class='btn btn-success']")).click();
		productadd.clickSaveButton();
		com.profileImage();
		com.logoutButton();
		com.logoutConfirmButton();
		//String cashun = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Cashierusername");
		String cashun = file.getDataFromPropertyAfterIntialize("Cashierusername");
		System.out.println(cashun);
		//String cashpwd = file.getDataFromProperty(IConstants.PROPERTY_FILE, "Cashierpassword");
		String cashpwd = file.getDataFromPropertyAfterIntialize("Cashierpassword");
		System.out.println(cashpwd);
		login.loginIntoApplication(cashun, cashpwd);
		web.toHandleAlert();
		web.verifyWebPage(com.pos(), "Point of Sale", driver,com.pos());
		com.specifyprodcat(TablesNames.Mouse);
		//WebElement ele2 = driver.findElement(By.xpath("//div[@id='"+productid+"']//following::h6[.='"+pname+"']"));
		String productnm = com.specifyCondition1(value.get("Product id"), pname);
		System.out.println(productnm);
		web.toPerformVerficationByAssertEquals(pname, productnm);
		
	}
	
	@DataProvider(name = "abcd")
	public Object[][] getData()
	{
		String[][] ex = excel.getTwoDimensionalData("Sheet7");
		return ex;
		
	}
}
