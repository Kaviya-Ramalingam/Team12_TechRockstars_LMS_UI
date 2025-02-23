package lms.PageObjects;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utilities.CommonUtils;
import lms.Utilities.LoggerLoad;

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

	@FindBy(xpath = "//div[@class ='ng-tns-c81-9 p-dialog-content']/div[3]/div[3]/*[@id ='category']")
	WebElement inactiveRadioBtn;

	@FindBy(xpath = "//*[contains(text(),'programName Must contain only letters and sometimes hyphens')]")
	WebElement progFailedMesg;

	@FindBy(xpath = "//input[@type = 'text']")
	WebElement progSearchBox;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	WebElement programNametable;

	@FindBy(xpath = "//table[@role='grid']/tbody/tr")
	public List<WebElement> tableRow;

	@FindBy(tagName = "td")
	List<WebElement> tableCell;

	@FindBy(xpath = "//p-dialog//div//div//div[1]//div[@class='p-dialog-header-icons ng-tns-c81-8']//button")
	WebElement xButton;

	@FindBy(xpath = "//*[text()='Program Updated']")
	WebElement progUpdatedMesg;

	// edit program

	@FindBy(xpath = "//button[@id = 'editProgram']")
	public WebElement editProgramIcon;

	// delete program

	/*
	 * @FindBy(xpath = "//table//tbody//tr[1]//td//button[@id='deleteProgram']")
	 * WebElement deleteIcon;
	 */

	@FindBy(xpath = "//div[@class='action']//button[@icon='pi pi-trash']")
	public WebElement deleteProgramIcon;

	@FindBy(xpath = "//div/div/div[3]/button[2]")
	WebElement YesButton;

	@FindBy(xpath = "//div/div/div[3]/button[1]")
	WebElement NoButton;

	@FindBy(xpath = "//*[text()='Program Deleted']")
	WebElement progDeleteMesg;

	@FindBy(xpath = "//p-paginator/div/span[@class ='p-paginator-current ng-star-inserted']")
	WebElement noOfProgramEntries;

	@FindBy(xpath = "//p-confirmdialog/div/div/div[1]/div/button[@type='button']")
	WebElement deletePopupXButton;

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirmDeletePopup;

	// sorting
	@FindBy(xpath = "//thead//tr//th[2]")
	WebElement clickSortProgramName;

	@FindBy(xpath = "//table[@role='grid']/thead/tr/th[3]")
	WebElement clickSortProgramDescription;

	@FindBy(xpath = "//table[@role='grid']/thead/tr/th[4]")
	WebElement clickSortProgramStatus;

	@FindBy(xpath = "//table[@role='grid']/tbody/tr/td[2]")
	public List<WebElement> programNames;

	@FindBy(xpath = "//table[@role='grid']/tbody/tr/td[3]")
	public List<WebElement> programDescriptions;
	public @FindBy(xpath = "//table[@role='grid']/tbody/tr/td[4]") List<WebElement> programsStatus;

	// manageProgramValidation

	@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th")
	List<WebElement> programHeader;

	@FindBy(xpath = "//div[@class='box']//button[@icon='pi pi-trash']")
	WebElement leftDeleteIcon;

	@FindBy(xpath = "//table//thead//div[@role = 'checkbox']")
	WebElement headerCheckbox;

	@FindBy(xpath = "//table//tbody/tr/td[1]//div[@role = 'checkbox']")
	List<WebElement> allCheckboxes;

	@FindBy(xpath = "//table[@role='grid']/thead/tr/th/p-sorticon")
	public List<WebElement> allSortIcon;

	@FindBy(xpath = "//p-paginator/div/button[3]")
	WebElement nextPageLink;

	@FindBy(xpath = "//p-paginator/div/button[4]")
	WebElement lastPageLink;

	@FindBy(xpath = "//p-paginator/div/button[2]")
	WebElement firstPageLink;

	@FindBy(xpath = "//p-paginator/div/button[1]")
	WebElement previousPageLink;

	@FindBy(xpath = "//p-paginator/div/span")
	WebElement FooterText;

	@FindBy(xpath = "//span[contains(text(),'Showing')]")
	WebElement paginationText;

	@FindBy(xpath = "//p-table/div/div[2]/div")
	WebElement footerText;

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
		CommonUtils.waitForElementVisibility(driver, programDetails, 10);
		CommonUtils.waitForElementStaleness(driver, programDetails, 5);
		return programDetails.isDisplayed();
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
		CommonUtils.waitForElementStaleness(driver, progSearchBox, 5);

		CommonUtils.moveToElementAndClick(driver, progSearchBox);
		CommonUtils.sendInput(driver, progSearchBox, progName);
		return progName;

	}

	public String SearchByProgramDesc(String progDesc) {
		CommonUtils.waitForElementVisibility(driver, progSearchBox, 10);
		CommonUtils.moveToElementAndClick(driver, progSearchBox);
		CommonUtils.sendInput(driver, progSearchBox, progDesc);
		return progDesc;

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
		CommonUtils.waitForElementVisibility(driver, activeRadioBtn, 20);
		return activeRadioBtn.isSelected();
	}

	public boolean inactiveRadioBtnSelected() {
		CommonUtils.waitForElementclickable(driver, inactiveRadioBtn, 20);
		return inactiveRadioBtn.isSelected();
	}

	public void clickX() {
		CommonUtils.moveToElementAndClick(driver, xButton);
	}

	public void clickEditIcon() {
		CommonUtils.waitForElementStaleness(driver, editProgramIcon, 5);

		CommonUtils.moveToElementAndClick(driver, editProgramIcon);
	}

	public boolean progUpdateMesgDisplayed() {
		return progUpdatedMesg.isDisplayed();

	}

	public void clickDeleteIcon() {
		CommonUtils.waitForElementVisibility(driver, deleteProgramIcon, 20);
		CommonUtils.moveToElementAndClick(driver, deleteProgramIcon);
	}

	public void clickYesBtn() {
		CommonUtils.moveToElementAndClick(driver, YesButton);

	}

	public void clickNoBtn() {
		CommonUtils.waitForElementVisibility(driver, NoButton, 20);
		CommonUtils.moveToElementAndClick(driver, NoButton);

	}

	public boolean progDeleteMesgDisplayed() {
		CommonUtils.waitForElementVisibility(driver, progDeleteMesg, 10);
		return progDeleteMesg.isDisplayed();
	}

	public String validateNoOfEntries() {
		CommonUtils.waitForElementVisibility(driver, noOfProgramEntries, 10);
		return noOfProgramEntries.getText();
	}

	public boolean confirmDeletePopupDisplayed() {
		CommonUtils.waitForElementVisibility(driver, confirmDeletePopup, 20);
		return confirmDeletePopup.isDisplayed();

	}

	public boolean confirmDeletePopupDisappears() {
		CommonUtils.waitForElementInVisibility(driver, confirmDeletePopup, 10);
		return !confirmDeletePopup.isDisplayed();

	}

	public void clickDeletePopupX() {
		CommonUtils.waitForElementclickable(driver, deletePopupXButton, 10);
		CommonUtils.moveToElementAndClick(driver, deletePopupXButton);

	}

	public void clickSortProgramName() throws InterruptedException {

		CommonUtils.waitForElementclickable(driver, clickSortProgramName, 5);
		CommonUtils.clickElementUsingJS(driver, clickSortProgramName);

	}

	public List<String> getProgramNamesText() {
		return programNames.stream().map(WebElement::getText)// Extract text from each WebElement
				.map(String::toLowerCase).collect(Collectors.toList()); // Collect them into a list
	}

	public void clickSortProgramDescription() throws InterruptedException {
		CommonUtils.waitForElementclickable(driver, clickSortProgramDescription, 5);
		CommonUtils.clickElementUsingJS(driver, clickSortProgramDescription);
	}

	public List<String> getProgramDescriptionsText() {
		return programDescriptions.stream().map(WebElement::getText).map(String::toLowerCase)
				.collect(Collectors.toList());
	}

	public void clickSortProgramStatus() throws InterruptedException {
		CommonUtils.waitForElementclickable(driver, clickSortProgramStatus, 5);
		CommonUtils.clickElementUsingJS(driver, clickSortProgramStatus);
	}

	public List<String> getProgramsStatusText() {
		return programsStatus.stream().map(WebElement::getText).map(String::toLowerCase) // Extract text from each
																							// WebElement
				.collect(Collectors.toList()); // Collect them into a list
	}

	public String programName() {
		CommonUtils.waitForElementStaleness(driver, programNames.get(0), 30);
		return programNames.get(0).getText();

	}

	public String programDecription() {
		// CommonUtils.waitForElementStaleness(driver, programDescriptions.get(0), 30);
		return programDescriptions.get(0).getText();

	}

	public String programStatus() {
		// CommonUtils.waitForElementStaleness(driver, programsStatus.get(0), 30);
		return programsStatus.get(0).getText();
	}

	public List<String> getProgramHeaders() {
		List<String> headers = new ArrayList<>();
		for (int i = 0; i < programHeader.size(); i++) {
			headers.add(programHeader.get(i).getText());
			LoggerLoad.info("Header " + (i + 1) + ": " + programHeader.get(i).getText());
		}
		return headers; // Return the list of all headers
	}

	public boolean LeftDeleteIconEnabled() {
		return leftDeleteIcon.isEnabled();
	}

	public String searchbox() {

		CommonUtils.waitForElementVisibility(driver, progSearchBox, 30);
		return progSearchBox.getAttribute("placeholder");
	}

	public boolean isHeaderCheckboxUnchecked() {
		return !headerCheckbox.isSelected();
	}

	public boolean areCheckboxesUnchecked() {
		for (WebElement checkbox : allCheckboxes) {
			if (checkbox.isSelected()) {
				return false;
			}
		}
		return true;
	}

	public String getPaginationText() {
		return paginationText.getText();
	}

	public boolean isNextPageLinkVisible() {
		return nextPageLink.isDisplayed();
	}

	public boolean isPreviousPageLinkVisible() {
		return previousPageLink.isDisplayed();
	}

	public boolean isFirstPageLinkVisible() {
		return nextPageLink.isDisplayed();
	}

	public boolean isLastPageLinkVisible() {
		return lastPageLink.isDisplayed();
	}

	public String getFooterText() {
		CommonUtils.waitForElementVisibility(driver, FooterText, 20);
		// CommonUtils.waitForElementStaleness(driver, FooterText, 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FooterText);
		return CommonUtils.getText(FooterText);
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void clickNextPage() {
		CommonUtils.moveToElementAndClick(driver, nextPageLink);
	}

	public void clickPreviousPage() {
		CommonUtils.moveToElementAndClick(driver, previousPageLink);

	}

	public void clickFirstPage() {
		CommonUtils.moveToElementAndClick(driver, firstPageLink);

	}

	public void clickLastPage() {
		CommonUtils.moveToElementAndClick(driver, lastPageLink);

	}

	public boolean isNextPageLinkEnabled() {
		return nextPageLink.isEnabled();
	}

	public boolean isPreviousPageLinkEnabled() throws InterruptedException {

		return previousPageLink.isEnabled();
	}

	public boolean isFirstPageLinkEnabled() {
		return nextPageLink.isEnabled();
	}

	public boolean isLastPageLinkEnable() {
		return lastPageLink.isEnabled();
	}

}
