package com.app.qa.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.app.qa.base.TestBase;

public class TravelPurposePage extends TestBase {
	
	public void verifyTravelPurposepage() {
		String travelpurposelabel = driver.findElement(By.xpath(prop.getProperty("TravelPurposePage.travelpurposelabel.xpath"))).getText();
		String actuallabel = "Travel purpose";
		Assert.assertEquals(travelpurposelabel, actuallabel);
	}
}
