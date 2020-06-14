package com.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.utilities.GeneralMethods;

public class ElementActions {
	public static void click(By locator, WebDriver driver) {
		GeneralMethods.wait_until_element_clickable(30, locator);
		WebElement element = driver.findElement(locator);
		ReportManager.test.info("Click element with locator: " + locator);
		element.click();
	}

	public static void write_text(By locator, WebDriver driver, String text) {
		GeneralMethods.wait_until_element_clickable(30, locator);
		WebElement element = driver.findElement(locator);
		ReportManager.test.info("Writing text: '" + text + "' to locator: " + locator);
		element.clear();
		element.sendKeys(text);
	}

	public static void select_from_dropDown_list(By locator, WebDriver driver, String value) {
		WebElement element = driver.findElement(locator);
		ReportManager.test.info("Select '" + value + "' from element with locator: " + locator);
		element.click();
		Select list = new Select(element);
		list.selectByValue(value);
	}

	public static void hover(By locator, WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(locator);
		ReportManager.test.info("Hovering on element with locator: " + locator);
		GeneralMethods.wait_until_element_clickable(30, locator);
		action.moveToElement(element).build().perform();
	}

	public static String get_text_from_element(By locator, WebDriver driver) {
		WebElement element = driver.findElement(locator);
		ReportManager.test.info("Retrieve inner text from locator: " + locator);
		return element.getAttribute("innerText");
	}
}
