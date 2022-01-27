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
import com.app.qa.pages.AddContactInfoPage;
import com.app.qa.pages.AddTravellerPage;
import com.app.qa.pages.MainPage;
import com.app.qa.pages.PrivacyPage;
import com.app.qa.pages.ReceiptPage;
import com.app.qa.pages.SignInPage;
import com.app.qa.pages.TravelEntryPage;
import com.app.qa.pages.TravelHistoryPage;
import com.app.qa.pages.TravelPurposePage;
import com.app.qa.pages.TripTravellerPage;
import com.app.qa.pages.WelcomePage;
import com.app.qa.util.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ArriveCAN_Test extends TestBase {

//	ExtentReporterNG extentReports;

	ExtentHtmlReporter html;
	ExtentReports extent;
	ExtentTest test;

	TestUtil testUtil;

	WelcomePage wPage;
	PrivacyPage pPage;
	SignInPage sPage;
	MainPage mPage;
	TravelPurposePage tPage;
	TravelEntryPage ePage;
	AddTravellerPage addPage;
	AddContactInfoPage conPage;
	TripTravellerPage tripPage;
	TravelHistoryPage visitedPage;
	ReceiptPage receiptPage;

	String sheetName = "arrivecan";

	@BeforeSuite
	public void reportSetUp() {
		html = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReports.html");
		extent = new ExtentReports();
		extent.setSystemInfo("Host Name", "local");
		extent.setSystemInfo("Environment", "DEV");
		extent.setSystemInfo("User Name", prop.getProperty("username"));
		extent.attachReporter(html);

	}

	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		logintoAPP(prop.getProperty("username"), prop.getProperty("password"));
//		extentReports = new ExtentReporterNG();
		wPage = new WelcomePage();
		pPage = new PrivacyPage();
		sPage = new SignInPage();
		mPage = new MainPage();
		tPage = new TravelPurposePage();
		ePage = new TravelEntryPage();
		addPage = new AddTravellerPage();
		conPage = new AddContactInfoPage();
		tripPage = new TripTravellerPage();
		visitedPage = new TravelHistoryPage();
		receiptPage = new ReceiptPage();
	}

	@Test(enabled = true, testName = "createExemptTrip", dataProvider = "arrivecandata")
	public void createSubmission(String testName, String travel_lbl, String entry_type, String selectTraveller,
			String Traveller_mobile, String Traveller_visited, String Content, String Traveller_doctype,
			String Traveller_docnum, String Traveller_surname, String Traveller_givename, String Traveller_dob)
			throws IOException, InterruptedException {
//		test = extent.createTest(testName).pass("Test Execution Started");
		test = extent.createTest(testName).log(Status.PASS, "Test Execution Started");

		test.pass("Page loaded successfully");
		test.pass("Navigated successfully from Welcome Page");
//		TestUtil.runTimeInfo("info", "login successful");
//		mPage.verifyMainPage();
		mPage.clickStart();
		tPage.verifyTravelPurposepage();
		tPage.travelPurpose_lbl(travel_lbl);
		ePage.selectEntryType(entry_type);
		conPage.addContact(Traveller_mobile);
		tripPage.selectTraveller(selectTraveller, Traveller_doctype, Traveller_docnum, Traveller_surname,
				Traveller_givename, Traveller_dob);
		visitedPage.addTravelHistory(Traveller_visited);
		clickSubmit();
		receiptPage.exemptReceiptHead(Content, tPage.getPOTname());
		test.pass("Created Submission for Exempt Traveller successfully with the mode of entry as " + entry_type + "and eReceipt : " + receiptPage.getReceipt() + " and purpose of Travel is " + tPage.getPOTname());
		takeScreenshot(testName);
		receiptPage.clickStartOver();
		wPage.verifyWelcomePage();

//		extentReports.generateReport("testng_ArriveCAN", "testng_ArriveCAN", "C:/development/ArriveCAN/test-output");
	}

	/*
	 * @AfterMethod public void tearDown() { driver.quit(); }
	 */

	@AfterSuite
	public void reportsTearDown() {
		driver.quit();
		extent.flush();

	}

	public void takeScreenshot(String fileName) throws IOException {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
		FileUtils.copyFile(src,
				new File("C:/development/ArriveCAN/screenshots/" + fileName + "_" + timestamp() + ".jpeg"), true);

	}

	@DataProvider(name = "arrivecandata")
	public Object[][] getArriveCANData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

}
