package com.app.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.app.qa.base.TestBase;
import com.app.qa.util.TestUtil;

public class WelcomePage extends TestBase {

	public void verifyWelcomePage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("WelcomePage.welcomeTitle.xpath"))));
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
