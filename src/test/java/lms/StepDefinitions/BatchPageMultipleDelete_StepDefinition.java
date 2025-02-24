package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.*;
import lms.PageObjects.BatchPage;
import lms.PageObjects.LoginPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.TestContextSetup;

public class BatchPageMultipleDelete_StepDefinition {

	TestContextSetup testcontextsetup;
	LoginPage loginpage;
	BatchPage bp;

	public BatchPageMultipleDelete_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		bp = testcontextsetup.pageobjectmanager.getBatchPage();
	}

	@When("Admin clicks on the delete icon under the Manage batch header for single row")
	public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header_for_single_row() {
		
		bp.selectCheckboxe(0);
		bp.clickDelete();
		bp.clickDeleteYesBtn();
	}

	@Then("The respective row in the table should be deleted")
	public void the_respective_row_in_the_table_should_be_deleted() {
		assertEquals(bp.getToastMsg(), "Successful");
	}

	@When("Admin clicks on the delete icon under the Manage batch header for multiple row")
	public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header_for_multiple_row() {
		bp.clickCheckboxes();
		bp.clickDelete();
		bp.clickDeleteYesBtn();
	}



}
