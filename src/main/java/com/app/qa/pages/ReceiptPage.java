package com.app.qa.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.app.qa.base.TestBase;

public class ReceiptPage extends TestBase {
	
	public void exemptReceiptHead() {
		String receiptHdr = "Exempt ArriveCAN receipt";
		String expectedreceiptHdr = driver.findElement(By.xpath(prop.getProperty("ReceiptPage.receiptTitle.xpath"))).getText();
		Assert.assertEquals(receiptHdr, expectedreceiptHdr);
	}
	public void clickStartOver() {
		driver.findElement(By.id(prop.getProperty("ReceiptPage.startOver.id"))).click();
		driver.findElement(By.id(prop.getProperty("ReceiptPage.startOverYes.xpath"))).click();
	}
}
