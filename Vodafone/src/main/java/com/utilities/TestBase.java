package com.utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.framework.ReportManager;

public class TestBase {
	public static WebDriver driver;
	public static ReportManager reportManager;
	Dimension dim = new Dimension(1024, 768);

	public TestBase() {
		reportManager = new ReportManager();
	}

	public WebDriver return_driver() {
		return driver;
	}

	public void open_browser_navigate_maximize(String url) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().setSize(dim);
	}

	public void close_browser() {
		driver.quit();
	}
}
