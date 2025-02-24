package lms.DriverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import lms.Utilities.ConfigReader;
import lms.Utilities.LoggerLoad;



public class DriverFactory {
	
	public static ThreadLocal<WebDriver> thdriver = new ThreadLocal<>();
	public static String browser = ConfigReader.getBrowser();
	public static String baseUrl = ConfigReader.getUrl();
	
	public static WebDriver Initialization(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			//co.addArguments("--headless");
			thdriver.set(new ChromeDriver(co));
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
		    options.addArguments("--headless");
			thdriver.set(new FirefoxDriver());
	}
		else if (browser.equalsIgnoreCase("safari")) {
			thdriver.set(new EdgeDriver());

}
		
		getdriver().get(baseUrl);
		getdriver().manage().window().maximize();
		getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return thdriver.get();
		
	}
	
	public static WebDriver getdriver() {
		if(thdriver==null) {
			LoggerLoad.error("Driver value is null");
		}
		return thdriver.get();

	}
	
	public static void closeBrowser() {
		getdriver().close();
	}
}




