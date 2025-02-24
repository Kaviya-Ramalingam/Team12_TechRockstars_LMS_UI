package lms.Utilities;

import java.time.Duration;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonUtils {


	public WebDriver driver;


	public CommonUtils(WebDriver driver) {
		this.driver = driver;
	}

	public static void moveToElementAndClick(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).click().perform();
		} catch (Exception e) {
			LoggerLoad.error("The element:" + element.toString() + "is not able to scroll to element . Exception is:"
					+ e.getMessage());
		}
	}

	public static void sendInput(WebDriver driver, WebElement element, String textToBeTyped) {
		try {
			element.clear();
			element.click();
			element.sendKeys(textToBeTyped);
		} catch (Exception e) {
			LoggerLoad.error("Not able to send input in " + element.toString() + ". Exception is: " + e.getMessage());
		}
	}

	public static WebElement waitForElementVisibility(WebDriver driver, WebElement element, long durationInSeconds) {

		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			LoggerLoad.error("waitForElementVisibility()::The element " + element.toString()
					+ " may not be visible. Exception is: " + e.getMessage());
		}
		return webElement;
	}

	public static WebElement waitForElementclickable(WebDriver driver, WebElement element, long durationInSeconds) {

		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			LoggerLoad.error("waitForElementVisibility()::The element " + element.toString()
					+ " may not be visible. Exception is: " + e.getMessage());
		}
		return webElement;
	}

	public static String getText(WebElement element) {
		String textValue = "";
		try {
			if (element.isDisplayed()) {
				textValue = element.getText();
				LoggerLoad.info("Text value:- " + textValue);
			} else {
				LoggerLoad.info("Element is not visible");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textValue;
	}


	public static List<WebElement> waitForElementsVisibility(WebDriver driver, List<WebElement> elememt,
			long durationInSeconds) {

		List<WebElement> webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOfAllElements(elememt));
		} catch (Exception e) {
			LoggerLoad.error("waitForElementVisibility()::The element " + elememt.toString()
					+ " may not be visible. Exception is: " + e.getMessage());
		}
		return webElement;
	}

	public static Boolean waitForElementInVisibility(WebDriver driver, WebElement element, long durationInSeconds) {

		Boolean webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			LoggerLoad.error("waitForElementVisibility()::The element " + element.toString()
					+ " may not be visible. Exception is: " + e.getMessage());
		}
		return webElement;
	}

	public static boolean waitForElementStaleness(WebDriver driver, WebElement element, long durationInSeconds) {
		boolean isStale = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			wait.until(ExpectedConditions.stalenessOf(element)); // Wait until element becomes stale
			isStale = true;
		} catch (Exception e) {
			LoggerLoad.error("waitForElementStaleness()::The element " + element.toString()
					+ " did not become stale. Exception is: " + e.getMessage());
		}
		return isStale;
	}

	public static List<String> sortAscendingOrder(List<WebElement> list) {
		return list.stream().map(s -> s.getText().trim().toLowerCase()).sorted(String.CASE_INSENSITIVE_ORDER)
				.collect(Collectors.toList());
	}

	public static List<String> sortDescendingOrder(List<WebElement> list) {
		return list.stream().map(s -> s.getText().trim().toLowerCase()).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
	}


	public static void clickElementUsingJS(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			LoggerLoad.info("Click performed using JavaScript.");
		} catch (Exception e) {
			LoggerLoad.error("Failed to click element using JavaScript. Exception is: " + e.getMessage());
		}
	}
	
	public static void clickElement(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	
	public static void waitForRefresh(long time) {
		
		try { Thread.sleep(time); } catch(Exception e) {e.printStackTrace(); }		
	}





}
