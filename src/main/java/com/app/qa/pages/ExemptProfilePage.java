package com.app.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.app.qa.base.TestBase;

public class ExemptProfilePage extends TestBase {

	public void verifyExemptProfilepage() {

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath(prop.getProperty("ExemptTravellerProfilepage.travelprofile.xpath"))));
		clickNext();
	}

}
