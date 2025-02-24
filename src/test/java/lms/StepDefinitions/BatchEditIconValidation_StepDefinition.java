package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.Map;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.BatchPage;
import lms.PageObjects.LoginPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.ExcelReader;
import lms.Utilities.TestContextSetup;

public class BatchEditIconValidation_StepDefinition {

	TestContextSetup testcontextsetup;
	LoginPage loginpage;
	BatchPage bp;

	public BatchEditIconValidation_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		bp = testcontextsetup.pageobjectmanager.getBatchPage();
	}

	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {
		bp.clickEditIcon();
		
		
	}

	@Then("Admin should see the Batch details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		
		assertEquals(bp.getBatchPopupHeading(), true);
		
		
		
	}

	@Then("Admin should see Program name value field is disabled for editing")
	public void admin_should_see_program_name_value_field_is_disabled_for_editing() {
		//assertEquals(bp.isProgramNameDisabled(), false);
		assertFalse(bp.isProgramNameDisabled());
		
	}

	@Then("Admin should see batch name value field is disabled for editing")
	public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {
		assertFalse(bp.isBatchNameEnabled());
		
		
	}

	@When("Admin Updates any fields with invalid data and click save button")
	public void admin_updates_any_fields_with_invalid_data_and_click_save_button() {
		
		try {
			
			
			Map<String, String> data = ExcelReader.getData("VALID-EDIT", "batch");
			
			
			String progName = ConfigReader.getProperty("program.name");
			String batchSuffix = data.get("batch-suffix");
			String searchkey = progName+batchSuffix;
			
			System.out.println("Key = "+ searchkey);
			
			
			bp.searchBatch(searchkey);
			
			bp.clickEditIcon();
			
			bp.setProgramDescription("323");
			
			//bp.clickSaveButton();
			
			System.out.println("Test");
			
			

			/*
			 * String uiMessage = bp.getNumberOfClassErrorMessage(); Map<String, String>
			 * data = ExcelReader.getData("INVALID-MISSING-MANDATORY-FIELD", "batch");
			 * String expectedMessage = data.get("error-message");
			 * 
			 * assertEquals(uiMessage, expectedMessage);
			 */

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	@Then("Admin should get a error message under the respective field")
	public void admin_should_get_a_error_message_under_the_respective_field() {
		
		assertEquals(bp.getDescriptInvalidMsgDisplayed(), "This field should start with an alphabet and min 2 character.");
		
	}
	

@When("Admin enters the valid data to all the mandatory fields to edit and click save button")
public void admin_enters_the_valid_data_to_all_the_mandatory_fields_to_edit_and_click_save_button() {

	try {
		
		Map<String, String> data = ExcelReader.getData("VALID-EDIT", "batch");
		
		
		String progName = ConfigReader.getProperty("program.name");
		String batchSuffix = data.get("batch-suffix");
		String searchkey = progName+batchSuffix;
		
		System.out.println("Key = "+ searchkey);
		
		
		bp.searchBatch(searchkey);
		
		bp.clickEditIcon();
		
		String noOfClasses = data.get("no-of-classes");
		bp.setNumOfClasses(noOfClasses);
		
		bp.clickSaveButton();
		
		System.out.println("Test");
	}
	catch(Exception e) {
		
		e.printStackTrace();
	}


}


	@Then("Admin should get a succesesful message for editing the batch")
	public void admin_should_get_a_succesesful_message_for_editing_the_batch() {
		
		try {
			
			Map<String, String> data = ExcelReader.getData("VALID-EDIT", "batch");
			String toastMsg = bp.getToastMsg();
			assertEquals(toastMsg, data.get("error-message"));
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	

	@When("Admin enters the valid data to all the mandatory fields to edit and click cancel button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_to_edit_and_click_cancel_button() {
	
		try {
			
			Map<String, String> data = ExcelReader.getData("VALID-EDIT", "batch");
			
			
			String progName = ConfigReader.getProperty("program.name");
			String batchSuffix = data.get("batch-suffix");
			String searchkey = progName+batchSuffix;
			
			System.out.println("Key = "+ searchkey);
			
			
			bp.searchBatch(searchkey);
			
			bp.clickEditIcon();
			
			String noOfClasses = data.get("no-of-classes");
			bp.setNumOfClasses(noOfClasses);
			
			bp.clickCancelButton();
			
			System.out.println("Test");
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	
	}


	@Then("Admin can see the batch details popup closes without editing the batch")
	public void admin_can_see_the_batch_details_popup_closes_without_editing_the_batch() {
		
		assertEquals(bp.getLMSPageTitle(), "LMS");
		
	}

}
