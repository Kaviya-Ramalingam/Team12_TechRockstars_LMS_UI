package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.*;
import lms.PageObjects.BatchPage;
import lms.PageObjects.LoginPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.TestContextSetup;

public class SearchTextboxValidation_StepDefinition {
	TestContextSetup testcontextsetup;
	LoginPage loginpage;
	BatchPage bp;

	public SearchTextboxValidation_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		bp = testcontextsetup.pageobjectmanager.getBatchPage();
	}

@When("Admin enters the batch name in the search text box")
public void admin_enters_the_batch_name_in_the_search_text_box() {
bp.validateSearch();

}

@Then("Admin should see the filtered batches in the data table")
public void admin_should_see_the_filtered_batches_in_the_data_table() {

	String progName = bp.getProgramNameFromResults(1);
	System.out.println("Program Name: "+progName);
	
	assertEquals(progName, ConfigReader.getProperty("program.name"));

	
	//tbody[@class='p-datatable-tbody']/tr/td[6]

}

}
