package com.app.qa.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.MainPage;
import com.app.qa.pages.PrivacyPage;
import com.app.qa.pages.SignInPage;
import com.app.qa.pages.TravelPurposePage;
import com.app.qa.pages.WelcomePage;
import com.app.qa.util.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.ExtentReportListener.ExtentReportsBasic;

public class ArriveCAN_Test extends TestBase {
	
//	ExtentReporterNG extentReports;
	
	ExtentHtmlReporter html;
	ExtentReports extent;
	
	WelcomePage wPage;
	PrivacyPage pPage;
	SignInPage sPage;
	MainPage mPage;
	TravelPurposePage tPage;
	
	String sheetName = "contacts";
	
	@BeforeSuite
	public void reportSetUp() {
		html = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReports.html");
		extent = new ExtentReports();
		extent.setSystemInfo("Host Name","local");
		extent.setSystemInfo("Environment", "DEV");
		extent.setSystemInfo("User Name", prop.getProperty("username"));
		extent.attachReporter(html);
		
	}

	@BeforeClass
	public void setUp() {
		initialization();
//		extentReports = new ExtentReporterNG();
		wPage = new WelcomePage();
		pPage = new PrivacyPage();
		sPage = new SignInPage();
		mPage = new MainPage();
		tPage = new TravelPurposePage();
	}

	@Test(enabled=true, testName="verifySignInPage")
	public void verifySignInPage() throws IOException, InterruptedException {
		ExtentTest test = extent.createTest("verifySignInPage").pass("Test Passed");
		wPage.verifyWelcomePage();
		test.pass("Navigated successfully from Welcome Page");
		wPage.clickGetStarted();
		pPage.clickNext();
		sPage.performSignIn(prop.getProperty("username"), prop.getProperty("password"));
		mPage.verifyMainPage();
		mPage.clickStart();
		tPage.verifyTravelPurposepage();
		takeScreenshot("verifySignInPage");
//		extentReports.generateReport("testng_ArriveCAN", "testng_ArriveCAN", "/Users/albinjoy/Documents/development/ArriveCAN/test-output");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@AfterSuite
	public void reportsTearDown() {
		extent.flush();
		
	}

	public void takeScreenshot(String fileName) throws IOException {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
		FileUtils.copyFile(src,
				new File("/Users/albinjoy/Documents/development/ArriveCAN/screenshots/" + fileName + ".jpeg"), true);

	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

}
