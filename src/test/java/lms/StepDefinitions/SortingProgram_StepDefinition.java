package lms.StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.ProgramPage;
import lms.Utilities.CommonUtils;
import lms.Utilities.TestContextSetup;
import java.util.List;

public class SortingProgram_StepDefinition {

	TestContextSetup testcontextsetup;
	ProgramPage programPage;

	public SortingProgram_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		programPage = testcontextsetup.pageobjectmanager.getProgramPage();

	}

	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() throws InterruptedException {

		programPage.clickSortProgramName();

	}

	@Then("Admin See the Program Name is sorted in Ascending order")
	public void admin_see_the_program_name_is_sorted_in_ascending_order() {

		List<String> sortedList = CommonUtils.sortAscendingOrder(programPage.programNames);
		List<String> actualList = programPage.getProgramNamesText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Program names are not sorted in ascending order.");
	}

	@Then("Admin See the Program Name is sorted in Descending order")
	public void admin_see_the_program_name_is_sorted_in_descending_order() throws InterruptedException {
		programPage.clickSortProgramName();

		List<String> sortedList = CommonUtils.sortDescendingOrder(programPage.programNames);
		List<String> actualList = programPage.getProgramNamesText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Program names are not sorted in descending order.");
	}

	@When("Admin clicks on Arrow next to program description")
	public void admin_clicks_on_arrow_next_to_program_description() throws InterruptedException {

		programPage.clickSortProgramDescription();

	}

	@Then("Admin See the Program description is sorted in ascending order")
	public void admin_see_the_program_description_is_sorted_in_ascending_order() {
		List<String> sortedList = CommonUtils.sortAscendingOrder(programPage.programDescriptions);
		List<String> actualList = programPage.getProgramDescriptionsText();
		Assert.assertEquals(actualList, sortedList, "Program descriptions are not sorted in ascending order.");
	}

	@Then("Admin See the Program description is sorted in Descending order")
	public void admin_see_the_program_description_is_sorted_in_descending_order() throws InterruptedException {

		programPage.clickSortProgramDescription();

		List<String> sortedList = CommonUtils.sortDescendingOrder(programPage.programDescriptions);
		List<String> actualList = programPage.getProgramDescriptionsText();
		Assert.assertEquals(actualList, sortedList, "Program descriptions are not sorted in descending order.");

	}

	@When("Admin clicks on Arrow next to program status")
	public void admin_clicks_on_arrow_next_to_program_status() throws InterruptedException {
		programPage.clickSortProgramStatus();

	}

	@Then("Admin See the Program status is sorted in Ascending order")
	public void admin_see_the_program_status_is_sorted_in_ascending_order() throws InterruptedException {

		List<String> sortedList = CommonUtils.sortAscendingOrder(programPage.programsStatus);
		List<String> actualList = programPage.getProgramsStatusText();
		Assert.assertEquals(actualList, sortedList, "Program status are not sorted in ascending order.");
	}

	@Then("Admin See the Program status is sorted in descending order")
	public void admin_see_the_program_status_is_sorted_in_descending_order() throws InterruptedException {
		programPage.clickSortProgramStatus();
		List<String> sortedList = CommonUtils.sortDescendingOrder(programPage.programsStatus);
		List<String> actualList = programPage.getProgramsStatusText();
		Assert.assertEquals(actualList, sortedList, "Program status are not sorted in descending order.");

	}

}
