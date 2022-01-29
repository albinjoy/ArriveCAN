package com.app.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.app.qa.base.TestBase;

public class ReceiptPage extends TestBase {
	
	String ereceipt;
	
	public void exemptReceiptHead(String Content, String POTname) {
		String receiptHdr = "Exempt ArriveCAN receipt";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("ReceiptPage.receiptTitle.xpath"))));
		String expectedreceiptHdr = driver.findElement(By.xpath(prop.getProperty("ReceiptPage.receiptTitle.xpath")))
				.getText();
		String receiptPOT = driver.findElement(By.xpath(prop.getProperty("ReceiptPage.receiptPOT.xpath"))).getText();
		ereceipt = driver.findElement(By.xpath(prop.getProperty("ReceiptPage.ereceipt.xpath"))).getText();
		Assert.assertEquals(receiptHdr, expectedreceiptHdr);
		Assert.assertEquals(receiptPOT, POTname);
		List<WebElement> contentele =  driver.findElements(By.xpath(prop.getProperty("ReceiptPage.content.xpath")));
		int contentCount = contentele.size();
		if (contentCount == Integer.parseInt(Content)) {
			System.out.println("Content Count is matching");
		} else {
			System.out.println("Content is not correct");
		}
	}

	public void clickStartOver() throws InterruptedException {
		driver.findElement(By.id(prop.getProperty("ReceiptPage.startOver.id"))).click();
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath(prop.getProperty("ReceiptPage.startOverYes.xpath")))));
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath(prop.getProperty("ReceiptPage.startOverYes.xpath")))));
		click(driver.findElement(By.xpath(prop.getProperty("ReceiptPage.startOverYes.xpath"))));
	}
	
	public String getReceipt() {
		return ereceipt;
	}
}
