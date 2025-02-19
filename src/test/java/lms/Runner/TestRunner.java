package lms.Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class TestRunner {

	@CucumberOptions(features = "src/test/resources/Features", 
			glue = { "lms.StepDefinitions", "lms.ApplicationHooks" },
			monochrome = true, dryRun = false,
            plugin = { "html:target/cucumber.html", "json:target/cucumber.json" })
	
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

		@Override
		@DataProvider(parallel = true)
		public Object[][] scenarios() {
			return super.scenarios();
		}
	}

}
