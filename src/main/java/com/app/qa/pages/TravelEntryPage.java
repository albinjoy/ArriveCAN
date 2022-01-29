package com.app.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.app.qa.base.TestBase;

public class TravelEntryPage extends TestBase {

	public void selectEntryType(String Entry_Type) throws InterruptedException {
		click(driver.findElement(By.xpath("//p[text()='Entry by " + Entry_Type + "']")));
	}

}
