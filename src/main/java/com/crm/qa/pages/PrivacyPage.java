package com.crm.qa.pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class PrivacyPage extends TestBase {
	
	public void clickNext(String username, String password) {
		WebElement clickNext = driver.findElement(By.xpath(prop.getProperty("PrivacyPage.clickNext.xpath")));
		clickNext.click();
	}

}
