package org.altairretro.TestNG;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.sdet40.Sales_Inventory.ObjectRepository.ProductPage;
import org.sdet40.Sales_Inventory.ObjectRepository.Summary;
import org.sdet40.Sales_Inventory.ObjectRepository.TablesNames;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.sales_inventory.Generic.BaseClass;

public class CashPostTest extends BaseClass{

	@Test(groups="f")
	public void main() throws InterruptedException {
		Map<String, String> map = excel.getDataFromExcelByMap("Sheet3");
		String cashierun = file.getDataFromPropertyAfterIntialize("Cashierusername");
		System.out.println(cashierun);
		String cashierpwd = file.getDataFromPropertyAfterIntialize("Cashierpassword");
		System.out.println(cashierpwd);
		String adminun = file.getDataFromPropertyAfterIntialize("Adminusername");
		System.out.println(adminun);
		String adminpwd = file.getDataFromPropertyAfterIntialize("Adminpassword");
		System.out.println(adminpwd);
		Summary sum = new Summary(driver);
		ProductPage product = new ProductPage(driver);
		login.loginIntoApplication(cashierun, cashierpwd);
		web.alertinit();
		web.toHandleAlert();
		web.verifyWebPage(com.pos(), "Point of Sale", driver,com.pos());
		com.clickHeadsetCategoryTab();
		WebElement add = com.addQuantity();
		web.toClearDataInTextBox(add);
		add.sendKeys(map.get("add"));
		com.clickAddButton();
		WebElement customer = com.selectCustomer();
		web.selectDropdown(customer, map.get("customer"));
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
		web.toHandleAlert();
		com.profileImage();
		com.logoutButton();
		com.logoutConfirmButton();
		login.loginIntoApplication(adminun, adminpwd);
		/*Alert alt =driver.switchTo().alert();
		alt.accept();*/
		web.toHandleAlert();
		com.specifyCondition(TablesNames.Transaction);
		web.verifyWebPage(com.transactionText(), "Transaction", driver, com.transactionText());
		String cstring = product.nextButton();
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
	com.specifyprodcat(TablesNames.Next);
}
if(count==0)
{
	Assert.fail("Customer name is not present in the table");
}
	}

}


