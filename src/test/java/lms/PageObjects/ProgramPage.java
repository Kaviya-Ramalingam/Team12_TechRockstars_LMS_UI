package lms.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
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
	public static WebElement programNameInputField;

	@FindBy(id = "programDescription")
	public static WebElement programDescriptionInputField;

	@FindBy(xpath = "//*[text()='Program Created Successfully']")
	WebElement progSuccessMesg;

	@FindBy(xpath = "//div[@class ='ng-tns-c81-9 p-dialog-content']/div[3]/div[2]/*[@id ='category']")
	WebElement activeRadioBtn;

	@FindBy(xpath = "//*[contains(text(),'programName Must contain only letters and sometimes hyphens')]")
	WebElement progFailedMesg;

	@FindBy(xpath = "//input[@type = 'text']")
	WebElement progSearchBox;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	WebElement programNametable;

	@FindBy(tagName = "tr")
	List<WebElement> tableRow;

	@FindBy(tagName = "td")
	List<WebElement> tableCell;

	@FindBy(xpath = "//p-dialog//div//div//div[1]//div[@class='p-dialog-header-icons ng-tns-c81-8']//button")
	WebElement xButton;
	
	//edit program
	
	@FindBy(xpath ="//button[@id = 'editProgram']")
	WebElement editProgramIcon;

	public void programClick() {
		CommonUtils.moveToElementAndClick(driver, program);
	}

	public String getProgramTitle() {
		return ManageProgramTitle.getText();
	}

	public void clickAddNewProgram() {
		addNewProgram.click();
	}

	public boolean programDetailsPopup() {

		return programDetails.isDisplayed();
	}

	public boolean programDetailsPopupDisappears() {
		CommonUtils.waitForElementInVisibility(driver, programDetails, 20);
		return !programDetails.isDisplayed();
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

	public void progInputField(String ProgName) {
		programNameInputField.clear();
		CommonUtils.sendInput(driver, programNameInputField, ProgName);
	}

	public void progdescField(String Progdesc) {
		CommonUtils.sendInput(driver, programDescriptionInputField, Progdesc);
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

	public String SearchByProgramName(String progName) {
		CommonUtils.waitForElementVisibility(driver, progSearchBox, 10);
		CommonUtils.moveToElementAndClick(driver, progSearchBox);
		CommonUtils.sendInput(driver, progSearchBox, progName);
		return progName;

	}

	public String getSelectedProgram() {
		CommonUtils.waitForElementVisibility(driver, programNametable, 20);
		return CommonUtils.getText(programNametable);

	}

	public String getTableValue(String ProgrName) {
		List<WebElement> tableRows = driver.findElements(By.tagName("tr"));
		for (WebElement row : tableRows) {
			List<WebElement> rowCells = row.findElements(By.tagName("td"));
			for (int i = 0; i < rowCells.size(); i++) {
				String cellText = rowCells.get(i).getText();
				// Check if the cell contains the program name in a specific column
				if (i == 0 && cellText.equals(ProgrName)) {
					return cellText; // Return the exact program name from the specific column
				}
			}
		}
		return null;

	}

	public boolean activeRadioBtnSelected() {
		CommonUtils.waitForElementclickable(driver, activeRadioBtn, 20);
		return activeRadioBtn.isSelected();
	}

	public void clickX() {
		CommonUtils.moveToElementAndClick(driver, xButton);
	}
	
	public void clickEditIcon() {
		CommonUtils.waitForElementVisibility(driver, editProgramIcon, 20);
		CommonUtils.moveToElementAndClick(driver,editProgramIcon);
	}
}
