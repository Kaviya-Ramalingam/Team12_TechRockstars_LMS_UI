package lms.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class CommonUtils {
	
	public WebDriver driver;
	
	
	public CommonUtils(WebDriver driver) {
		this.driver=driver;
	}


	public static void moveToElementAndClick(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();	
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
	
	public static boolean selectByVisibleText(WebDriver driver,String visibletext, WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()) {

			Select select = new Select(element);
				select.selectByVisibleText(visibletext);
				flag = true;
				LoggerLoad.info("Option selected by visibletext");

			} else {
				flag = false;
				LoggerLoad.info("Option not selected by visibletext");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}





}
