package com.app.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.app.qa.base.TestBase;

public class PrivacyPage extends TestBase {
	
	public void clickNext() {
		WebElement clickNext = driver.findElement(By.xpath(prop.getProperty("PrivacyPage.clickNext.xpath")));
		clickNext.click();
	}

}
