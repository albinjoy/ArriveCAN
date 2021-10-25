package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class WelcomePage extends TestBase {

	public void verifyWelcomePage() {
		String welcomeTitle = driver.findElement(By.xpath(prop.getProperty("WelcomePage.welcomeTitle.xpath"))).getText();
		String expectedTitle = "Welcome to ArriveCAN";
		Assert.assertEquals(expectedTitle, welcomeTitle);
	}

	public void clickGetStarted() {
		String getStartedLoc = prop.get("WelcomePage.getStarted.xpath").toString();
		WebElement getStarted = driver.findElement(By.xpath(getStartedLoc));
		getStarted.click();
	}

}
