package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.*;
import lms.PageObjects.BatchPage;
import lms.PageObjects.LoginPage;
import lms.Utilities.TestContextSetup;

public class AddNewBatch_StepDefinition {

	TestContextSetup testcontextsetup;
	LoginPage loginpage;
	BatchPage bp;

	public AddNewBatch_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		bp = testcontextsetup.pageobjectmanager.getBatchPage();
	}

	@When("Admin clicks {string} on navigation bar")
	public void admin_clicks_on_navigation_bar(String string) {
		bp.clickOnBatchLink();

	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String string) {

		assertEquals(bp.addNewBatchPresent(), true);

	}

	@When("Admin clicks on Add New batch under the {string} menu bar")
	public void admin_clicks_on_add_new_batch_under_the_menu_bar(String string) {

		bp.clickOnAddNewBatchLink();
	}

	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {

		assertEquals(bp.getBatchPopupHeading(), true);

	}

}
