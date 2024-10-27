package stepdefinitions;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getWebDriver());
	private static String title;

	@Given("user on loginpage")
	public void user_on_loginpage() {
		DriverFactory.getWebDriver().get("https://www.saucedemo.com/");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(expectedTitle.equalsIgnoreCase(title));
	}

	@Then("login credentials should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isLoginCredentialsPresent());
	}

	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickSubmitBtn();
	}
}
