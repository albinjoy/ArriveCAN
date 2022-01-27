package com.app.qa.pages;

import org.openqa.selenium.By;

import com.app.qa.base.TestBase;

public class AddContactInfoPage extends TestBase {
	
	public void addContact(String Traveller_mobile) throws InterruptedException {
		driver.findElement(By.id(prop.getProperty("AddContactInfoPage.contactnum.id"))).sendKeys(Traveller_mobile);
		clickNext();
	}
}
