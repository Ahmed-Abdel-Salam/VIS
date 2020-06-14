package com.pageObjectModel.mainPages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import com.framework.ElementActions;
import com.utilities.GeneralMethods;

public class OrderConfirmationPage extends GeneralMethods {

	By order_details = By.xpath("//div[@class=\"box\"]");
	By summary_checkout_button = By.xpath("//p/a[@title=\"Proceed to checkout\"]");
	By address_checkout_button = By.xpath("//button[@name=\"processAddress\"]");
	By shipping_checkout_button = By.xpath("//button[@name=\"processCarrier\"]");

	public String get_refrence_from_order_details() {
		String text = ElementActions.get_text_from_element(order_details, driver);
		return StringUtils.substringBetween(text, "reference ", " in the subject");
	}

	public void click_on_proceed_to_checkout_summary_page() {
		ElementActions.click(summary_checkout_button, driver);
	}

	public void click_on_proceed_to_checkout_address_page() {
		ElementActions.click(address_checkout_button, driver);
	}

	public void click_on_proceed_to_checkout_shipping_page() {
		ElementActions.click(shipping_checkout_button, driver);
	}
}