package lms.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import lms.Utilities.CommonUtils;

public class ClassPage {
	WebDriver driver;

	public ClassPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath = "//span[text()='Class']")
	// WebElement class;

	@FindBy(xpath = "//button[text()='Add New Class']")
	WebElement addNewClassBtn;
	@FindBy(xpath = "//span[text()='Class Details']")
	WebElement popupHeader;
	@FindBy(xpath = "//button[contains(@class,'p-dialog-header-close')]")
	WebElement closeBtnInPopup;
	@FindBy(xpath = "//button[@label='Cancel']")
	WebElement cancelBtnInPopup;
	@FindBy(xpath = "//button[@label='Save']")
	WebElement saveBtnInPopup;
	@FindBy(xpath = "//span[normalize-space()='Class']")
	WebElement classtab;
	@FindBy(xpath = "//label[normalize-space()='Batch Name']")
	WebElement batchNameLabel;
	@FindBy(xpath = "//label[normalize-space()='Class Topic']")
	WebElement classTopicLabel;
	@FindBy(xpath = "//label[normalize-space()='Class Description']")
	WebElement classDescriptionLabel;
	@FindBy(xpath = "//lable[@for='online']")
	WebElement statusLabel;
	@FindBy(xpath = "//label[normalize-space()='Select Class Dates']")
	WebElement classDateLabel;
	@FindBy(xpath = "//label[normalize-space()='Staff Name']")
	WebElement staffNameLabel;
	@FindBy(xpath = "//label[normalize-space()='No of Classes']")
	WebElement noOfClassesLabel;
	// ****************************************************
	@FindBy(xpath = "//input[@id='icon']")
	WebElement noOfClasses;
	@FindBy(xpath = "//input[@placeholder='Select a Batch Name']")
	public WebElement batchNameTextbox;
	@FindBy(xpath = "(//div[contains(@class,'p-dropdown-trigger')])[1]")
	public WebElement batchNameDropdownIcon;
	// @FindBy(xpath = "//li[@role='option']")
	// List<WebElement> dropdownOptions;
	@FindBy(xpath = "//input[@id='classTopic']")
	WebElement classTopicTextbox;
	@FindBy(xpath = "//input[@id='classDescription']")
	WebElement classDescriptionTextbox;
	@FindBy(xpath = "//input[@id='icon']")
	WebElement classDateTextbox;
	@FindBy(xpath = "//label[normalize-space()='Staff Name']")
	WebElement staffNameTextbox;
	@FindBy(xpath = "//div[contains(text(),'Active')]//div[2]")
	WebElement statusActiveRadioBtn;
	// @FindBy(xpath = "//div[@class='ng-trigger ng-trigger-overlayAnimation
	// ng-tns-c92-90 p-datepicker p-component ng-star-inserted']")
	// WebElement calender;
	// @FindBy(xpath ="//div[@class='p-toast-detail ng-tns-c20-76']")
	// WebElement successMsg;
	@FindBy(xpath = "//small[normalize-space()='Batch Name is required.']")
	WebElement redErrorTextMsg;
	@FindBy(xpath = "//tr[4]/td[1][@class='ng-tns-c92-90 ng-star-inserted']//span")
	WebElement disableDate;

	// ***************************************************
	@FindBy(xpath = "//button[@type='button']//span[@class='p-button-icon pi pi-calendar']")
	WebElement calender;
	@FindBy(xpath = "//*[text()='Class Created Successfully']\"")
	WebElement successMsg;
	@FindBy(xpath = "//p-dropdown[@id='staffId']/div/div[@role='button']/span")
	WebElement staffnameDropdown;
	@FindBy(xpath = "//button[@id = 'saveProgram']")
	WebElement saveButton;
	@FindBy(xpath = "//table[@class= 'p-datepicker-calendar ng-tns-c92-34']//tbody/tr[5]/td[3]")
	WebElement SelectDate;
	@FindBy(tagName = "body")
	WebElement clickOutside;
	@FindBy(xpath = "//p-dropdown[@id='batchName']//div//div[@role='button']/span")
	WebElement batchNameDropDown;

	// ***********************************
	public void getMandatoryField(String classTopics) {
		CommonUtils.sendInput(driver, classTopicTextbox, classTopics);
	}

	public void clickDate() {
		CommonUtils.clickElementUsingJS(driver, classDateTextbox);

	}

	public void clickCalendar() {
		CommonUtils.waitForElementclickable(driver, calender, 20);
		CommonUtils.moveToElementAndClick(driver, calender);
		CommonUtils.moveToElementAndClick(driver, SelectDate);
		CommonUtils.moveToElementAndClick(driver, clickOutside);
	}

	public void staffNameDropdown() {
		CommonUtils.moveToElementAndClick(driver, staffnameDropdown);
		Select select = new Select(staffnameDropdown);
		select.selectByVisibleText("Steve Job");
	}

	public void clickActiveRadioButton() {
		CommonUtils.moveToElementAndClick(driver, statusActiveRadioBtn);
	}

	public void clickSave() {
		CommonUtils.moveToElementAndClick(driver, saveBtnInPopup);
	}

//*******************************
	public void clickCancel() {
		CommonUtils.moveToElementAndClick(driver, cancelBtnInPopup);
	}

	public void clickXutton() {
		CommonUtils.moveToElementAndClick(driver, closeBtnInPopup);

	}

	public void getClassTab() {
		classtab.click();
	}

	public void clickaddNewClass() {
		addNewClassBtn.click();
	}

	public boolean getPopUpDetails() {
		if (cancelBtnInPopup.isDisplayed() && saveBtnInPopup.isDisplayed() && closeBtnInPopup.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean getPopUpInputFields() {
		if (batchNameLabel.isDisplayed() && classTopicLabel.isDisplayed() && classDescriptionLabel.isDisplayed()
				&& classDateLabel.isDisplayed() && noOfClassesLabel.isDisplayed() && staffNameLabel.isDisplayed()
				&& statusLabel.isDisplayed()) {
			return true;
		} else
			return false;
	}

	// ******************************
	public void getMandatoryField() {
		classTopicTextbox.sendKeys("Python101");
		classTopicTextbox.sendKeys("LMSHackJava");
		classDescriptionTextbox.sendKeys("SDET");
		// classDateTextbox.click();
		// calender.click();
		// staffNameTextbox.sendKeys("Max");
		// statusActiveRadioBtn.click();
		// saveBtnInPopup.click();

	}

	public boolean getAddNewClassMsg() {
		// String msg = successMsg.getText();
		return successMsg.isDisplayed();
	}

	public void getClassDateTextbox() {
		classDateTextbox.click();
	}

	public boolean getNoOfClasses() {
		return noOfClasses.isDisplayed();
	}

	public boolean getRedErrorTextMsg() {
		return redErrorTextMsg.isDisplayed();
	}

	public void getDatepicker() {
		classDateTextbox.click();
	}

	public boolean getDisableWeekendDate() {
		return disableDate.isDisplayed();
	}

	public void valueInOptionalField() {
		classDescriptionTextbox.sendKeys("SDET");
		statusActiveRadioBtn.click();
		saveBtnInPopup.click();
	}

	public void saveWithInvalid() {
		classTopicTextbox.sendKeys("Python");
		classTopicTextbox.sendKeys("LMS");
		classDescriptionTextbox.sendKeys("class");
		staffNameTextbox.sendKeys("sam");
		statusActiveRadioBtn.click();
		saveBtnInPopup.click();
	}

}