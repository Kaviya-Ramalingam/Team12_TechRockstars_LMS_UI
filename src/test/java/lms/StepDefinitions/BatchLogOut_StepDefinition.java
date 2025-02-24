package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.*;
import lms.PageObjects.BatchPage;
import lms.PageObjects.LoginPage;
import lms.Utilities.TestContextSetup;

public class BatchLogOut_StepDefinition {

	TestContextSetup testcontextsetup;
	LoginPage loginpage;
	BatchPage bp;

	public BatchLogOut_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		bp = testcontextsetup.pageobjectmanager.getBatchPage();
	}

	@When("Admin clicks on the logout button")
	public void admin_clicks_on_the_logout_button() {

		bp.clickLogout();

	}

	@Then("Admin should see the Login Screen Page")
	public void admin_should_see_the_login_screen_page() {

		assertEquals(bp.loginButtonPresent(), true);
	}

}
