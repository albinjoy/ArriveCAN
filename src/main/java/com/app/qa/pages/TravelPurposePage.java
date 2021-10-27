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
	
	public void travelPurpose_btn(String TravelPurp_btn) {
		driver.findElement(By.xpath("//button[text()=' "+TravelPurp_btn+" ']")).click();
	}
	
	public void travelPurpose_lbl(String TravelPurp_lbl) {
		driver.findElement(By.xpath("//label[text()=' "+TravelPurp_lbl+" ']")).click();
		clickNext();
	}
}
