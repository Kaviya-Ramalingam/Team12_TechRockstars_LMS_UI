package lms.StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.ProgramPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.TestContextSetup;

public class SearchBarProgram_StepDefinition {

	TestContextSetup testcontextsetup;
	ProgramPage programPage;

	public SearchBarProgram_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		programPage = testcontextsetup.pageobjectmanager.getProgramPage();

	}

	@When("Admin enter the program to search By program name")
	public void admin_enter_the_program_to_search_by_program_name() throws InterruptedException {
		programPage.SearchByProgramName(ConfigReader.getProperty("program.search"));
		
	}

	@Then("Admin should able to see Program name, description, and status for searched program name")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name() {
		Assert.assertEquals(programPage.programName(), ConfigReader.getProperty("program.search"));
		Assert.assertEquals(programPage.programDecription(), ConfigReader.getProperty("progDesc.search"));
		Assert.assertEquals(programPage.programStatus(), ConfigReader.getProperty("program.status"));
	}

	@When("Admin enter the program to search By program description")
	public void admin_enter_the_program_to_search_by_program_description() {
		
		programPage.SearchByProgramDesc(ConfigReader.getProperty("progDesc.search"));

	}

	@When("Admin enter the program to search By program name that does not exist")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist() {
		
		programPage.SearchByProgramName(ConfigReader.getProperty("program.notexist"));
	}

	@When("Admin enter the program to search By partial name of program")
	public void admin_enter_the_program_to_search_by_partial_name_of_program() {
		
		programPage.SearchByProgramName(ConfigReader.getProperty("program.partialsearch"));
	}

}
