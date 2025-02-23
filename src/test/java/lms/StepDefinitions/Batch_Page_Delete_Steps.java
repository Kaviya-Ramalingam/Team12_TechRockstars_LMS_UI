package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.*;
import lms.PageObjects.BatchPage;
import lms.PageObjects.LoginPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.TestContextSetup;

public class Batch_Page_Delete_Steps {

	TestContextSetup testcontextsetup;
	LoginPage loginpage;
	BatchPage bp;

	public Batch_Page_Delete_Steps(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		bp = testcontextsetup.pageobjectmanager.getBatchPage();
	}

	@Given("Admin is on the Batch Page for Delete")
	public void admin_is_on_the_batch_page_for_delete() {

		String username = ConfigReader.getUsername();
		String password = ConfigReader.getpassword();
		String role = ConfigReader.getrole();
		loginpage.entervalidCredentials(username, password);
		loginpage.selectRole();
		loginpage.selectAdmin(role);
		loginpage.loginClick();

		bp.clickOnBatchLink();
	}

	@When("Admin clicks the delete Icon on any row")
	public void admin_clicks_the_delete_icon_on_any_row() {

		bp.clickDeleteIcon();

	}

	@Then("Admin should see the confirm alert box with yes and no button")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button() {
		assertEquals(bp.getDeleteConfirmMsg(), "Confirm");
		assertEquals(bp.getDeleteYesMsg(), "Yes");
		assertEquals(bp.getDeleteNoMsg(), "No");

	}

	@When("Admin clicks on the delete icon and click yes buttton")
	public void admin_clicks_on_the_delete_icon_and_click_yes_buttton() {
		bp.clickDeleteYesBtn();

	}

	@Then("Admin should see the successfull message and the batch should be deleted")
	public void admin_should_see_the_successfull_message_and_the_batch_should_be_deleted() {

	}

	@When("Admin clicks on the delete icon and click no buttton")
	public void admin_clicks_on_the_delete_icon_and_click_no_buttton() {

	}

	@Then("Admin should see the alert box closed and the batch is not deleted")
	public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted() {

	}

	@When("Admin clicks on the close icon")
	public void admin_clicks_on_the_close_icon() {

	}

	@Then("Admin should see the alert box closed")
	public void admin_should_see_the_alert_box_closed() {

	}

}
