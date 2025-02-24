package lms.PageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lms.Utilities.CommonUtils;
import lms.Utilities.ConfigReader;

public class BatchPage {

	WebDriver driver;

	public BatchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// links
	@FindBy(xpath = "//*[text()='Batch']")
	WebElement batchLink;

	@FindBy(xpath = "//button[@id='logout']")
	WebElement batchLogout;

	@FindBy(xpath = "//span[text()='Login']")
	WebElement loginButton;

	@FindBy(xpath = "//button[normalize-space()='Add New Batch']")
	WebElement addNewBatchLink;

	// titles
	@FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
	WebElement titleOfLMS;

	@FindBy(xpath = "//div[normalize-space()='Manage Batch']")
	WebElement manageBatchHeading;

	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']//span[@class='p-button-icon pi pi-trash']")
	WebElement deleteIconManageBatch;

	@FindBy(xpath = "//div[@class='action']//button[@icon='pi pi-trash']")
	WebElement deleteIcons;

	@FindBy(xpath = "//div[@class='action']//button[@icon='pi pi-pencil']")
	WebElement editIcons;

	@FindBy(xpath = "//table/tbody/tr//div[@role='checkbox']")
	WebElement checkBoxRows;

	@FindBy(xpath = "//thead[@class='p-datatable-thead']//th/p-sorticon")
	WebElement sortIconHeader;

	@FindBy(xpath = "//th[@psortablecolumn='programName']/p-sorticon")
	WebElement programNameSortIcon;

	@FindBy(xpath = "//th[@psortablecolumn='batchDescription']/p-sorticon")
	WebElement batchDescSortIcon;

	@FindBy(xpath = "//th[@psortablecolumn='batchStatus']/p-sorticon")
	WebElement batchStatusSortIcon;

	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	WebElement dataTableCheckbox;

	@FindBy(xpath = "//thead[@class='p-datatable-thead']")
	WebElement dataTableHeader;

	// pagination elements

	@FindBy(xpath = "//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']")
	WebElement paginationControl;
	@FindBy(xpath = "//p-paginator[@class='ng-star-inserted']")
	WebElement pagination;

	@FindBy(xpath = "//button[contains(@class, 'p-paginator-next')]") // span[contains(@class,'pi-angle-right')]
	WebElement nextPage;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']")
	WebElement doubleNextPage;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']")
	WebElement previousPage;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']")
	WebElement doubleLeftPage;

	// Add New Batch PopUP

	@FindBy(xpath = "//span[text()='Batch Details']")
	WebElement batchPopupHeading;

	@FindBy(xpath = "//div[@role='button']")
	WebElement programNameDropDown;

	@FindBy(xpath = "//input[@placeholder='Select a Program name']")
	WebElement programeName;

	@FindBy(xpath="//input[@type='text' and @id='batchName']")
	WebElement batchName;
	
	@FindBy(xpath = "//input[@id='batchProg']")
	WebElement batchNamePrefix;

	@FindBy(xpath = "//input[@id='batchName']")
	WebElement batchNameSuffix;

	@FindBy(xpath = "//input[@id='batchDescription']")
	WebElement description;

	@FindBy(xpath = "//input[@id='ACTIVE']")
	WebElement activeStatus;

	@FindBy(xpath = "//input[@id='INACTIVE']")
	WebElement inActiveStatus;

	@FindBy(xpath = "//input[@id='batchNoOfClasses']")
	WebElement noOfClasses;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement saveButton;

	// pop up error msgs
	@FindBy(xpath = "//small[text()='Program Name is required.']")
	WebElement programEmptyErrorMsg;

	@FindBy(xpath = "//small[text()='Batch Name is required.']")
	WebElement batchNameEmptyErrorMsg;

	@FindBy(xpath = "//small[text()='This field accept only numbers and max 5 count. ']")
	WebElement batchSuffixNumErrorMsg;

	@FindBy(xpath = "//small[text()='Batch Description is required.']")
	WebElement batchDescEmptyErrorMsg;
	
	@FindBy(xpath = "//small[text()='This field should start with an alphabet and min 2 character.']")
	WebElement batchDescInavlidErrorMsg;

	@FindBy(xpath = "//small[text()='Number of classes is required.']")
	WebElement noOfClassesErrorMsg;

	@FindBy(xpath = "//span[text()='Showing 0 to 0 of 0 entries']")
	WebElement emptyResults;

	// delete elements

	@FindBy(xpath = "//span[normalize-space()='Confirm']")
	WebElement deleteConfirmMsg;

	@FindBy(xpath = "//span[@class='p-button-icon p-button-icon-left pi pi-times']/following-sibling::span")
	WebElement deleteNoButton;

	@FindBy(xpath = "//span[@class='p-button-icon p-button-icon-left pi pi-check']/following-sibling::span")
	// @FindBy(xpath="//button[@class='p-button-rounded p-button-danger p-button
	// p-component p-button-icon-only']//span[@class='p-button-icon pi pi-trash']")
	WebElement deleteYesButton;

	@FindBy(xpath = "//*[text()='Successful']")
	WebElement toastMsg;

	@FindBy(xpath = "//button[contains(@class, 'p-dialog-header-close')]")
	WebElement deleteCloseButton;

	// checkbox
	@FindBy(xpath = "//div[@role='checkbox' and @class='p-checkbox-box p-component']")
	WebElement checkboxes;

	// search box
	@FindBy(xpath = "//input[@id='filterGlobal']")
	WebElement searchBox;
	
	
	public String getDescriptInvalidMsgDisplayed() {
		
		return batchDescInavlidErrorMsg.getText();
	}

	public boolean isBatchNameEnabled() {
		return batchName.isEnabled();
	}
	public boolean isProgramNameDisabled() {
		return programeName.isEnabled();
	}
	public void clickEditIcon() {
		CommonUtils.clickElement(driver, editIcons);
	}
	public boolean isBatchPopupDisplayed() {

		return driver.findElements(By.xpath("//span[text()='Batch Details']")).size() > 0;
	}

	public String getEmptyResultText() {

		return emptyResults.getText();
	}

	public void clickCancelButton() {

		CommonUtils.clickElement(driver, cancelButton);
	}

	public WebElement getBatchPrefixTextBox() {
		return batchNamePrefix;
	}

	public String getBatchSuffixErrorMessage() {

		return batchSuffixNumErrorMsg.getText();
	}

	public String getNumberOfClassErrorMessage() {

		return noOfClassesErrorMsg.getText();
	}

	public boolean areAllFieldsEnabled() {

		/*
		 * String f[] = { "//div[@role='button']", "//input[@id='batchName']",
		 * "//input[@id='batchDescription']", "//input[@id='ACTIVE']",
		 * "//input[@id='INACTIVE']", "//input[@id='batchNoOfClasses']"};
		 */

		List<WebElement> fields = new ArrayList<>();
		fields.add(programNameDropDown);
		fields.add(batchNameSuffix);
		fields.add(description);
		fields.add(activeStatus);
		fields.add(activeStatus);
		fields.add(noOfClasses);

		boolean allEnabled = true;

		for (WebElement field : fields) {

			if (field.isEnabled() == false)
				allEnabled = false;
		}

		return allEnabled;
	}

	public boolean getBatchPopupHeading() {
		return batchPopupHeading.isDisplayed();
	}

	public boolean addNewBatchPresent() {
		return addNewBatchLink.isDisplayed();
	}

	public boolean loginButtonPresent() {
		return loginButton.isDisplayed();
	}

	public void clickLogout() {
		CommonUtils.clickElement(driver, batchLogout);
	}

	public void clickDelete() {
		// deleteIconManageBatch.click();

		CommonUtils.clickElement(driver, deleteIconManageBatch);

	}

	public String getProgramNameFromResults(int rowNo) {

		WebElement ele = driver.findElement(By.xpath("//tbody[@class='p-datatable-tbody']/tr[" + rowNo + "]/td[6]"));
		return ele.getText();
	}

	public void validateSearch() {

		searchBox.sendKeys(ConfigReader.getProperty("program.name"));
		CommonUtils.waitForRefresh(2000);
	}

	public void searchBatch(String searchKey) {

		searchBox.sendKeys(searchKey);
		CommonUtils.waitForRefresh(2000);
	}

	public void setPName(String progName) {
		searchBox.sendKeys(progName);

	}

	public String getPrefixName() {

		WebElement ele = driver.findElement(By.id("batchProg"));

		System.out.println("Program Prefix: " + ele.getText());
		System.out.println("Program getTagName: " + ele.getTagName());
		System.out.println("Program getTagName: " + ele.toString());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String batchName = (String) js.executeScript("return arguments[0].text", ele);

		System.out.println("Program using javascript exect: " + batchName);
		return batchNamePrefix.getText();
	}

	public void enterBatchData(Map<String, String> data, boolean save) {

		selectProgram(ConfigReader.getProperty("program.name"));

		setBatchNameSuffix(data.get("batch-suffix"));
		setProgramDescription(ConfigReader.getProperty("program.description"));
		selectStatus(data.get("status"));
		setNumOfClasses(data.get("no-of-classes"));

		if (save)
			clickSaveButton();
		System.out.println("Values set");

	}

	public void clickSaveButton() {

		CommonUtils.clickElement(driver, saveButton);
	}

	public void setBatchNameSuffix(String st) {

		batchNameSuffix.sendKeys(st);
	}

	public void setNumOfClasses(String st) {

		noOfClasses.sendKeys(st);
	}

	public void setProgramDescription(String st) {

		description.clear();
		description.sendKeys(st);
	}

	public void selectStatus(String st) {

		WebElement ele = driver.findElement(By.id(st));
		CommonUtils.clickElement(driver, ele);
	}

	public void selectProgram(String st) {

		CommonUtils.clickElement(driver, programNameDropDown);
		WebElement ele = driver.findElement(By.xpath("//span[normalize-space()='" + st + "']"));
		CommonUtils.clickElement(driver, ele);
	}

	public void clickOnAddNewBatchLink() {

		CommonUtils.clickElement(driver, addNewBatchLink);
	}

	public void clickCheckboxes() {

		List<WebElement> checkbox = driver
				.findElements(By.xpath("//div[@role='checkbox' and @class='p-checkbox-box p-component']"));

		System.out.println(checkbox.size());

		for (int i = 0; i < checkbox.size(); i += 4) {

			CommonUtils.clickElement(driver, checkbox.get(i));

		}
		System.out.println("done checking");

	}

	public void selectCheckboxe(int rowNo) {

		List<WebElement> checkbox = driver
				.findElements(By.xpath("//div[@role='checkbox' and @class='p-checkbox-box p-component']"));

		CommonUtils.clickElement(driver, checkbox.get(rowNo));

		System.out.println("done checking");

	}

	public void gotoPage(int pageNo) {

		WebElement pageLink = driver.findElement(By.xpath(
				"//button[contains(@class, \"p-paginator-page p-paginator-element p-link p-ripple ng-star-inserted\") and contains(text(), '"
						+ pageNo + "') ]"));

		CommonUtils.clickElement(driver, pageLink);

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", pageLink);
	}

	public int getCurrentPage() {

		int pageNo = 0;
		WebElement currentPageLink = driver.findElement(By.xpath(
				"//button[@class='p-paginator-page p-paginator-element p-link p-ripple ng-star-inserted p-highlight']"));

		try {

			pageNo = Integer.parseInt(currentPageLink.getText());
		} catch (Exception e) {
		}

		return pageNo;

	}

	public void clickNextPagination() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", nextPage);
	}

	public void clickDoubleNextPagination() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", doubleNextPage);
	}

	public boolean getDoubleNextPage() {

		return doubleNextPage.isEnabled();
	}

	public boolean getNextPage() {
		return nextPage.isEnabled();
	}

	public void clickPreviousPagination() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", previousPage);
	}

	public void clickDblPrePagination() {
		doubleLeftPage.click();
	}

	public String getToastMsg() {
		waitForElementToBeVisible(toastMsg, 15);
		return toastMsg.getText();
	}

	public void waitForElementToBeVisible(WebElement element, int i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickDeleteYesBtn() {
		CommonUtils.clickElement(driver, deleteYesButton);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", deleteYesButton);
	}

	public void clickDeleteNoBtn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deleteNoButton);
	}

	public void clickCloseButton() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deleteCloseButton);

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

	public void clickDeleteIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement deleteIcon = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='action']//button[@icon='pi pi-trash']")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deleteIcon);
	}

	public void clickDeleteIcon(String progName) {

		// td[text()='Inheritance-Java']/following-sibling::td/div/span[2]/button

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement deleteIcon = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//td[text()='" + progName + "']/following-sibling::td/div/span[2]/button")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deleteIcon);
	}

	public void clickOnBatchLink() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement batchLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Batch']")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", batchLink);
	}

	public String getLMSPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getManageBatchHeading() {
		String heading = manageBatchHeading.getText();
		return heading;
	}

	public boolean deleteIconManage() {
		return deleteIconManageBatch.isEnabled();
	}

	public boolean getPaginationControl() {
		return paginationControl.isEnabled();
	}

	public int getEditIcons() {

		List<WebElement> li = driver.findElements(By.xpath("//div[@class='action']//button[@icon='pi pi-trash']"));
		return li.size();
	}

	public int getDeleteIcons() {

		List<WebElement> li = driver.findElements(By.xpath("//div[@class='action']//button[@icon='pi pi-trash']"));
		return li.size();
	}

	public int getCheckBoxes() {
		List<WebElement> li = driver.findElements(By.xpath("//table/tbody/tr//div[@role='checkbox']"));
		return li.size();

	}

	public void verifyHeader() {

		List<String> expectedHeader = Arrays.asList("", "Batch Name", "Batch Description", "Batch Status",
				"No Of Classes", "Program Name", "Edit / Delete");

		List<WebElement> headers = driver.findElements(By.xpath("//thead[@class='p-datatable-thead']/tr/th"));

		for (int i = 1; i < headers.size(); i++) {

			System.out.println("Getting value from header");
			String webPageHeader = headers.get(i).getText();
			System.out.println("Check Header : " + webPageHeader);
			assertEquals(webPageHeader, expectedHeader.get(i));
		}

	}

	public boolean getDataTableCheckbox() {
		return dataTableCheckbox.isEnabled();
	}

	public int getsortIconHeader() {
		List<WebElement> li = driver.findElements(By.xpath("//thead[@class='p-datatable-thead']//th/p-sorticon"));
		return li.size();
	}

}