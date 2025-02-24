package lms.StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.ProgramPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.ExcelData;
import lms.Utilities.LoggerLoad;
import lms.Utilities.TestContextSetup;

public class EditProgram_StepDefinition {
	TestContextSetup testcontextsetup;
	ProgramPage programPage;

	public EditProgram_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		programPage = testcontextsetup.pageobjectmanager.getProgramPage();

	}

	@When("Admin clicks on edit icon for particular program")
	public void admin_clicks_on_edit_icon_for_particular_program() throws InterruptedException {

		programPage.SearchByProgramName(ConfigReader.getProperty("program.name"));
		programPage.programName();
		programPage.clickEditIcon();
	}

	@Then("Admin lands on Program details form")
	public void admin_lands_on_program_details_form() throws InterruptedException {

		Assert.assertEquals(programPage.programDetailsTitle(), "Program Details");
	}

	@When("Admin edits the program name {string} and {string} and click on save button")
	public void admin_edits_the_program_name_and_and_click_on_save_button(String dataKey, String SheetName)
			throws Exception {

		programPage.SearchByProgramName(ConfigReader.getProperty("program.name"));
		LoggerLoad.info("program:" + ConfigReader.getProperty("program.name"));

		programPage.programName();
		programPage.clickEditIcon();

		ExcelData.programXLdata(dataKey, SheetName);

		programPage.progInputField(ExcelData.programName);
		LoggerLoad.info("editprogram:" + ExcelData.programName);
		programPage.clickSaveButton();

	}

	@Then("Updated program name is seen by the Admin")
	public void updated_program_name_is_seen_by_the_admin() throws InterruptedException {

		String updatedProgName = programPage.SearchByProgramName(ExcelData.programName);
		String actualProgName = programPage.programName();

		Assert.assertEquals(actualProgName, updatedProgName);
	}

	@When("Admin edits the description text {string} and {string} and click on save button")
	public void admin_edits_the_description_text_and_and_click_on_save_button(String dataKey, String SheetName)
			throws Exception {

		programPage.SearchByProgramDesc(ConfigReader.getProperty("program.description"));
		LoggerLoad.info("program:" + ConfigReader.getProperty("program.description"));

		programPage.programDecription();
		programPage.clickEditIcon();
		ExcelData.programXLdata(dataKey, SheetName);

		programPage.progdescField(ExcelData.programDescription);
		LoggerLoad.info("editprogramDESC:" + ExcelData.programDescription);

		programPage.clickSaveButton();

	}

	@Then("Admin can see the description is updated")
	public void admin_can_see_the_description_is_updated() {

		Assert.assertTrue(programPage.progUpdateMesgDisplayed());
	}

	@When("Admin can change the status of the program and click on save button")
	public void admin_can_change_the_status_of_the_program_and_click_on_save_button() throws InterruptedException {

		programPage.SearchByProgramName(ConfigReader.getProperty("program.name"));
		programPage.programName();
		programPage.clickEditIcon();
		programPage.inactiveRadioBtnSelected();
		programPage.clickSaveButton();
	}

	@Then("Status updated can be viewed by the Admin")
	public void status_updated_can_be_viewed_by_the_admin() throws IOException {

		if (programPage.progUpdateMesgDisplayed()) {
			ConfigReader.setProperty("program.updatedname", ExcelData.programName);
			ConfigReader.setProperty("program.updateddescription", ExcelData.programDescription);

			Assert.assertTrue(programPage.progUpdateMesgDisplayed());
		}
	}

	@When("Admin searches with newly updated {string}")
	public void admin_searches_with_newly_updated(String string) {

		programPage.SearchByProgramName(ConfigReader.getProperty("program.updatedname"));

	}

	@Then("Admin verifies that the details are correctly updated.")
	public void admin_verifies_that_the_details_are_correctly_updated() {

		String updatedProgName = programPage.SearchByProgramName(ConfigReader.getProperty("program.updatedname"));
		String updatedProgDesc = programPage.SearchByProgramDesc(ConfigReader.getProperty("program.description"));
		String actualProgName = programPage.programName();
		String actualProgDesc = programPage.programDecription();

		Assert.assertEquals(actualProgName, updatedProgName);
		Assert.assertEquals(false, updatedProgDesc);
	}
}
