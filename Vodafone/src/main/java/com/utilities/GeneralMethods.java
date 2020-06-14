package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.ReportManager;

public class GeneralMethods extends TestBase {
	public static void wait_until_element_clickable(int sec, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		ReportManager.test.info("Waiting for " + sec + " seconds till element be clickable.");
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void wait_until_element_visible(int sec, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		ReportManager.test.info("Waiting for " + sec + " seconds till element be visiable.");
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
