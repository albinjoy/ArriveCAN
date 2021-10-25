package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class WelcomePage extends TestBase {
	
	public void clickGetStarted() {
		String getStartedLoc = prop.get("WelcomePage.getStarted.xpath").toString();
		WebElement getStarted = driver.findElement(By.xpath(getStartedLoc));
		getStarted.click();
	}
	
	

}
