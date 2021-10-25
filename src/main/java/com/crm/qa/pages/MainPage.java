package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class MainPage extends TestBase {

	public void verifyMainPage() {
		String welcomeTitle = driver.findElement(By.xpath(prop.getProperty("WelcomePage.welcomeTitle.xpath"))).getText();
		String expectedTitle = "Welcome to ArriveCAN";
		Assert.assertEquals(expectedTitle, welcomeTitle);
	}

	public void clickStart() throws InterruptedException {
		click(driver.findElement(By.xpath(prop.getProperty("MainPage.clickStart.xpath"))));
	}

}
