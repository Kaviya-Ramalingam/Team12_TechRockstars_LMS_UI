package lms.StepDefinitions;

import static org.testng.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import lms.PageObjects.ProgramPage;
import lms.Utilities.TestContextSetup;

public class ManageProgramValidation_StepDefinition {

	TestContextSetup testcontextsetup;
	ProgramPage programPage;

	public ManageProgramValidation_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		programPage = testcontextsetup.pageobjectmanager.getProgramPage();

	}

	@Then("Admin should able to see Program name, description, and status for each program")
	public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {

		List<WebElement> programRows = programPage.tableRow;

		for (WebElement row : programRows) {

			String programName = programPage.programNames.get(0).getText();
			String programDescription = programPage.programDescriptions.get(0).getText();
			String programStatus = programPage.programsStatus.get(0).getText();

			Assert.assertFalse(programName.isEmpty(), "Program name should not be empty");
			Assert.assertFalse(programDescription.isEmpty(), "Program description should not be empty");
			Assert.assertFalse(programStatus.isEmpty(), "Program status should not be empty");

		}
	}

	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
		Assert.assertFalse(programPage.LeftDeleteIconEnabled());
	}

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String Search) {
		Assert.assertEquals(programPage.searchbox(), Search, "no text is present");
	}

	@Then("Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit\\/Delete")
	public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete() {
		List<String> expectedHeader = Arrays.asList("", "Program Name", "Program Description", "Program Status",
				"Edit / Delete");
		List<String> actualHeaders = programPage.getProgramHeaders();
		Assert.assertEquals(actualHeaders, expectedHeader, "The program headers do not match.");
	}

	@Then("Admin should see checkbox default state as unchecked beside Program Name column header")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header() {
		Assert.assertTrue(programPage.isHeaderCheckboxUnchecked());
	}

	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
		Assert.assertTrue(programPage.areCheckboxesUnchecked());
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {

		List<String> headers = programPage.getProgramHeaders();
		List<WebElement> sortArrows = programPage.allSortIcon;
		System.out.println("Headers size: " + headers.size());
		System.out.println("Sort Arrows size: " + sortArrows.size());
		int expectedArrowCount = headers.size() - 2; // excludded checkbox and edit/delete

		Assert.assertEquals(sortArrows.size(), expectedArrowCount, "The number of sort arrows is incorrect");

	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {

		List<WebElement> rows = programPage.tableRow;
		for (WebElement row : rows) {
			Assert.assertTrue(programPage.editProgramIcon.isDisplayed(),
					"Edit button is not displayed for row: " + row.getText());
			Assert.assertTrue(programPage.deleteProgramIcon.isDisplayed(),
					"Delete button is not displayed for row: " + row.getText());
		}
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String Expected) {

		Assert.assertTrue(programPage.isFirstPageLinkVisible(),"first page button is not visible");
		Assert.assertTrue(programPage.isLastPageLinkVisible(),"last page button is not visible");
		Assert.assertTrue(programPage.isPreviousPageLinkVisible(),"previous page button is not visible");
		Assert.assertTrue(programPage.isNextPageLinkVisible(),"next page button is not visible");
				
		String actualPaginationText = programPage.getPaginationText();

		Assert.assertTrue(actualPaginationText.matches("Showing \\d+ to \\d+ of \\d+ entries"),
				"Pagination text does not match the expected format. Actual: " + actualPaginationText);

		String[] paginationParts = actualPaginationText.split(" ");
		int firstEntry = Integer.parseInt(paginationParts[1]);
		int lastEntry = Integer.parseInt(paginationParts[3]);
		int totalEntries = Integer.parseInt(paginationParts[5]);

		Assert.assertTrue(firstEntry <= lastEntry, "First entry should be less than or equal to the last entry.");
		Assert.assertTrue(lastEntry <= totalEntries, "Last entry should be less than or equal to total entries.");
	}

	@Then("Admin should see the footer as {string}")
	public void admin_should_see_the_footer_as(String footerText) {
		//Assert.assertEquals(programPage.getFooterText(), footerText);
		Assert.assertTrue(programPage.getFooterText().contains(footerText), "Footer text does not contain the expected message.");
	}
}
