package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/AppFeatures" }, glue = { "stepdefinitions", "Hooks" }, plugin = {
		"pretty" })
public class MyTestRunner {

}
