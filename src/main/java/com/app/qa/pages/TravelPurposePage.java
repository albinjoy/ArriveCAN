package com.app.qa.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.app.qa.base.TestBase;

public class TravelPurposePage extends TestBase {

	String travellbl;

	public void verifyTravelPurposepage() {
		String travelpurposelabel = driver
				.findElement(By.xpath(prop.getProperty("TravelPurposePage.travelpurposelabel.xpath"))).getText();
		String actuallabel = "Reason for travel";
		Assert.assertEquals(travelpurposelabel, actuallabel);
	}

	/*
	 * public void travelPurpose_btn(String TravelPurp_btn) {
	 * driver.findElement(By.xpath("//label[text()=' " + TravelPurp_btn +
	 * " ']")).click(); }
	 */

	public void travelPurpose_lbl(String TravelPurp_lbl) {

		System.out.println(TravelPurp_lbl);
		if (TravelPurp_lbl.contains("&&")) {
			int iend = TravelPurp_lbl.indexOf("&&");
			String exemptlbl = null;
			String example = TravelPurp_lbl;
			if (iend != -1) {
				exemptlbl = TravelPurp_lbl.substring(0, (iend - 2));
				travellbl = example.substring(example.lastIndexOf("&&") + 3);
				driver.findElement(By.xpath("//label[contains(text(),'" + exemptlbl + "')]")).click();
				clickNext();
				driver.findElement(By.xpath("//label[contains(text(),'" + travellbl + "')]")).click();
				clickNext();
				clickNext();
			}

		} else {
			driver.findElement(By.xpath("//label[contains(text(),'" + TravelPurp_lbl + "')]")).click();
			clickNext();
		}
	}

	public String getPOTname() {
		return travellbl;
	}

}
