package lms.PageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

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


		
		// Login Page WebElements
	
		@FindBy(id = "username") public WebElement usernameBox;
		@FindBy(id = "password") public WebElement passwordBox;
		@FindBy(id = "login") public WebElement loginBtn;
		
		// Navigation Bar WebElements
		
		@FindBy(xpath = "//span[text()='Class']") public WebElement classLinkInNavigationBar;
		
		@FindBy(xpath = "//span[text()='Program']") public WebElement programLinkInNavigationBar;
		
		@FindBy(xpath = "//span[text()='Batch']") public WebElement batchLinkInNavigationBar;
		
		@FindBy(xpath = "//span[text()='Logout']") public WebElement logoutLinkInNavigationBar;
		
		@FindBy(xpath = "//app-header//span[text()=' LMS - Learning Management System ']") public WebElement titleInNavigationBar;
		
		
		// Class Page WebElements
		
		@FindBy(xpath = "//mat-card-title/div[contains(text(), 'Manage Class')]") public WebElement manageClassHeader;
		
		@FindBy(xpath = "//input[@placeholder='Search...']") public WebElement searchTextBox;
		
		@FindBy(xpath = "(//button[@ng-reflect-icon='pi pi-trash'])[1]") public WebElement deleteBtnUnderManageClassHeader;
		
		
		// Table Header WebElements
		
		@FindBy(xpath = "//table//th[contains(text(),'Batch Name')]") public WebElement batchNameTableHeader;
		
		@FindBy(xpath = "//table//th[contains(text(),'Batch Name')]/p-sorticon") public WebElement batchNameSortIcon;
		
		@FindBy(xpath = "//table//th[contains(text(),'Class Topic')]") public WebElement classTopicTableHeader;
		
		@FindBy(xpath = "//table//th[contains(text(),'Class Topic')]/p-sorticon") public WebElement classTopicSortIcon;
		
		@FindBy(xpath = "//table//th[contains(text(),'Class Description')]") public WebElement classDescriptionTableHeader;
		
		@FindBy(xpath = "//table//th[contains(text(),'Class Description')]/p-sorticon") public WebElement classDescriptionSortIcon;
		
		@FindBy(xpath = "//table//th[contains(text(),'Status')]") public WebElement statusTableHeader;
		
		@FindBy(xpath = "//table//th[contains(text(),'Status')]/p-sorticon") public WebElement statusSortIcon;
		
		@FindBy(xpath = "//table//th[contains(text(),'Class Date')]") public WebElement classDateTableHeader;
		
		@FindBy(xpath = "//table//th[contains(text(),'Class Date')]/p-sorticon") public WebElement classDateSortIcon;
		
		@FindBy(xpath = "//table//th[contains(text(),'Staff Name')]") public WebElement staffNameTableHeader;
		
		@FindBy(xpath = "//table//th[contains(text(),'Staff Name')]/p-sorticon") public WebElement staffNameSortIcon;
		
		@FindBy(xpath = "//table//th[contains(text(),'Edit / Delete')]") public WebElement editOrDeleteTableHeader;
		
		@FindBy(xpath = "//th[@class='p-sortable-column']") public List<WebElement> tableHeaders;
		
		@FindBy(xpath = "//th[@class='p-sortable-column']/p-sorticon") public List<WebElement> sortIcons;
	
		@FindBy(xpath = "//tbody//td[2]") public List<WebElement> batchNameTableData;
		
		@FindBy(xpath = "//tbody//td[3]") public List<WebElement> classTopicTableData;
		
		@FindBy(xpath = "//tbody//td[4]") public List<WebElement> classDescriptionTableData;
		
		@FindBy(xpath = "//tbody//td[5]") public List<WebElement> statusTableData;
		
		@FindBy(xpath = "//tbody//td[6]") public List<WebElement> classDateTableData;
		
		@FindBy(xpath = "//tbody//td[7]") public List<WebElement> staffNameTableData;
		
		
		// Add New Class and Class Details Pop-up Window WebElements
		
		@FindBy(xpath = "//button[text()='Add New Class']") public WebElement addNewClassBtn;
		
		@FindBy(xpath = "//span[text()='Class Details']") public WebElement popupHeader;
		
		@FindBy(xpath = "//button[contains(@class,'p-dialog-header-close')]") public WebElement closeBtnInPopup;
		
		@FindBy(xpath = "//button[@label='Cancel']") public WebElement cancelBtnInPopup;
		
		@FindBy(xpath = "//button[@label='Save']") public WebElement saveBtnInPopup;
		
		@FindBy(xpath = "//label[@class='requiredSession']") public WebElement requiredField;
		
		@FindBy(xpath = "//label[text()='Batch Name']") public WebElement batchNameLabel;
		
		@FindBy(xpath = "//label[text()='Batch Name']/..//input[contains(@class,'p-inputtext')]") public WebElement batchNameTextbox;
		
		@FindBy(xpath = "(//div[contains(@class,'p-dropdown-trigger')])[1]") public WebElement batchNameDropdownIcon;
		
		@FindBy(xpath = "//li[@role='option']") public List<WebElement> dropdownOptions;
		
		@FindBy(xpath = "//label[text()='Class Topic ']") public WebElement classTopicLabel;
		
		@FindBy(xpath = "//input[@id='classTopic']") public WebElement classTopicTextbox;
		
		@FindBy(xpath = "//label[text()='Class Description']") public WebElement classDescriptionLabel;
		
		@FindBy(xpath = "//input[@id='classDescription']") public WebElement classDescriptionTextbox;
		
		@FindBy(xpath = "//lable[text()='Status']") public WebElement statusLabel;
		
		@FindBy(xpath = "//div[text()=' Active ']") public WebElement statusActiveLabel;
		
		@FindBy(xpath = "//div[text()=' Inactive ']") public WebElement statusInactiveLabel;
		
		@FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id='Active']") public WebElement statusActiveRadioBtn;
		
		@FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id='Inactive']") public WebElement statusInactiveRadioBtn;
		
		@FindBy(xpath = "//label[text()=' Select Class Dates ']") public WebElement classDateLabel;
		
		@FindBy(xpath = "//span[contains(@class,'p-calendar')]/input") public WebElement classDateTextbox;
		
		@FindBy(xpath = "//label[text()='Staff Name']") public WebElement staffNameLabel;
		
		@FindBy(xpath = "//label[text()='Staff Name']/..//input[contains(@class,'p-inputtext')]") public WebElement staffNameTextbox;
		
		@FindBy(xpath = "(//div[contains(@class,'p-dropdown-trigger')])[2]") public WebElement staffNameDropdownIcon;
		
		@FindBy(xpath = "//label[text()='No of Classes']") public WebElement noOfClassesLabel;
		
		@FindBy(xpath = "//input[@id='classNo']") public WebElement noOfClassesTextbox;

	    @FindBy(xpath = "//label[text()='Comments']") public WebElement commentsLabel;
		
		@FindBy(xpath = "//input[@id='classComments']") public WebElement commentsTextbox;
		
		@FindBy(xpath = "//label[text()='Notes']") public WebElement notesLabel;
		
		@FindBy(xpath = "//input[@id='classNotes']") public WebElement notesTextbox;
		
		@FindBy(xpath = "//label[text()='Recording']") public WebElement recordingLabel;
		
		@FindBy(xpath = "//input[@id='classRecordingPath']") public WebElement recordingTextbox;
		
		// Footer WebElement
		
		@FindBy(xpath = "//p-table/div/div[2]/div") public WebElement totalClassesTextInFooter;
		
		// Pagination WebElements
		
		@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']") public WebElement paginationTextInFooter;
		
		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-left']/..") public WebElement doubleLeftAngleIconPagination;
		
		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']/..") public WebElement leftAngleIconPagination;
		
		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']/..") public WebElement RightAngleIconPagination;
		
		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']/..") public WebElement doubleRightAngleIconPagination;
		
		@FindBy(xpath = "//span[@class='p-paginator-pages ng-star-inserted']/button") public List<WebElement> paginationPageNumbers;
		
		@FindBy(xpath = "//button[contains(@class, 'p-highlight')]") public WebElement highlightedPageNumber;
		
		@FindBy(xpath = "//button[contains(@class, 'p-disabled')]/span[@class='p-paginator-icon pi pi-angle-right']") public WebElement disabledRightAnglePaginationIcon;
		
		@FindBy(xpath = "//button[contains(@class, 'p-disabled')]/span[@class='p-paginator-icon pi pi-angle-left']") public WebElement disabledLeftAnglePaginationIcon;
	
		
// Navigation Bar Methods
		
		public void classLinkInNavigationBar()
		{
			classLinkInNavigationBar.click();
		}
		
		public void programLinkInNavigationBar()
		{
			programLinkInNavigationBar.click();
		}
		
		public void batchLinkInNavigationBar()
		{
			batchLinkInNavigationBar.click();
		}
		
		public void logoutLinkInNavigationBar()
		{
			logoutLinkInNavigationBar.click();
		}
		
		public String titleInNavigationBar()
		{
			return titleInNavigationBar.getText();
		}
		
		public String pageTitle()
		{
			String pageTitle = driver.getTitle();
			return pageTitle;
		}
		
		
// Class Page Methods		
		
		
		
		public String manageClassHeader()
		{
			return manageClassHeader.getText();
		}
		
		public boolean searchTextBox()
		{
			return 	searchTextBox.isEnabled();
		}
		
		public boolean deleteBtnUnderManageClassHeader()
		{
			return deleteBtnUnderManageClassHeader.isEnabled() && deleteBtnUnderManageClassHeader.isDisplayed();
		}
		
// Table Header Methods	
		
		public boolean batchNameTableHeader()
		{
			return batchNameTableHeader.isDisplayed();
		}

		public boolean classTopicTableHeader()
		{
			return classTopicTableHeader.isDisplayed();
		}
		
		public boolean classDescriptionTableHeader()
		{
			return classDescriptionTableHeader.isDisplayed();
		}
		
		public boolean statusTableHeader()
		{
			return statusTableHeader.isDisplayed();
		}
		
		
		public boolean classDateTableHeader()
		{
			return classDateTableHeader.isDisplayed();
		}
		
		public boolean staffNameTableHeader()
		{
			return staffNameTableHeader.isDisplayed();
		}
		
		public boolean editOrDeleteTableHeader()
		{
			return editOrDeleteTableHeader.isDisplayed();
		}
		
//Sort Icon Methods
		
		public boolean batchNameSortIcon()
		{
			boolean bnsi = batchNameSortIcon.isDisplayed() && batchNameSortIcon.isEnabled();
			return bnsi;
		}
		
		public boolean classTopicSortIcon() {
			
			return classTopicSortIcon.isDisplayed() && classTopicSortIcon.isEnabled();
		}
		
		public boolean classDescriptionSortIcon()
		{
			return classDescriptionSortIcon.isDisplayed() && classDescriptionSortIcon.isEnabled();
		}
		
		public boolean classDateSortIcon()
		{
			return classDateSortIcon.isDisplayed() && classDateSortIcon.isEnabled();
		}
		
		public boolean statusSortIcon()
		{
			return statusSortIcon.isDisplayed() && statusSortIcon.isEnabled();
		}
		public boolean staffNameSortIcon()
		{
			return staffNameSortIcon.isDisplayed() && staffNameSortIcon.isEnabled();
		}
		
		
// Add New Class and Class Details Pop-up Window Methods

	public boolean noOfClassesTextbox()
	{
		boolean noct= noOfClassesTextbox.isDisplayed();
		return noct;
	}
	public String totalClassesTextInFooter()
	{
		CommonUtils.waitForElementVisibility(driver, totalClassesTextInFooter, 20);
		// CommonUtils.waitForElementStaleness(driver, totalClassesTextInFooter, 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", totalClassesTextInFooter);
		return CommonUtils.getText(totalClassesTextInFooter);
	}

//Pagination Methods
		
		
		public boolean doubleLeftAngleIconPagination()
		{
			 
			boolean dla = doubleLeftAngleIconPagination.isDisplayed() && doubleLeftAngleIconPagination.isEnabled();
			 return dla;
		}

		public boolean leftAngleIconPagination()
		{
			
			boolean lap = leftAngleIconPagination.isDisplayed() && leftAngleIconPagination.isEnabled();
			return lap;
		}
		public boolean RightAngleIconPagination()
		{
			boolean rapicon= RightAngleIconPagination.isDisplayed() && RightAngleIconPagination.isEnabled();
			return rapicon;
		}
		public boolean doubleRightAngleIconPagination() {
			boolean drapicon= doubleRightAngleIconPagination.isDisplayed() && doubleRightAngleIconPagination.isEnabled();
			return drapicon;
		}
		


// Delete Class
		
	@FindBy(xpath = "//span[normalize-space()='Confirm']")
	WebElement deleteConfirmMsg;
	
	@FindBy(xpath = "//span[@class='p-button-icon p-button-icon-left pi pi-times']/following-sibling::span")
	WebElement deleteNoButton;

  
  public void getMandatoryField(String classTopics) {
		CommonUtils.sendInput(driver, classTopicTextbox, classTopics);

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

//***********************************************************
//Class Page Validation
	
	
	
	
//***********************************************************
//Sorting
	
//------------------Batch Name-------------------
	@FindBy(xpath = "//table[@role='grid']/tbody/tr/td[2]")
	public List<WebElement> batchNames;
	
	public List<String> getBatchNamesText() {
		return batchNames.stream().map(WebElement::getText)// Extracting text from each WebElement
				.map(String::toLowerCase).collect(Collectors.toList()); // Collecting them into a list
	}
	
	public void batchNameSorting()
	{
		//batchNameSortIcon.click();
		CommonUtils.waitForElementclickable(driver, batchNameSortIcon, 5);
		CommonUtils.clickElementUsingJS(driver, batchNameSortIcon);
	}
	
//------------------Class Topic---------------------------	
	public void classTopicSorting() {
		
		 //classTopicSortIcon.click();
		CommonUtils.waitForElementclickable(driver, classTopicSortIcon, 5);
		CommonUtils.clickElementUsingJS(driver, classTopicSortIcon);
	}
	
	public List<String> getclassTopicText() {
		return classTopicTableData.stream().map(WebElement::getText)// Extracting text from each WebElement
				.map(String::toLowerCase).collect(Collectors.toList()); // Collecting them into a list
	}
	
//--------------------------------Class Description------------	
	public void classDescriptionSorting()
	{
		//classDescriptionSortIcon.click();
		CommonUtils.waitForElementclickable(driver, classDescriptionSortIcon, 5);
		CommonUtils.clickElementUsingJS(driver, classDescriptionSortIcon);
	}
	
	public List<String> getclassDescriptionText() {
		return classDescriptionTableData.stream().map(WebElement::getText)// Extracting text from each WebElement
				.map(String::toLowerCase).collect(Collectors.toList()); // Collecting them into a list
	}

//-------------------------------------Class Date-------------------
	public void classDateSorting()
	{
		//classDateSortIcon.click();
		CommonUtils.waitForElementclickable(driver, classDateSortIcon, 5);
		CommonUtils.clickElementUsingJS(driver, classDateSortIcon);
		
	}
	
	public List<String> getclassDateTableDataText() {
		return classDateTableData.stream().map(WebElement::getText)// Extracting text from each WebElement
				.map(String::toLowerCase).collect(Collectors.toList()); // Collecting them into a list
	}
	
//------------------------------- Status Sorting -----------------
	public void statusSorting()
	{
		//statusSortIcon.click();
		CommonUtils.waitForElementclickable(driver, statusSortIcon, 5);
		CommonUtils.clickElementUsingJS(driver, statusSortIcon);
	}
	
	public List<String> getstatusTableDataText() {
		return statusTableData.stream().map(WebElement::getText)// Extracting text from each WebElement
				.map(String::toLowerCase).collect(Collectors.toList()); // Collecting them into a list
	}

//------------------------------------Staff Name---------------------
	public void staffNameSorting()
	{
		//staffNameSortIcon.click();
		CommonUtils.waitForElementclickable(driver, staffNameSortIcon, 5);
		CommonUtils.clickElementUsingJS(driver, staffNameSortIcon);
	}
	
	public List<String> getstaffNameTableDataText() {
		return staffNameTableData.stream().map(WebElement::getText)// Extracting text from each WebElement
				.map(String::toLowerCase).collect(Collectors.toList()); // Collecting them into a list
	}
	
	

