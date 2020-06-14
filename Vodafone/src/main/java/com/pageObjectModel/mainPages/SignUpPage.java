package com.pageObjectModel.mainPages;

import org.openqa.selenium.By;

import com.framework.Assertion;
import com.framework.ElementActions;
import com.utilities.GeneralMethods;

public class SignUpPage extends GeneralMethods {

	By signUp_page_email_address_field = By.id("email_create");
	By signUp_page_create_an_account_button = By.id("SubmitCreate");

	By register_page_title_checkbox_mr = By.id("id_gender1");
	By register_page_title_checkbox_mrs = By.id("id_gender2");
	By register_page_first_name_field = By.id("customer_firstname");
	By register_page_last_name_field = By.id("customer_lastname");
	By register_page_password_field = By.id("passwd");
	By register_page_day_drop_down = By.id("days");
	By register_page_month_drop_down = By.id("months");
	By register_page_year_drop_down = By.id("years");
	By register_page_address_field = By.id("address1");
	By register_page_city_field = By.id("city");
	By register_page_state_drop_down_menu = By.id("id_state");
	By register_page_post_code_field = By.id("postcode");
	By register_page_mobile_number_field = By.id("phone_mobile");
	By register_page_register_button = By.id("submitAccount");

	By account_page_header = By.xpath("//h1[@class=\"page-heading\"]");

	public enum Title {
		mr, mrs;
	}

	/**
	 * 
	 * @param email_address Email to sign up with
	 */
	public void create_new_account_add_email_address(String email_address) {
		ElementActions.write_text(signUp_page_email_address_field, driver, email_address);
		ElementActions.click(signUp_page_create_an_account_button, driver);
	}

	public void create_new_account_add_personal_information_and_register(Title title, String first_name,
			String last_name, String pass, String day, String month, String year, String address, String city,
			String state, String post_code, String mobile_number) {
		switch (title) {
		case mr:
			ElementActions.click(register_page_title_checkbox_mr, driver);
			break;
		case mrs:
			ElementActions.click(register_page_title_checkbox_mrs, driver);
			break;
		}

		ElementActions.write_text(register_page_first_name_field, driver, first_name);

		ElementActions.write_text(register_page_last_name_field, driver, last_name);

		ElementActions.write_text(register_page_password_field, driver, pass);

		ElementActions.select_from_dropDown_list(register_page_day_drop_down, driver, day);

		ElementActions.select_from_dropDown_list(register_page_month_drop_down, driver, month);

		ElementActions.select_from_dropDown_list(register_page_year_drop_down, driver, year);

		ElementActions.write_text(register_page_address_field, driver, address);

		ElementActions.write_text(register_page_city_field, driver, city);

		ElementActions.select_from_dropDown_list(register_page_state_drop_down_menu, driver, state);

		ElementActions.write_text(register_page_post_code_field, driver, post_code);

		ElementActions.write_text(register_page_mobile_number_field, driver, mobile_number);

		ElementActions.click(register_page_register_button, driver);
	}

	public void assert_equals_on_page_header(String expectedResult) {
		Assertion.assert_text_equal(account_page_header, driver, expectedResult);
	}

	public void assert_contains_on_page_header(String expectedResult) {
		Assertion.assert_text_contains(account_page_header, driver, expectedResult);
	}
}
