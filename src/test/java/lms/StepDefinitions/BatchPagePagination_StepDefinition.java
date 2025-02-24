package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.*;
import lms.PageObjects.BatchPage;
import lms.PageObjects.LoginPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.TestContextSetup;

public class BatchPagePagination_StepDefinition {

	TestContextSetup testcontextsetup;
	LoginPage loginpage;
	BatchPage bp;

	public BatchPagePagination_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		bp = testcontextsetup.pageobjectmanager.getBatchPage();
	}

	@Given("Admin is on the Batch Page")
	public void admin_is_on_the_batch_page() {

		String username = ConfigReader.getUsername();
		String password = ConfigReader.getpassword();
		String role = ConfigReader.getrole();
		loginpage.entervalidCredentials(username, password);
		loginpage.selectRole();
		loginpage.selectAdmin(role);
		loginpage.loginClick();

		bp.clickOnBatchLink();
	}

	@When("Admin clicks next page link on the data table")
	public void admin_clicks_next_page_link_on_the_data_table() {
		bp.clickNextPagination();

	}

	@Then("Admin should see the Next enabled link")
	public void admin_should_see_the_next_enabled_link() {
		assertEquals(bp.getDoubleNextPage(), true);

	}

	@When("Admin clicks last page link on the data table")
	public void admin_clicks_last_page_link_on_the_data_table() {
		bp.clickDoubleNextPagination();

	}

	@Then("Admin should see the last page link with next page link disabled on the table")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() {
		assertEquals(bp.getNextPage(), false);
	}

	@When("Admin clicks previous page link on the data table")
	public void admin_clicks_previous_page_link_on_the_data_table() {
		
		
		//pre-requisite, he should not be in 1st page. then only he can click in previous
		bp.gotoPage(2);
		
		//Now we have previous page link
		//go to previous page
		bp.clickPreviousPagination();
		
	
		
	}

	@Then("Admin should see the previous page on the table")
	public void admin_should_see_the_previous_page_on_the_table() {

		//We should be in page number 1
		int currentPageNo = bp.getCurrentPage();
		
		assertEquals(currentPageNo, 1);	
		
	}

	@When("Admin clicks first page link on the data table")
	public void admin_clicks_first_page_link_on_the_data_table() {
		
		bp.gotoPage(2); //now go back to page 1
		bp.gotoPage(1);

	}

	@Then("Admin should see the very first page on the data table")
	public void admin_should_see_the_very_first_page_on_the_data_table() {

		int currentPageNo = bp.getCurrentPage();
		
		assertEquals(currentPageNo, 1);
	}

}
