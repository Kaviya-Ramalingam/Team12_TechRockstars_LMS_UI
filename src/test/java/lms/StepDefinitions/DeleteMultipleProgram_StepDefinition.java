package lms.StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.ProgramPage;
import lms.Utilities.TestContextSetup;

public class DeleteMultipleProgram_StepDefinition {

	TestContextSetup testcontextsetup;
	ProgramPage programPage;

	public DeleteMultipleProgram_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		programPage = testcontextsetup.pageobjectmanager.getProgramPage();

	}

	@When("Admin selects more than one program by clicking on the checkbox")
	public void admin_selects_more_than_one_program_by_clicking_on_the_checkbox() {
		programPage.selectMultipleCheckboxes();
	}

	@Then("Programs get selected")
	public void programs_get_selected() {

		Assert.assertTrue(programPage.MultipleCheckBoxesSelected(), "Checkbox  was not selected!");

	}

	@When("Admin clicks on the delete button on the left top of the program page")
	public void admin_clicks_on_the_delete_button_on_the_left_top_of_the_program_page() {
		programPage.selectMultipleCheckboxes();
		programPage.clickLeftDeleteIcon();
	}

	@Then("Admin lands on Confirmation form")
	public void admin_lands_on_confirmation_form() {
		Assert.assertTrue(programPage.confirmDeletePopupDisplayed());
	}

}
