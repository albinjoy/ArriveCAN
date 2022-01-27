package com.app.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.app.qa.base.TestBase;

public class TripTravellerPage extends TestBase {

	AddTravellerPage addtravel;

	public void selectTraveller(String selectTraveller, String Traveller_doctype, String Traveller_docnum,
			String Traveller_surname, String Traveller_givename, String Traveller_dob) {
		int size = driver.findElements(By.xpath(
				"//p[text()='" + selectTraveller + "']/parent::div/parent::fieldset/div/input[@type='radio']")).size();
		System.out.println(size);
		if (size == 0) {
			driver.navigate().refresh();
			addnewTraveller(Traveller_doctype, Traveller_docnum, Traveller_surname, Traveller_givename, Traveller_dob);
			driver.findElement(By.xpath(
					"//p[text()='" + selectTraveller + "']/parent::div/parent::fieldset/div/input[@type='radio']"))
					.click();
			clickNext();
		} else {
			driver.findElement(By.xpath(
					"//p[text()='" + selectTraveller + "']/parent::div/parent::fieldset/div/input[@type='radio']"))
					.click();
			clickNext();
		}
	}

	public void addnewTraveller(String Traveller_doctype, String Traveller_docnum, String Traveller_surname,
			String Traveller_givename, String Traveller_dob) {
		String birth_yr = Traveller_dob.substring(0, 4);
		String birth_mnth = Traveller_dob.substring(5, 7);
		String birth_day = Traveller_dob.substring(8, 10);
		WebElement docType = driver.findElement(By.id(prop.getProperty("AddTravellerPage.doctype.id")));
		Select select = new Select(docType);
		select.selectByVisibleText(Traveller_doctype);
		driver.findElement(By.id(prop.getProperty("AddTravellerPage.docnum.id"))).sendKeys(Traveller_docnum);
		driver.findElement(By.id(prop.getProperty("AddTravellerPage.lastname.id"))).sendKeys(Traveller_surname);
		driver.findElement(By.id(prop.getProperty("AddTravellerPage.firstname.id"))).sendKeys(Traveller_givename);
		driver.findElement(By.id(prop.getProperty("AddTravellerPage.year.id"))).sendKeys(birth_yr);
		driver.findElement(By.id(prop.getProperty("AddTravellerPage.month.id"))).sendKeys(birth_mnth);
		driver.findElement(By.id(prop.getProperty("AddTravellerPage.day.id"))).sendKeys(birth_day);
		clickNext();
	}

}
