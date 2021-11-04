package com.app.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.app.qa.base.TestBase;

public class ReceiptPage extends TestBase {

	public void exemptReceiptHead(String Content) {
		String receiptHdr = "Exempt ArriveCAN receipt";
		String expectedreceiptHdr = driver.findElement(By.xpath(prop.getProperty("ReceiptPage.receiptTitle.xpath")))
				.getText();
		Assert.assertEquals(receiptHdr, expectedreceiptHdr);
		List<WebElement> contentele =  driver.findElements(By.xpath(prop.getProperty("ReceiptPage.content.xpath")));
		int contentCount = contentele.size();
		if (contentCount == Integer.parseInt(Content)) {
			System.out.println("Content Count is matching");
		} else {
			System.out.println("Content is not correct");
		}
	}

	public void clickStartOver() {
		driver.findElement(By.id(prop.getProperty("ReceiptPage.startOver.id"))).click();
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath(prop.getProperty("ReceiptPage.startOverYes.xpath")))));
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath(prop.getProperty("ReceiptPage.startOverYes.xpath")))));
		driver.findElement(By.xpath(prop.getProperty("ReceiptPage.startOverYes.xpath"))).click();
	}
}
