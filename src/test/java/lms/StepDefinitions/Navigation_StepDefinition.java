package lms.StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.BatchPage;
//import lms.PageObjects.ClassPage;
import lms.PageObjects.ProgramPage;
import lms.Utilities.LoggerLoad;
import lms.Utilities.TestContextSetup;

public class Navigation_StepDefinition {

	TestContextSetup testcontextsetup;
	ProgramPage programPage;
	BatchPage batchpage;
	//ClassPage classpage;

	public Navigation_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		programPage = testcontextsetup.pageobjectmanager.getProgramPage();
		batchpage = testcontextsetup.pageobjectmanager.getBatchPage();
	//	classpage = testcontextsetup.pageobjectmanager.getClassPage();
	}

	@Given("Admin is on home page after Login")
	public void admin_is_on_home_page_after_login() {

		LoggerLoad.info("Admin is in home page");

	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String page) {

		if (page.equals("program")) {
			programPage.programClick();
		} else if (page.equals("batch")) {
			batchpage.clickOnBatchLink();;
		} else if (page.equals("class")) {
	//		classpage.classClick();
		} else {
			throw new IllegalArgumentException("Invalid page: " + page);
		}

	}

	@Then("Admin should be navigated to {string}")
	public void admin_should_be_navigated_to_page(String page) {

		if (page.equals("program")) {
			Assert.assertEquals(programPage.getProgramTitle(), "Manage Program");
		} else if (page.equals("batch")) {
			Assert.assertEquals(batchpage.getManageBatchHeading(), "Manage Batch");
		} else if (page.equals("class")) {
		//	Assert.assertEquals(classpage.getClassTitle(), "Manage Class");
		} else {
			throw new IllegalArgumentException("Invalid page: " + page);
		}
	}

}
