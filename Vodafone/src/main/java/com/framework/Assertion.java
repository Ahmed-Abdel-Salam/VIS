package com.framework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assertion {
	public static void assert_text_equal(By locator, WebDriver driver, String expectedResult) {
		WebElement element = driver.findElement(locator);
		String actualResult = element.getText();
		try {
			assertEquals(actualResult, expectedResult);
			ReportManager.test.pass("Assertions passed: '" + actualResult + "' matches' '" + expectedResult + "'.");
		} catch (AssertionError e) {
			ReportManager.test
					.fail("Assertions failed: '" + actualResult + "' doesn't match '" + expectedResult + "'.");
		}
	}

	public static void assert_text_contains(By locator, WebDriver driver, String expectedResult) {
		WebElement element = driver.findElement(locator);
		String actualResult = element.getText();
		try {
			assertTrue(actualResult.contains(expectedResult));
			ReportManager.test.pass("Assertions passed: '" + actualResult + "' contains '" + expectedResult + "'.");
		} catch (AssertionError e) {
			ReportManager.test
					.fail("Assertions failed: '" + actualResult + "' doesn't contain '" + expectedResult + "'.");
		}
	}
}
