package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class TravelPurposePage extends TestBase {
	
	public void verifyTravelPurposepage() {
		String travelpurposelabel = driver.findElement(By.xpath(prop.getProperty("TravelPurposePage.travelpurposetitle.xpath"))).toString();
		String actuallabel = "Travel purpose";
		Assert.assertEquals(travelpurposelabel, actuallabel);
	}
}
