package com.app.qa.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Common extends TestBase {

	protected static WebDriver driver;
	static JavascriptExecutor js;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/albinjoy/Documents/development/drivers/chromedriver");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		String url = prop.getProperty("url");
		driver.get(url);
		/* driver.get("https://www.freecrm.com/index.html"); */
	}

	@AfterTest
	public void tearDown(String fileName) throws IOException {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File("/Users/albinjoy/Documents/development/ArriveCAN/screenshots/" + fileName + ".jpeg"),true);

		driver.quit();
	}

}
