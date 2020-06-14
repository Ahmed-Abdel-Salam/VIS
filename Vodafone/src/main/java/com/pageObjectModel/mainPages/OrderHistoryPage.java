package com.pageObjectModel.mainPages;

import org.openqa.selenium.By;

import com.framework.Assertion;
import com.utilities.GeneralMethods;

public class OrderHistoryPage extends GeneralMethods {
	By order_list = By.id("order-list");

	public void assert_order_refrence_created(String expectedResult) {
		Assertion.assert_text_contains(order_list, driver, expectedResult);
	}
}
