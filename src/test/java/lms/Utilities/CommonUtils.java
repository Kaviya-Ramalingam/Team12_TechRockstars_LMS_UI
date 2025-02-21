package lms.Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import lms.Utilities.LoggerLoad;


public class CommonUtils {
	
	public WebDriver driver;
	
	
	public CommonUtils(WebDriver driver) {
		this.driver=driver;
	}


	public static void moveToElementAndClick(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).click().perform();	
		} catch (Exception e) {
			LoggerLoad.error("The element:" +element.toString() +"is not able to scroll to element . Exception is:"  
					+e.getMessage());
		}
	}
	
	public static void sendInput(WebDriver driver, WebElement element, String textToBeTyped) {
		try {
			element.clear();
			element.click();
			element.sendKeys(textToBeTyped);
		} catch (Exception e) {
			LoggerLoad.error("Not able to send input in " + element.toString()
					+ ". Exception is: " + e.getMessage());
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
		if(element.isDisplayed()) {
			textValue=element.getText();
			LoggerLoad.info("Text value:- "+textValue);
		}
		else {
			LoggerLoad.info("Element is not visible");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return textValue;
	}
	
	





}
