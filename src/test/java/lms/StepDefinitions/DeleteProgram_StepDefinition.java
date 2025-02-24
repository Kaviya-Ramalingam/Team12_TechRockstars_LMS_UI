package lms.StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.ProgramPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.LoggerLoad;
import lms.Utilities.TestContextSetup;

public class DeleteProgram_StepDefinition {
	TestContextSetup testcontextsetup;
	ProgramPage programPage;

	public DeleteProgram_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		programPage = testcontextsetup.pageobjectmanager.getProgramPage();

	}

	@Given("Admin is on Program Confirm Deletion Page after selecting a program to delete")
	public void admin_is_on_program_confirm_deletion_page_after_selecting_a_program_to_delete() {
		programPage.programClick();
		programPage.SearchByProgramName(ConfigReader.getProperty("program.name"));
		programPage.clickDeleteIcon();
	}

	@When("Admin clicks on yes button")
	public void admin_clicks_on_yes_button() {
		programPage.clickYesBtn();

	}

	@Then("Admin can see {string} message")
	public void admin_can_see_message(String string) {
		Assert.assertTrue(programPage.progDeleteMesgDisplayed());
	}

	@When("Admin Searches for {string}")
	public void admin_searches_for(String string) {
		programPage.SearchByProgramName(ConfigReader.getProperty("program.name"));
	}

	@Then("There should be zero results.")
	public void there_should_be_zero_results() throws InterruptedException {
		Thread.sleep(2000);

		String progEntries = programPage.validateNoOfEntries();
		progEntries = progEntries.replaceAll("[^0-9]+", " ").trim();
		String[] element = progEntries.split(" ");

		for (String ele : element) {
			System.out.println("Element: " + ele);
		}
		int start = Integer.parseInt(element[0]); // Start of the range (0)
		int end = Integer.parseInt(element[1]); // End of the range (0)
		int total = Integer.parseInt(element[2]); // Total entries (0)

		Assert.assertTrue(start == 0 && end == 0 && total == 0);

	}

	@When("Admin clicks on No button")
	public void admin_clicks_on_No_button() {

		programPage.clickNoBtn();
	}

	@When("Admin clicks on delete button for a program")
	public void admin_clicks_on_delete_button_for_a_program() {
		programPage.SearchByProgramName(ConfigReader.getProperty("program.name"));
		programPage.clickDeleteIcon();
	}

	@Then("Admin will get confirm deletion popup")
	public void admin_will_get_confirm_deletion_popup() {
		Assert.assertTrue(programPage.confirmDeletePopupDisplayed());
	}

	@When("Admin Click on X button")
	public void admin_click_on_x_button() {
		programPage.clickDeletePopupX();
	}

	@Then("Admin can see Confirmation form disappears")
	public void admin_can_see_confirmation_form_disappears() throws InterruptedException {

		if (programPage.getProgramTitle().contains("Manage Program")) {
			LoggerLoad.info("confirmation form disappers");
		}
	}

}
