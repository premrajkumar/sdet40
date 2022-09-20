package org.sdet40.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	@FindBy(xpath="(//h5[.='Add Customer']/../following-sibling::div//input[@name='firstname'])[2]")
	private WebElement CustFirstNameTF;
	
	@FindBy(xpath="(//input[@placeholder='Last Name'])[2]")
	private WebElement custLastNameTF;
	
	@FindBy(xpath="(//input[@placeholder='Phone Number'])[2]")
	private WebElement PhoneNumberTF;
	
	@FindBy(xpath="(//button[.='Save'])[2]")
	private WebElement SaveButton;
	
	public AddCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendFNTF(String uname)
	{
		CustFirstNameTF.sendKeys(uname);
	}
}
