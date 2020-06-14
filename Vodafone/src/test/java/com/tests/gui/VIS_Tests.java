package com.tests.gui;

import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.ReportManager;
import com.framework.XLSXActions;
import com.pageObjectModel.mainPages.CheckoutPage;
import com.pageObjectModel.mainPages.CheckoutPage.Payment;
import com.pageObjectModel.mainPages.HomePage;
import com.pageObjectModel.mainPages.OrderConfirmationPage;
import com.pageObjectModel.mainPages.OrderHistoryPage;
import com.pageObjectModel.mainPages.ProductsPage;
import com.pageObjectModel.mainPages.SignUpPage;
import com.pageObjectModel.mainPages.SignUpPage.Title;
import com.utilities.GeneralMethods;

/**
 * 
 * @author Ahmed Abdelsalam
 *
 */
public class VIS_Tests {
	HomePage homePage;
	SignUpPage signUpPage;
	GeneralMethods generalMethods;
	ProductsPage productsPage;
	CheckoutPage checkoutPage;
	OrderConfirmationPage orderConfirmationPage;
	OrderHistoryPage orderHistoryPage;
	XLSXActions excelActions;

	Date date = new Date();
	long time = date.getTime();

	String email_address = "test" + time + "@gmail.com";
	String order_refrence_number;

	@Test(description = "Create new account and assert that user is logged in after creation")
	public void create_new_account() {
		ReportManager.create_test("create_new_account", "Positive test");
		homePage.click_signIn_button();
		signUpPage.create_new_account_add_email_address(email_address);
		signUpPage.create_new_account_add_personal_information_and_register(Title.mr, excelActions.ReadCellData(2, 1),
				excelActions.ReadCellData(3, 1), excelActions.ReadCellData(4, 1), excelActions.ReadCellData(5, 1),
				excelActions.ReadCellData(6, 1), excelActions.ReadCellData(7, 1), excelActions.ReadCellData(8, 1),
				excelActions.ReadCellData(9, 1), excelActions.ReadCellData(10, 1), excelActions.ReadCellData(11, 1),
				excelActions.ReadCellData(12, 1));

		signUpPage.assert_equals_on_page_header("MY ACCOUNT");

		homePage.logout();
		signUpPage.assert_equals_on_page_header("AUTHENTICATION");
	}

	@Test(description = "login as new user and assert on page header", dependsOnMethods = { "create_new_account" })
	public void login_as_new_user() {
		ReportManager.create_test("login_as_new_user", "Positive test");
		homePage.click_signIn_button();
		homePage.signin(email_address, excelActions.ReadCellData(4, 1));
		signUpPage.assert_equals_on_page_header("MY ACCOUNT");
	}

	@Test(description = "select specific category and add products to cart and proceed with order confirmation and assert on order confirmation", dependsOnMethods = {
			"login_as_new_user" })
	public void select_item_and_confirm_order() {
		ReportManager.create_test("select_item_and_confirm_order", "Positive test");
		homePage.select_subcategory_from_women_category("Blouses");
		productsPage.add_product_to_cart();
		checkoutPage.click_on_proceed_to_checkout();

		signUpPage.assert_contains_on_page_header("SHOPPING-CART SUMMARY");
		orderConfirmationPage.click_on_proceed_to_checkout_summary_page();
		orderConfirmationPage.click_on_proceed_to_checkout_address_page();
		checkoutPage.agree_on_terms_and_conditions();
		orderConfirmationPage.click_on_proceed_to_checkout_shipping_page();

		checkoutPage.select_payment_method(Payment.bankwire);
		checkoutPage.confirm_order();
		signUpPage.assert_equals_on_page_header("ORDER CONFIRMATION");
		order_refrence_number = orderConfirmationPage.get_refrence_from_order_details();
	}

	@Test(description = "Open order history and assert that order is created successfully", dependsOnMethods = {
			"select_item_and_confirm_order" })
	public void view_order_history() {
		ReportManager.create_test("view_order_history", "Positive test");
		homePage.open_order_history();
		orderHistoryPage.assert_order_refrence_created(order_refrence_number);
	}

	@BeforeClass
	public void beforeClass() {
		excelActions = new XLSXActions("VIS.xlsx");

		homePage = new HomePage();
		productsPage = new ProductsPage();
		orderConfirmationPage = new OrderConfirmationPage();
		checkoutPage = new CheckoutPage();
		orderHistoryPage = new OrderHistoryPage();

		signUpPage = new SignUpPage();
		signUpPage.open_browser_navigate_maximize(excelActions.ReadCellData(1, 1));
	}

	@AfterClass
	public void afterClass() {
		homePage.close_browser();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		ReportManager.get_result(result);
	}

	@AfterTest
	public void afterTest() {
		ReportManager.flush_report();
	}
}