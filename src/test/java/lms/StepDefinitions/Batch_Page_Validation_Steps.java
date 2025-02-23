package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.BatchPage;
import lms.PageObjects.LoginPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.TestContextSetup;

public class Batch_Page_Validation_Steps {

	TestContextSetup testcontextsetup;
	LoginPage loginpage;
	BatchPage bp;

	public Batch_Page_Validation_Steps(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		bp = testcontextsetup.pageobjectmanager.getBatchPage();
	}

	@Given("Admin is on the Home Page")
	public void admin_is_on_the_home_page() {

		String username = ConfigReader.getUsername();
		String password = ConfigReader.getpassword();
		String role = ConfigReader.getrole();
		loginpage.entervalidCredentials(username, password);
		loginpage.selectRole();
		loginpage.selectAdmin(role);
		loginpage.loginClick();
	}

	@When("Admin Clicks on the Batch menu from header")
	public void admin_clicks_on_the_batch_menu_from_header() {

		bp.clickOnBatchLink();

	}

	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String string) {

		assertEquals(bp.getLMSPageTitle(), "LMS");
		// assertEquals("Queue", title, "Title mis-match");
	}

	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String string) {

		String heading = bp.getManageBatchHeading();
		assertEquals(heading, "Manage Batch");

	}

	@Then("Admin should see the disabled {string} under the header")
	public void admin_should_see_the_disabled_under_the_header(String string) {

		assertEquals(bp.deleteIconManage(), false);
	}

	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
		assertEquals(bp.getPaginationControl(), true);

	}

	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		assertEquals(bp.getEditIcons(), 10);

	}

	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		assertEquals(bp.getDeleteIcons(), 10);
	}

	@Then("Admin should see the checkbox in each row")
	public void admin_should_see_the_checkbox_in_each_row() {
		assertEquals(bp.getCheckBoxes(), 10);
	}

	@Then("Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit\\/Delete")
	public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {

		bp.verifyHeader();
	}

	@Then("Admin should see the checkbox  in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
		assertEquals(bp.getDataTableCheckbox(), true);
	}

	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		assertEquals(bp.getsortIconHeader(), 5);
	}

}
