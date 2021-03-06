package com.app.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.app.qa.base.TestBase;

public class TravelHistoryPage extends TestBase {

	public void addTravelHistory(String Traveller_visited) throws InterruptedException {

		if (!Traveller_visited.equalsIgnoreCase("IGNORE")) {
			driver.findElement(By.id(prop.getProperty("TravelHistoryPage.visitedCountry.id")))
					.sendKeys(Traveller_visited);
			click(driver.findElement(By.id(prop.getProperty("TravelHistoryPage.selectvisitedCountry.id"))));
			click(driver.findElement(By.id(prop.getProperty("TravelHistoryPage.addvisitedCountry.id"))));
			clickNext();
		} else {
			System.out.println("Traveller Visited page is not applicable");
		}

	}
}
