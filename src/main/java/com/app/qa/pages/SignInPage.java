package com.app.qa.pages;

import org.openqa.selenium.By;
import com.app.qa.base.TestBase;

public class SignInPage extends TestBase {
	
	public void performSignIn(String username, String password) throws InterruptedException {
		
		if (driver.findElement(By.xpath(prop.getProperty("SignInPage.username.xpath"))).isDisplayed()) {
			type(driver.findElement(By.xpath(prop.getProperty("SignInPage.username.xpath"))),username);
			type(driver.findElement(By.xpath(prop.getProperty("SignInPage.password.xpath"))),password);
			click(driver.findElement(By.xpath(prop.getProperty("SignInPage.submit.xpath"))));
		} else {
			System.out.println("==================Element is not visible=======================");
		}
		
		
	}
	
}
