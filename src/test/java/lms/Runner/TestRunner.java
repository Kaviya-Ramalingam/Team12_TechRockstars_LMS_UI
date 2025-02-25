package lms.Runner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lms.Utilities.ConfigReader;

public class TestRunner {

	@CucumberOptions(tags = "",features = "src/test/resources/Features", 
			glue = { "lms.StepDefinitions", "lms.ApplicationHooks" },
			monochrome = true, dryRun = false,
            plugin = { "html:target/cucumber.html", "json:target/cucumber.json" })
	
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

		@Override
		@DataProvider(parallel = true)
		public Object[][] scenarios() {
			return super.scenarios();
		}
		@BeforeTest

		@Parameters({ "browser" })

		public void defineBrowser(String browser) throws Throwable {

			ConfigReader.setBrowserName(browser);


		}
	}

}
