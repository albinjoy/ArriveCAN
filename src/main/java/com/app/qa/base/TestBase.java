package com.app.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.app.qa.util.TestUtil;
import com.app.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	protected static WebDriverWait wait;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/app" + "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void logintoAPP(String username, String password) throws InterruptedException {
		String welcomeTitle = driver.findElement(By.xpath(prop.getProperty("WelcomePage.welcomeTitle.xpath")))
				.getText();
		String expectedTitle = "Welcome to ArriveCAN";
		Assert.assertEquals(expectedTitle, welcomeTitle);
		String getStartedLoc = prop.get("WelcomePage.getStarted.xpath").toString();
		WebElement getStarted = driver.findElement(By.xpath(getStartedLoc));
		getStarted.click();
		WebElement clickNext = driver.findElement(By.xpath(prop.getProperty("PrivacyPage.clickNext.xpath")));
		clickNext.click();
		if (driver.findElement(By.xpath(prop.getProperty("SignInPage.username.xpath"))).isDisplayed()) {
			type(driver.findElement(By.xpath(prop.getProperty("SignInPage.username.xpath"))), username);
			type(driver.findElement(By.xpath(prop.getProperty("SignInPage.password.xpath"))), password);
			click(driver.findElement(By.xpath(prop.getProperty("SignInPage.submit.xpath"))));
		} else {
			System.out.println("==================Element is not visible=======================");
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\development\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\development\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		wait = new WebDriverWait(driver, 10);

	}

	public static void click(WebElement ele) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		Thread.sleep(2000);
	}

	public static void type(WebElement ele, String data) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.clear();
		ele.sendKeys(data);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void clickNext() {
		driver.findElement(By.id("next")).click();
	}

	public void clickSubmit() {
		driver.findElement(By.id("submit")).click();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
