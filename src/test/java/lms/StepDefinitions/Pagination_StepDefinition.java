package lms.StepDefinitions;

import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.ProgramPage;
import lms.Utilities.TestContextSetup;

public class Pagination_StepDefinition {

	TestContextSetup testcontextsetup;
	ProgramPage programPage;

	public Pagination_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		programPage = testcontextsetup.pageobjectmanager.getProgramPage();

	}

	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {
		programPage.clickNextPage();
	}

	@Then("Admin should see the Pagination has {string} active link")
	public void admin_should_see_the_pagination_has_active_link(String string) {
		Assert.assertTrue(programPage.isNextPageLinkEnabled());
	}

	@When("Admin clicks last page link on the program table")
	public void admin_clicks_last_page_link_on_the_program_table() throws InterruptedException {

		programPage.clickLastPage();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {

		Assert.assertEquals(programPage.isNextPageLinkEnabled(), false);
		List<String> lastPageRecords = programPage.getCurrentPageRecords();

		Assert.assertTrue(lastPageRecords.size() > 0, "No records displayed on the next page.");
	}

	@Given("Admin is on last page of Program table")
	public void admin_is_on_last_page_of_program_table() throws InterruptedException {
		programPage.programClick();
		admin_clicks_last_page_link_on_the_program_table();

		programPage.clickLastPage();
	}

	@When("Admin clicks Previous page link")
	public void admin_clicks_previous_page_link() throws InterruptedException {

		programPage.clickPreviousPage();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link()
			throws InterruptedException {

		Assert.assertTrue(programPage.isPreviousPageLinkEnabled());
		List<String> previousPageRecords = programPage.getCurrentPageRecords();

		Assert.assertTrue(previousPageRecords.size() > 0, "No records displayed on the next page.");
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() throws InterruptedException {

		programPage.programClick();
		programPage.clickPreviousPage();
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() throws InterruptedException {

		programPage.clickFirstPage();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled()
			throws InterruptedException {

		Assert.assertFalse(programPage.isPreviousPageLinkEnabled());
		List<String> firstPageRecords = programPage.getCurrentPageRecords();

		Assert.assertTrue(firstPageRecords.size() > 0, "No records displayed on the next page.");

	}
}
