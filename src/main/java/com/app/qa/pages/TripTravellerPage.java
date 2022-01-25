package com.app.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.app.qa.base.TestBase;

public class TripTravellerPage extends TestBase {

	public void selectTraveller(String selectTraveller) {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//p[text()='"+selectTraveller+"']/parent::div/parent::fieldset/div/input[@type='radio']")).click();
		clickNext();
	}

}
