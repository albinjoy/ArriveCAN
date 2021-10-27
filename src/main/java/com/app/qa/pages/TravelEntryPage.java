package com.app.qa.pages;

import org.openqa.selenium.By;

import com.app.qa.base.TestBase;

public class TravelEntryPage extends TestBase {
	
	public void selectEntryType(String Entry_Type) {
		driver.findElement(By.xpath("//p[text()='Entry by "+Entry_Type+"']")).click();
		clickNext();
	}

}
