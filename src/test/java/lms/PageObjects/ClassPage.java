package lms.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lms.Utilities.CommonUtils;

public class ClassPage {

	WebDriver driver;

	public ClassPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
}

	
	
	@FindBy(xpath = "//span[normalize-space()='Confirm']")
	WebElement deleteConfirmMsg;
	
	@FindBy(xpath = "//span[@class='p-button-icon p-button-icon-left pi pi-times']/following-sibling::span")
	WebElement deleteNoButton;

	@FindBy(xpath = "//span[@class='p-button-icon p-button-icon-left pi pi-check']/following-sibling::span")
	WebElement deleteYesButton;

	@FindBy(xpath = "//*[text()='Successful']")
	WebElement toastMsg;

	@FindBy(xpath = "//button[contains(@class, 'p-dialog-header-close')]")
	WebElement deleteCloseButton;
	
	@FindBy(xpath = "//div[normalize-space()='Manage Class']")
	WebElement manageClassHeading;

	@FindBy(xpath = "//input[@id='filterGlobal']")
	WebElement searchBox;
	
	@FindBy(xpath = "\"//*[text()='Class']\"")
	WebElement classLink;
	
	@FindBy(xpath = "//div[@class = 'ng-star-inserted']")
	WebElement navigation_buttons;
	
	public void clickOnClassLink() {

		List<WebElement> navElements = navigation_buttons.findElements(By.tagName("button"));
		navElements.get(3).click();
	}
	
	
	public void clickDeleteIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement deleteIcon = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='action']//button[@icon='pi pi-trash']")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deleteIcon);
	}
	
	public String getDeleteConfirmMsg() {

		return deleteConfirmMsg.getText();
	}

	public String getDeleteYesMsg() {
		return deleteYesButton.getText();

	}

	public String getDeleteNoMsg() {
		return deleteNoButton.getText();
	}
	
	public void setPName(String progName) {
		searchBox.sendKeys(progName);

	}

	public void clickCloseButton() {
	deleteCloseButton.click();
	}
	
	public void clickDeleteIcon(String batchName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement deleteIcon = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//td[text()='" + batchName + "']/following-sibling::td/div/span[2]/button")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deleteIcon);
	}
	
	public void clickDeleteYesBtn() {
		CommonUtils.clickElement(driver, deleteYesButton);
		
	}
	
	public void clickDeleteNoBtn() {
		CommonUtils.clickElement(driver, deleteNoButton);
			}
	
	public String getbatchNameFromResults(int rowNo) {

		WebElement ele = driver.findElement(By.xpath("//tbody[@class='p-datatable-tbody']/tr[" + rowNo + "]/td[6]"));
		return ele.getText();
	}
	
	public void setBName(String batchName) {
		searchBox.sendKeys(batchName);

	}
	
	public String getToastMsg() {
		waitForElementToBeVisible(toastMsg, 15);
		return toastMsg.getText();
	}
	
	public void waitForElementToBeVisible(WebElement element, int i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public String getManageClassHeading() {
		String heading = manageClassHeading.getText();
		return heading;
	}

}
	