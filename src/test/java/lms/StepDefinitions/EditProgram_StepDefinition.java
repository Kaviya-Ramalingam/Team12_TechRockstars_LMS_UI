package lms.StepDefinitions;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.ProgramPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.ExcelData;
import lms.Utilities.ExcelReader;
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
		programPage.clickEditIcon();
	}
	
	@Then("Admin lands on Program details form")
	public void admin_lands_on_program_details_form() throws InterruptedException {
	Assert.assertEquals(programPage.programDetailsTitle(),"Program Details");
	}
	

	@When("Admin edits the program name {string} and {string} and click on save button")
	public void admin_edits_the_program_name_and_and_click_on_save_button(String dataKey, String SheetName) throws Exception {
		
          programPage.SearchByProgramName(ConfigReader.getProperty("program.name"));
          LoggerLoad.info("program:"+ConfigReader.getProperty("program.name"));
		  programPage.clickEditIcon();
		   ExcelData.programXLdata(dataKey, SheetName);
		 
		  programPage.progInputField(ExcelData.programName);
		  LoggerLoad.info("editprogram:"+ExcelData.programName);
		  programPage.clickSaveButton();
		  programPage.refresh();
		  
		  
	}
	@Then("Updated program name is seen by the Admin")
	public void updated_program_name_is_seen_by_the_admin() throws InterruptedException {
	
	 String updatedProgName =programPage.SearchByProgramName(ExcelData.programName);
	 Thread.sleep(2000);
	    
	   Assert.assertEquals(programPage.getProgramNamesText().get(0), updatedProgName);
	}
	
	@When("Admin edits the description text {string} and {string} and click on save button")
	public void admin_edits_the_description_text_and_and_click_on_save_button(String dataKey, String SheetName) throws Exception {
		 programPage.SearchByProgramDesc(ConfigReader.getProperty("program.description"));
         Thread.sleep(3000);
		  programPage.clickEditIcon();
		   ExcelData.programXLdata(dataKey, SheetName);
		
		  programPage.progdescField(ExcelData.programDescription);
		  System.out.println("editprogramDESC:"+ExcelData.programDescription);
		 
		  programPage.clickSaveButton();
	    
	}
	@Then("Admin can see the description is updated")
	public void admin_can_see_the_description_is_updated() {
	    Assert.assertTrue(programPage.progUpdateMesgDisplayed());
	}
	
	@When("Admin can change the status of the program and click on save button")
	public void admin_can_change_the_status_of_the_program_and_click_on_save_button() throws InterruptedException {
		 programPage.SearchByProgramName(ConfigReader.getProperty("program.name"));
		 Thread.sleep(3000);
		  programPage.clickEditIcon();
	   programPage.inactiveRadioBtnSelected();
	   programPage.clickSaveButton();
	}
	@Then("Status updated can be viewed by the Admin")
	public void status_updated_can_be_viewed_by_the_admin() {
		 Assert.assertTrue(programPage.progUpdateMesgDisplayed());
	}
}
