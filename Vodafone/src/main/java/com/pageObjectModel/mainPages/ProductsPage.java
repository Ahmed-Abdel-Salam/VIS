package com.pageObjectModel.mainPages;

import org.openqa.selenium.By;

import com.framework.ElementActions;
import com.utilities.GeneralMethods;

public class ProductsPage extends GeneralMethods {
	By product_container_pic = By.xpath("//div[@class=\"product-container\"]");
	By add_to_cart_button = By.xpath("//a[@title=\"Add to cart\"]");

	public void add_product_to_cart() {
		ElementActions.hover(product_container_pic, driver);
		ElementActions.click(add_to_cart_button, driver);
	}
}
