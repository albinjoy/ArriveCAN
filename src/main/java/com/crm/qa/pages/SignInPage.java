package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class SignInPage extends TestBase {
	
	public void performSignIn(String username, String password) {
		/*
		 * WebElement username =
		 * driver.findElement(By.xpath("//input[@id='login-email']")); WebElement
		 * password = driver.findElement(By.xpath("//input[@id='login-password']"));
		 * username.click(); password.click();
		 */
		
		type(driver.findElement(By.xpath(prop.getProperty("SignInPage.username.xpath"))),username);
		type(driver.findElement(By.xpath(prop.getProperty("SignInPage.password.xpath"))),password);
		click(driver.findElement(By.xpath(prop.getProperty("SignInPage.submit.xpath"))));
		
	}
	
}
