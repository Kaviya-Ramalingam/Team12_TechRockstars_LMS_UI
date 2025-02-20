package lms.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BatchPage {

	WebDriver driver;

	public BatchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Batch']")
	WebElement batchLink;

	@FindBy(xpath = "//button[normalize-space()='Add New Batch']")
	WebElement addNewBatchLink;

	@FindBy(xpath = "//div[normalize-space()='Manage Batch']")
	WebElement batchPageTitle;

	@FindBy(xpath = "//div[@class='action']//button[@icon='pi pi-trash']")
	WebElement deleteIcons;

	@FindBy(xpath = "//div[@class='action']//button[@icon='pi pi-pencil']")
	WebElement editIcons;

	@FindBy(xpath = "//table/tbody/tr//div[@role='checkbox']")
	WebElement checkBoxRows;

	@FindBy(xpath = "//th[@psortablecolumn='programName']/p-sorticon")
	WebElement programNameSortIcon;

	@FindBy(xpath = "//th[@psortablecolumn='batchDescription']/p-sorticon")
	WebElement batchDescSortIcon;

	@FindBy(xpath = "//th[@psortablecolumn='batchStatus']/p-sorticon")
	WebElement batchStatusSortIcon;

	@FindBy(xpath = "//div[@role='checkbox']")
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
	WebElement closeButton;

	@FindBy(xpath = "//small[text()='Program Name is required.']")
	WebElement programEmptyErrorMsg;

	@FindBy(xpath = "//small[text()='Batch Name is required.']")
	WebElement batchNameEmptyErrorMsg;

	@FindBy(xpath = "//small[text()='Batch Description is required.']")
	WebElement batchDescEmptyErrorMsg;

	@FindBy(xpath = "//small[text()='Number of classes is required.']")
	WebElement noOfClassesEmptyErrorMsg;

}
