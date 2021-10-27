package com.app.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.app.qa.base.TestBase;

public class TravelHistoryPage extends TestBase {
	
	public void addTravelHistory(String Traveller_visited) {
		driver.findElement(By.id(prop.getProperty("TravelHistoryPage.visitedCountry.id"))).sendKeys(Traveller_visited);
		driver.findElement(By.id(prop.getProperty("TravelHistoryPage.visitedCountry.id"))).sendKeys(Keys.ENTER);
		clickNext();
	}
}
