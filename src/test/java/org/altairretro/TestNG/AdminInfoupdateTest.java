package org.altairretro.TestNG;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sdet40.Sales_Inventory.ObjectRepository.CommonPage;
import org.sdet40.Sales_Inventory.ObjectRepository.EditUserInfo;
import org.sdet40.Sales_Inventory.ObjectRepository.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.sales_inventory.Generic.BaseClass;
import org.tyss.sales_inventory.Generic.ExcelUtility;
import org.tyss.sales_inventory.Generic.FileUtility;
import org.tyss.sales_inventory.Generic.IConstants;
import org.tyss.sales_inventory.Generic.WebDriverUtility;

public class AdminInfoupdateTest extends BaseClass{

	@Test(groups="e")
	public void main() throws EncryptedDocumentException, IOException, InterruptedException
	{

		Map<String, String> map = excel.getDataFromExcelByMap("commondata");
		System.out.println(map);
		String adminusername = file.getDataFromPropertyAfterIntialize("Adminusername");
		String adminpassword = file.getDataFromPropertyAfterIntialize("Adminpassword");
	EditUserInfo edit= new EditUserInfo(driver);
	login.loginIntoApplication(adminusername, adminpassword);
	web.alertinit();
	web.toHandleAlert();
	web.verifyWebPage(com.homebutton(), "Home", driver, com.homebutton());
	com.profileImage();
	com.profileButton();
	String r = com.getProfileText();
	com.clickOnProfileText();
	com.profileImage();
	com.settingButton();
	web.verifyWebPage(com.accountInfoValidation(), "Edit Account Info", driver, com.accountInfoValidation());
	WebElement ele = edit.fetchAddressAdminFNTF();
	web.toClearDataInTextBox(ele);
	edit.adminFirstNameTF(map.get("firstname"));
	WebElement d = edit.fetchAdminGenderTF();
	web.selectDropdown(d, map.get("gender"));
	//driver.findElement(By.xpath("//button[text()='Update']/preceding::div[@class='col-sm-9']/input[@placeholder='Password']")).sendKeys(password);
	edit.adminPasswordTF(map.get("password"));
	edit.clickUpdateButton();
	web.toHandleAlert();
	com.profileImage();
	com.logoutButton();
	com.logoutConfirmButton();
	login.loginIntoApplication(adminusername, adminpassword);
	web.toHandleAlert();
	web.verifyWebPage(com.homebutton(), "Home", driver, com.homebutton());
	com.profileImage();
	com.profileButton();
	String g = com.getProfileText();
	com.clickOnProfileText();
	web.toperformVerificationByAssertNotEquals(r, g);
		}

}


//password=//button[text()='Update']/preceding::div[@class='col-sm-9']/input[@placeholder='Password']
