package lms.StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.ProgramPage;
import lms.Utilities.ConfigReader;
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

	String progrName;

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
		Assert.assertEquals("rgba(255, 0, 0, 1)", programPage.color(), "Asterisk color is not red");

	}

	@Given("Admin is on Program details form")
	public void admin_is_on_program_details_form() {
		
		programPage.programClick();
		programPage.clickAddNewProgram();
		LoggerLoad.info("Admin is in program details form");
	}

	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() throws InterruptedException {
		// Thread.sleep(1000);
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
		
		if (programPage.getProgramTitle().contains("Manage Program")) {
			LoggerLoad.info("program details form disappers");
		}
	}

	@When("Admin enter details for mandatory fields and Click on save button {string} and {string}.")
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
	public void admin_gets_message(String expectedMesg) throws IOException {

		if (expectedMesg.equals("Program Created Successfully")) {
			ConfigReader.setProperty("program.name", ExcelData.programName);
			ConfigReader.setProperty("program.description", ExcelData.programDescription);
			Assert.assertEquals(programPage.getSuccessMesg(), expectedMesg);
		} else if (expectedMesg.equals("programName must contain only letters and hyphens")) {
			Assert.assertEquals("Program name error message does not match!", expectedMesg,
					programPage.getFailedMesg());
		}
	}

	@When("Admin searches with newly created program name")
	public void admin_searches_with_newly_created_program_name() throws Exception {

		String progrName = ConfigReader.getProperty("program.name");
		programPage.SearchByProgramName(progrName);

	}

	@Then("Records of the newly created program name is displayed and match the data entered")
	public void records_of_the_newly_created_program_name_is_displayed_and_match_the_data_entered() {

		String actualProgName = programPage.programName();

		Assert.assertEquals(actualProgName, progrName);
	}

	@When("Admin Click on cancel button")
	public void admin_click_on_cancel_button() {

		programPage.clickCancelButton();
	}

	@Then("Admin can see program details form disappear")
	public void admin_can_see_program_details_form_disappear() {

		if (programPage.getProgramTitle().contains("Manage Program")) {
			LoggerLoad.info("confirmation form disappers");
		}
	}

	@When("Admin enters the Name in the text box")
	public void admin_enters_the_name_in_the_text_box() {

		progrName = ConfigReader.getProperty("program.name");
		programPage.progInputField(progrName);
	}

	@Then("Admin can see the text entered")
	public void admin_can_see_the_text_entered() {

		String enteredText = programPage.programNameInputField.getAttribute("value");
		String expectedText = ConfigReader.getProperty("program.name");
		Assert.assertTrue(enteredText.contains(expectedText),
				"The entered text does not match the expected program name.");
	}

	@When("Admin enters the Description in text box")
	public void admin_enters_the_description_in_text_box() {

		String progrdesc = ConfigReader.getProperty("program.description");
		programPage.progdescField(progrdesc);
	}

	@Then("Admin can see the text entered in description box")
	public void admin_can_see_the_text_entered_in_description_box() {

		String entered = programPage.programDescriptionInputField.getAttribute("value");
		String expected = ConfigReader.getProperty("program.description");
		Assert.assertTrue(entered.contains(expected), "The entered text does not match the expected program name.");
	}

	@When("Admin selects the status of the program by clicking on the radio button {string}")
	public void admin_selects_the_status_of_the_program_by_clicking_on_the_radio_button(String string) {

		programPage.clickActiveRadioBtn();
	}

	@Then("Admin can see {string} status selected")
	public void admin_can_see_status_selected(String string) {

		Assert.assertTrue(programPage.activeRadioBtnSelected(), "Active status radio button should be selected.");
	}

	@When("Admin Click on {string} button")
	public void admin_click_on_button(String string) {
		
		programPage.clickX();
	}

}
