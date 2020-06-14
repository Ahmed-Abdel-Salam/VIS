package com.pageObjectModel.mainPages;

import org.openqa.selenium.By;

import com.framework.ElementActions;
import com.utilities.GeneralMethods;

public class CheckoutPage extends GeneralMethods {
	By checkout_button = By.xpath("//a[@title=\"Proceed to checkout\"]");
	By terms_button = By.id("uniform-cgv");
	By confirm_order_button = By.xpath("//span[text()='I confirm my order']/parent::button[@type=\"submit\"]");

	public enum Payment {
		bankwire, cheque;
	}

	public void click_on_proceed_to_checkout() {
		ElementActions.click(checkout_button, driver);
	}

	public void agree_on_terms_and_conditions() {
		ElementActions.click(terms_button, driver);
	}

	public void select_payment_method(Payment payment) {
		By payment_method = By.xpath("//a[@class='" + payment + "']");
		ElementActions.click(payment_method, driver);
	}

	public void confirm_order() {
		ElementActions.click(confirm_order_button, driver);
	}
}
