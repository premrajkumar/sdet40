package org.sdet40.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage {

	@FindBy(xpath="//table//th[text()='Last Name']/ancestor::thead/following-sibling::tbody//td[2]")
	private WebElement CustTable;
	
	
}
