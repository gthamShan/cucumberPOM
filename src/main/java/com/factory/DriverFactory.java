package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(String browser) {

		System.out.println("browser value is :" + browser);

		if (browser.equals("chrome")) {
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			tlDriver.set(new FirefoxDriver());
		} else {
			System.out.println("Invalid browser name:" + browser);
		}
		getWebDriver().manage().window().maximize();
		getWebDriver().manage().deleteAllCookies();
		return getWebDriver();

	}

	public static synchronized WebDriver getWebDriver() {
		return tlDriver.get();
	}

}
