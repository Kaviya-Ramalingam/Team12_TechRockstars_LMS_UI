package lms.StepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.ProgramPage;
import lms.Utilities.ExcelData;
import lms.Utilities.LoggerLoad;
import lms.Utilities.TestContextSetup;

public class AddNewProgram_StepDefinition {

	TestContextSetup testcontextsetup;
	ProgramPage programPage;

	public AddNewProgram_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		programPage = testcontextsetup.pageobjectmanager.getProgramPage();

	}

	@Given("Admin is on Program page")
	public void admin_is_on_program_page() {
		programPage.programClick();
		LoggerLoad.info("Admin is in program page");
	}

	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_under_the_menu_bar(String string, String string2) {
		programPage.clickAddNewProgram();
	}

	@Then("Admin should see pop up window for program details")
	public void admin_should_see_pop_up_window_for_program_details() throws InterruptedException {

		programPage.programDetailsPopup();
	}

	@Then("Admin should see window title as {string}")
	public void admin_should_see_window_title_as(String expectedTitle) throws InterruptedException {
		Assert.assertEquals(programPage.programDetailsTitle(), expectedTitle);
	}

	@Then("Admin should see red  asterisk mark  beside mandatory field {string}")
	public void admin_should_see_red_asterisk_mark_beside_mandatory_field(String string) {

		Assert.assertEquals("*", programPage.asterick(), "Asterisk symbol is not found");
		Assert.assertEquals("rgba(255, 0, 0, 1)", programPage.color(), "Asterisk color is not red"); // Adjust this if
																										// needed

	}

	@Given("Admin is on Program details form")
	public void admin_is_on_program_details_form() {
		programPage.programClick();
		programPage.clickAddNewProgram();
		LoggerLoad.info("Admin is in program details form");
	}

	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() throws InterruptedException {
		Thread.sleep(1000);
		programPage.clickSaveButton();
	}

	@Then("Admin gets error message")
	public void admin_gets_error_message(DataTable dataTable) {
		List<String> allfields = dataTable.asList(String.class);
		List<WebElement> errorMessages = programPage.getErrorMesg();

		for (int i = 0; i < allfields.size(); i++) {
			String expectedMessage = allfields.get(i);
			String actualMessage = errorMessages.get(i).getText().trim();
			Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch at index " + i);
		}
	}

	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		programPage.clickCancelButton();
	}

	@Then("Admin can see Program Details form disappears")
	public void admin_can_see_program_details_form_disappears() {

	}

	@When("Admin enter details for mandatory fields and Click on save button {string} and {string}")
	public void admin_enter_details_for_mandatory_fields_and_click_on_save_button_and(String dataKey, String SheetName)
			throws Exception {
		ExcelData.programXLdata(dataKey, SheetName);
		programPage.typeProgranDetailsInput(ExcelData.programName, ExcelData.programDescription);
		LoggerLoad.info("Program details added:" + "ProgramName: " + ExcelData.programName + "Description: "
				+ ExcelData.programDescription);
		programPage.clickActiveRadioBtn();
		programPage.clickSaveButton();

	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String expectedMesg) {

		// Assert.assertEquals(programPage.getSuccessMesg(), expectedMesg);

		if (expectedMesg.equals("Program Created Successfully")) {
			Assert.assertEquals(programPage.getSuccessMesg(), expectedMesg);
		} else if (expectedMesg.equals("programName must contain only letters and hyphens")) {
			Assert.assertEquals("Program name error message does not match!", expectedMesg,
					programPage.getFailedMesg());

		}

	}
}
	


