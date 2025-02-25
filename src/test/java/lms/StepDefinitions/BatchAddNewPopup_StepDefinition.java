package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.*;
import lms.PageObjects.BatchPage;
import lms.PageObjects.LoginPage;
import lms.Utilities.CommonUtils;
import lms.Utilities.ConfigReader;
import lms.Utilities.ExcelReader;
import lms.Utilities.TestContextSetup;

public class BatchAddNewPopup_StepDefinition {

	TestContextSetup testcontextsetup;
	LoginPage loginpage;
	BatchPage bp;

	public BatchAddNewPopup_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		bp = testcontextsetup.pageobjectmanager.getBatchPage();
	}

	@Given("Admin is on the Add new batch pop up")
	public void admin_is_on_the_add_new_batch_pop_up() {

		String username = ConfigReader.getUsername();
		String password = ConfigReader.getpassword();
		String role = ConfigReader.getrole();
		loginpage.entervalidCredentials(username, password);
		loginpage.selectRole();
		loginpage.selectAdmin(role);
		loginpage.loginClick();

		bp.clickOnBatchLink();
		bp.clickOnAddNewBatchLink();
	}

	@When("Admin checks all the fields are enabled")
	public void admin_checks_all_the_fields_are_enabled() {
		
		System.out.println("Checking all the fields");		
		
	}

	@Then("The pop up should include the fields Batch Name,Number of classes and Description as text box, Program Name as drop down Status as radio button")
	public void the_pop_up_should_include_the_fields_batch_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button() {
		
		assertTrue(bp.areAllFieldsEnabled());		
		
	}

	@When("Admin selects program name present in the dropdown")
	public void admin_selects_program_name_present_in_the_dropdown() {
		
		bp.selectProgram(ConfigReader.getProperty("program.name"));
		

		/*try {
			@SuppressWarnings("unused")
			Map<String, String> data = ExcelReader.getData("VALID", "batch");

			bp.selectProgram(ConfigReader.getProperty("program.name"));

		} catch (Exception e) {

			e.printStackTrace();
		}*/
		//bp.getPrefixName();

	}

	@Then("Admin should see selected program name in the batch name prefix box")
	public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
		
		System.out.println("checking value");
		System.out.println("Prefix Name: "+ bp.getPrefixName());
		//assertEquals(bp.getPrefixName(), ConfigReader.getProperty("program.name"));

	}

	@When("Admin enters alphabets in batch name suffix box")
	public void admin_enters_alphabets_in_batch_name_suffix_box() {
		
		try {

			Map<String, String> data = ExcelReader.getData("INVALID-BATCH-SUFFIX", "batch");
			bp.setBatchNameSuffix(data.get("batch-suffix"));

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	@Then("Admin should get error message below the text box of respective field")
	public void admin_should_get_error_message_below_the_text_box_of_respective_field() {
		
		try {

			String uiMessage = bp.getBatchSuffixErrorMessage();			
			Map<String, String> data = ExcelReader.getData("INVALID-BATCH-SUFFIX", "batch");
			String expectedMessage = data.get("error-message");
			
			assertEquals(uiMessage, expectedMessage);

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	@When("Admin enters alphabets in batch name prefix box")
	public void admin_enters_alphabets_in_batch_name_prefix_box() {
		
		bp.getBatchPrefixTextBox().sendKeys("test");
		
	}

	@Then("Admin should see empty text box")
	public void admin_should_see_empty_text_box() {
		
		assertEquals(bp.getBatchPrefixTextBox().getText(), "");
	}

	@When("Admin enters the data only to the mandatory fiields and clicks save button")
	public void admin_enters_the_data_only_to_the_mandatory_fiields_and_clicks_save_button() {

		try {

			Map<String, String> data = ExcelReader.getData("VALID", "batch");

			bp.selectProgram(ConfigReader.getProperty("program.name"));
			
			String batchSuffix = ""+CommonUtils.getRandomNumber();
			String batchName = ConfigReader.getProperty("program.name") + batchSuffix;
			ConfigReader.setProperty("batch.name", batchName);

			bp.setBatchNameSuffix(batchSuffix);
			bp.setProgramDescription(ConfigReader.getProperty("program.description"));
			bp.selectStatus(data.get("status"));
			bp.setNumOfClasses(data.get("no-of-classes"));

			bp.clickSaveButton();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("Admin should get a successful message")
	public void admin_should_get_a_successful_message() {

		assertEquals(bp.getToastMsg(), "Successful");
	}

	@When("Admin leaves blank one of the mandatory fields")
	public void admin_leaves_blank_one_of_the_mandatory_fields() {
		
		try {

			Map<String, String> data = ExcelReader.getData("INVALID-MISSING-MANDATORY-FIELD", "batch");

			bp.selectProgram(ConfigReader.getProperty("program.name"));
			bp.setBatchNameSuffix(data.get("batch-suffix"));
			bp.setProgramDescription(ConfigReader.getProperty("program.description"));
			bp.selectStatus(data.get("status"));

			bp.clickSaveButton();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	@Then("Admin should get a error message on the respective mandatory field")
	public void admin_should_get_a_error_message_on_the_respective_mandatory_field() {
		
		try {

			String uiMessage = bp.getNumberOfClassErrorMessage();			
			Map<String, String> data = ExcelReader.getData("INVALID-MISSING-MANDATORY-FIELD", "batch");
			String expectedMessage = data.get("error-message");
			
			assertEquals(uiMessage, expectedMessage);

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	@When("Admin enters the valid data to all the mandatory fields and click save button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button() {
		
		try {

			Map<String, String> data = ExcelReader.getData("VALID", "batch");
			
			bp.enterBatchData(data, true);

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	@Then("Admin should get a succesesful message")
	public void admin_should_get_a_succesesful_message() {
		
		assertEquals(bp.getToastMsg(), "Successful");
	}

	@When("Admin enters the valid data to all the mandatory fields and click cancel button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button() {
		
		try {

			Map<String, String> data = ExcelReader.getData("VALID-MANDATORY-FIELDS-CANCEL", "batch");			
			bp.enterBatchData(data, false);
			bp.clickCancelButton();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	@Then("Admin can see the batch details popup closes without creating any batch")
	public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch() {
		
		try {

			Map<String, String> data = ExcelReader.getData("VALID-MANDATORY-FIELDS-CANCEL", "batch");	
			String batchSuffix = data.get("batch-suffix");
			String programName= ConfigReader.getProperty("program.name");
			
			String searchKey = programName+batchSuffix;
			
			bp.searchBatch(searchKey);
			
			String uiResults = bp.getEmptyResultText();
			String expectedResult = data.get("error-message");
			
			assertEquals(uiResults, expectedResult);

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}

	@When("Admin clicks on close icon")
	public void admin_clicks_on_close_icon() {
		
		bp.clickCloseButton();		
		CommonUtils.waitForRefresh(1000);
		
	}

	@Then("batch details pop up closes")
	public void batch_details_pop_up_closes() {
		
		assertFalse(bp.isBatchPopupDisplayed());
		
		
	}

}
