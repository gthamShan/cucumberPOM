package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	private By usernameId = By.id("user-name");
	private By passwordId = By.id("password");
	private By loginButtonId = By.id("login-button");
	private By loginCredentials = By.id("login_credentials");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void enterUsername(String username) {
		driver.findElement(usernameId).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordId).sendKeys(password);
	}

	public void clickSubmitBtn() {
		driver.findElement(loginButtonId).click();
	}
	
	public boolean isLoginCredentialsPresent() {
		return driver.findElement(loginCredentials).isDisplayed();
	}
	
}
