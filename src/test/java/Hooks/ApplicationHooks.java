package Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver webDriver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void lauchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		webDriver = driverFactory.init_driver(browserName);
	}

	@After(order = 0)
	public void quitBrowser() {
		webDriver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenShotName = scenario.getName().replaceAll(" ", "_");
			TakesScreenshot ts = (TakesScreenshot) webDriver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", screenShotName);
		}

	}

}
