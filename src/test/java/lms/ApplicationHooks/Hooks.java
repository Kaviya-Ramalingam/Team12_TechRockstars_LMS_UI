package lms.ApplicationHooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import lms.DriverFactory.DriverFactory;
import lms.Utilities.ConfigReader;
import lms.Utilities.LoggerLoad;


public class Hooks {
	private static WebDriver driver;

	@Before
	public static void initialization() throws Throwable {

		ConfigReader.ReadDataFromConfig();
		 String browser = ConfigReader.getBrowserName();//to read from testng.xml
		//String browser = ConfigReader.getBrowser();// to read from property file
		DriverFactory.Initialization(browser);
		driver = DriverFactory.getdriver();
		LoggerLoad.info("starting browser");
		
	}

	@After
	public void AddScreenshot(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "My Screenshot");
			Allure.addAttachment("Failed Scenario Screenshot", new ByteArrayInputStream(screenshot));
		}

	}

	@After
	public static void afterAll() {

		DriverFactory.closeBrowser();
		LoggerLoad.info("closing browser");

	}

}


