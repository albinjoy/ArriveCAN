package com.qa.ExtentReportListener;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.app.qa.base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;

public class ExtentReportsBasic extends TestBase {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExtentHtmlReporter html = new ExtentHtmlReporter("ExtentReports.html");
//		ExtentXReporter extentx = new ExtentXReporter("localhost");

		ExtentReports extent = new ExtentReports();
//		extent.attachReporter(html, extentx);
		extent.attachReporter(html);

		ExtentTest test = extent.createTest("Sample Extent Report").pass("Test Passed");
		
//		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:/development/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		test.log(Status.INFO, "Starting Test Case");
		
		driver.get("http://google.ca/");
		driver.manage().window().maximize();
		test.pass("Navigated to google");
		driver.findElement(By.name("q")).sendKeys("Test Automation");
//		driver.findElement(By.name("q")).sendKeys(Keys.TAB);
		test.pass("Entered text box successfully");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		test.pass("Pressed Enter key successfully");
		driver.close();
		driver.quit();
		test.pass("Close the browser");
		test.pass("Test Completed successfully");		
		
		extent.flush();

	}

}
