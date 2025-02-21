package lms.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utilities.CommonUtils;

public class ProgramPage {

	WebDriver driver;

	public ProgramPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='program']/span[1]")
	WebElement program;
	@FindBy(xpath = "//*[contains(text(), 'Manage Program')]")
	WebElement ManageProgramTitle;
	// add new program
	@FindBy(xpath = "//button[contains(text(),'Add New Program')]")
	WebElement addNewProgram;
	@FindBy(xpath = "//p-dialog//div//span[text()='Program Details']")
	WebElement programDetails;
	@FindBy(xpath = "//div[@class = 'p-field ng-star-inserted'][2]/label/span")
	WebElement asterick;
	@FindBy(xpath = "//button[@id = 'saveProgram']")
	WebElement saveButton;
	@FindBy(xpath = "//small[@class='p-invalid ng-star-inserted']")
	List<WebElement> errorMessages;
	@FindBy(xpath = "//div[3]//button[1]/span[2][@class ='p-button-label']")
	WebElement cancelButton;
	@FindBy(id = "programName")
	WebElement programNameInputField;
	@FindBy(id = "programDescription")
	WebElement programDescriptionInputField;
	@FindBy(xpath = "//*[text()='Program Created Successfully']")
	WebElement progSuccessMesg;
	@FindBy(xpath = "//div[@class ='ng-tns-c81-9 p-dialog-content']/div[3]/div[2]/*[@id ='category']")
	WebElement activeRadioBtn;
	@FindBy(xpath = "//*[contains(text(),'programName Must contain only letters and sometimes hyphens')]")
	WebElement progFailedMesg;

	public void programClick() {
		CommonUtils.moveToElementAndClick(driver, program);
	}

	public String getProgramTitle() {
		return ManageProgramTitle.getText();
	}

	public void clickAddNewProgram() {
		addNewProgram.click();
	}

	public void programDetailsPopup() {
		programDetails.isDisplayed();
	}

	public String programDetailsTitle() throws InterruptedException {

		return programDetails.getText();
	}

	public String asterick() {
		return asterick.getText();
	}

	public String color() {
		return asterick.getCssValue("color");

	}

	public void clickSaveButton() {
		CommonUtils.moveToElementAndClick(driver, saveButton);
	}

	public List<WebElement> getErrorMesg() {
		return errorMessages;
	}

	public void clickCancelButton() {
		cancelButton.click();
	}

	public void typeProgranDetailsInput(String progName, String progDesc) {
		CommonUtils.sendInput(driver, programNameInputField, progName);
		CommonUtils.sendInput(driver, programDescriptionInputField, progDesc);
	}

	public String getSuccessMesg() {
		return CommonUtils.getText(progSuccessMesg);

	}

	public void clickActiveRadioBtn() {
		CommonUtils.waitForElementclickable(driver, activeRadioBtn, 10);
		CommonUtils.moveToElementAndClick(driver, activeRadioBtn);

	}

	public String getFailedMesg() {
		return CommonUtils.getText(progFailedMesg);
	}
}
