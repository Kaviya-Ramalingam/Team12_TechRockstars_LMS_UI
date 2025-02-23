package lms.PageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BatchPage {

	WebDriver driver;

	public BatchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// @FindBy(xpath = "//span[normalize-space()='Batch']")
	@FindBy(xpath = "//*[text()='Batch']")
	WebElement batchLink;

	@FindBy(xpath = "//button[normalize-space()='Add New Batch']")
	WebElement addNewBatchLink;

	@FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
	WebElement titleOfLMS;

	@FindBy(xpath = "//div[normalize-space()='Manage Batch']")
	WebElement manageBatchHeading;

	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']//span[@class='p-button-icon pi pi-trash']")
	WebElement deleteIconManageBatch;

	@FindBy(xpath = "//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']")
	WebElement paginationControl;

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

	@FindBy(xpath = "//p-paginator[@class='ng-star-inserted']")
	WebElement pagination;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']") // span[contains(@class,'pi-angle-right')]
	WebElement nextPage;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']")
	WebElement doubleNextPage;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']")
	WebElement previousPage;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']")
	WebElement doubleLeftPage;

	// Add New Batch PopUP
	@FindBy(xpath = "//div[@role='button']")
	WebElement programNameDropDown;

	@FindBy(xpath = "//input[@placeholder='Select a Program name']")
	WebElement programeName;

	@FindBy(xpath = "//input[@id='batchProg']")
	WebElement batchNamePrefix;

	@FindBy(xpath = "//body//app-root//input[2]")
	WebElement batchNameSuffix;

	@FindBy(xpath = "//input[@id='batchDescription']")
	WebElement description;

	@FindBy(xpath = "//div[@class='p-radiobutton-box p-highlight']")
	WebElement activeStatus;

	@FindBy(xpath = "//div[@class='p-radiobutton-box']")
	WebElement inActiveStatus;

	@FindBy(xpath = "//input[@id='batchNoOfClasses']")
	WebElement noOfClasses;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//span[@class='p-dialog-header-close-icon ng-tns-c81-25 pi pi-times']")
	WebElement deleteCloseButton;

	@FindBy(xpath = "//small[text()='Program Name is required.']")
	WebElement programEmptyErrorMsg;

	@FindBy(xpath = "//small[text()='Batch Name is required.']")
	WebElement batchNameEmptyErrorMsg;

	@FindBy(xpath = "//small[text()='Batch Description is required.']")
	WebElement batchDescEmptyErrorMsg;

	@FindBy(xpath = "//small[text()='Number of classes is required.']")
	WebElement noOfClassesEmptyErrorMsg;

	@FindBy(xpath = "//span[normalize-space()='Confirm']")
	WebElement deleteConfirmMsg;

	@FindBy(xpath = "//span[@class='p-button-icon p-button-icon-left pi pi-times']/following-sibling::span")
	WebElement deleteNoButton;

	@FindBy(xpath = "//span[@class='p-button-icon p-button-icon-left pi pi-check']/following-sibling::span")
	WebElement deleteYesButton;
	
	public void clickDeleteButtons(String buttonName) {
		WebElement overlay = driver.findElement(By.className("cdk-overlay-backdrop"));
		overlay.click();
		if (buttonName.equalsIgnoreCase("yes")) {
			deleteYesButton.click();
		} else if (buttonName.equalsIgnoreCase("no")) {
			deleteNoButton.click();
		} else {
			deleteCloseButton.click();
		}
	}

	
	public void clickDeleteYesBtn() {
		deleteYesButton.click();
	}
	
	public void clickDeleteNoBtn() {
		deleteNoButton.click();
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
		// deleteIcons.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deleteIcons);
	}

	public void clickOnBatchLink() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", batchLink);
		//batchLink.click();
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
