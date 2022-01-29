package com.app.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.app.qa.base.TestBase;
import com.app.qa.util.TestUtil;

public class MainPage extends TestBase {

	public void verifyMainPage() {
		String welcomeTitle = driver.findElement(By.xpath(prop.getProperty("WelcomePage.welcomeTitle.xpath"))).getText();
		String expectedTitle = "Welcome to ArriveCAN";
		Assert.assertEquals(expectedTitle, welcomeTitle);
	}

	public void clickStart() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		click(driver.findElement(By.xpath(prop.getProperty("MainPage.clickStart.xpath"))));
	}

}
