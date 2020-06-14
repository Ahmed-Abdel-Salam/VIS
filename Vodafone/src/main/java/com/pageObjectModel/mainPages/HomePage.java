package com.pageObjectModel.mainPages;

import org.openqa.selenium.By;

import com.framework.ElementActions;
import com.utilities.GeneralMethods;

public class HomePage extends GeneralMethods {

	By main_page_login_button = By.xpath("//div[@class='header_user_info']");
	By signup_email_address_field = By.id("email_create");
	By account_page_logout_button = By.xpath("//a[@class=\"logout\"]");
	By singin_email_address_field = By.id("email");
	By signin_password_field = By.id("passwd");
	By signin_button = By.id("SubmitLogin");
	By women_category = By.xpath("//li/a[@title=\"Women\"]");
	By my_orders_link = By.xpath("//a[@title=\"My orders\"]");

	/**
	 * Click on sign in button from home page
	 */
	public void click_signIn_button() {
		ElementActions.click(main_page_login_button, driver);
	}

	public void signin(String email_address, String password) {
		ElementActions.write_text(singin_email_address_field, driver, email_address);
		ElementActions.write_text(signin_password_field, driver, password);
		ElementActions.click(signin_button, driver);
	}

	public void select_subcategory_from_women_category(String topType) {
		By topType_sub_category = By.xpath("//li/a[@title='" + topType + "']");
//		ElementActions.hover_and_click(women_category, topType_sub_category, driver);
		ElementActions.hover(women_category, driver);
//		ElementActions.hover(topType_sub_category, driver);
		ElementActions.click(topType_sub_category, driver);
	}

	public void open_order_history() {
		ElementActions.click(my_orders_link, driver);
	}

	/**
	 * Click on logout button from any page
	 */
	public void logout() {
		ElementActions.click(account_page_logout_button, driver);
	}

}
