package com.crm.qa.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Common;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;
import com.crm.qa.pages.PrivacyPage;
import com.crm.qa.pages.SignInPage;
import com.crm.qa.pages.TravelPurposePage;
import com.crm.qa.pages.WelcomePage;
import com.crm.qa.util.TestUtil;

public class ArriveCAN_Test extends TestBase {

	WelcomePage wPage;
	PrivacyPage pPage;
	SignInPage sPage;
	MainPage mPage;
	TravelPurposePage tPage;

	@BeforeClass
	public void setUp() {
		initialization();
		wPage = new WelcomePage();
		pPage = new PrivacyPage();
		sPage = new SignInPage();
		mPage = new MainPage();
		tPage = new TravelPurposePage();
	}


	@Test
	public void verifySignInPage() throws IOException, InterruptedException {
		wPage.verifyWelcomePage();
		wPage.clickGetStarted();
		pPage.clickNext();
		sPage.performSignIn(prop.getProperty("username"), prop.getProperty("password"));
		mPage.verifyMainPage();
		mPage.clickStart();
		tPage.verifyTravelPurposepage();
		takeScreenshot("verifySignInPage"); 
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public void takeScreenshot(String fileName) throws IOException {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File("/Users/albinjoy/Documents/development/ArriveCAN/screenshots/" + fileName + ".jpeg"),true);

	}

}
