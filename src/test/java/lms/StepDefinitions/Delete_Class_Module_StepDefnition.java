package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.ClassPage;
import lms.PageObjects.LoginPage;
import lms.Utilities.TestContextSetup;
import lms.Utilities.ConfigReader;

public class Delete_Class_Module_StepDefnition {

	TestContextSetup testcontextsetup;
	LoginPage loginpage;
	ClassPage cp;

	public Delete_Class_Module_StepDefnition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		cp = testcontextsetup.pageobjectmanager.getClassPage();
	}

	
	@Given("Admin is on the  Manage Class Page")
	public void admin_is_on_the_manage_class_page() {

	String username = ConfigReader.getUsername();
	String password = ConfigReader.getpassword();
	String role = ConfigReader.getrole();
	loginpage.entervalidCredentials(username, password);
	loginpage.selectRole();
	loginpage.selectAdmin(role);
	loginpage.loginClick();

	cp.clickOnClassLink();
}

	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
	cp.clickDeleteIcon();
}

	@Then("Admin should see a alert open with heading Confirm along with YES and NO button for deletion")
	public void admin_should_see_a_alert_open_with_heading_confirm_along_with_yes_and_no_button_for_deletion() {
	assertEquals(cp.getDeleteConfirmMsg(), "Confirm");
	assertEquals(cp.getDeleteYesMsg(), "Yes");
	assertEquals(cp.getDeleteNoMsg(), "No");
}

	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {
		cp.clickDeleteIcon();
	}
	
	@When("Admin clicks No option")
	public void admin_clicks_no_option() {
		cp.clickDeleteNoBtn();
	}

	@Then("Admin can see the deletion alert closed without deleting")
	public void admin_can_see_the_deletion_alert_closed_without_deleting() {
		String batchName = ConfigReader.getProperty("batch.name");
		String batchNameFromResult = cp.getbatchNameFromResults(1);
		assertEquals(batchNameFromResult, batchName);
	}
	
	@When("Admin clicks yes option")
	public void admin_clicks_yes_option() {
		String className = "Inheritance-JavaOOPS";
		cp.setBName(className);
		cp.clickDeleteIcon(className);
		cp.clickDeleteYesBtn();
	}
	
	@Then("Admin gets a message Successful Class Deleted alert and do not see that Class in the data table")
	public void admin_gets_a_message_successful_class_deleted_alert_and_do_not_see_that_class_in_the_data_table() {
		assertEquals(cp.getToastMsg(), "Successful");
	}
	
	@When("Admin clicks on close button")
	public void admin_clicks_on_close_button() {
		cp.clickDeleteIcon();
		cp.clickCloseButton();
	}

	@Given("Admin is in Manage Class page")
	public void admin_is_in_manage_class_page() {
		assertEquals(cp.getManageClassHeading(), "Manage Class");
	}
	
	
}
