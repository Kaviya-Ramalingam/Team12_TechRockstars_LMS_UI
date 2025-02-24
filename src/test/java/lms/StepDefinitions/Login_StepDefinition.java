package lms.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.LoginPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.LoggerLoad;
import lms.Utilities.TestContextSetup;

public class Login_StepDefinition {

	TestContextSetup testcontextsetup;
	LoginPage loginpage;

	public Login_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();

	}

	@Given("The browser is open")
	public void the_browser_is_open() {
		LoggerLoad.info("Admin opens the browser");
	}

	@When("Admin gives the correct lms portal url")
	public void admin_gives_the_correct_lms_portal_url() throws InterruptedException {
		String username = ConfigReader.getUsername();
		String password = ConfigReader.getpassword();
		String role = ConfigReader.getrole();
		loginpage.entervalidCredentials(username, password);
		loginpage.selectRole();
		loginpage.selectAdmin(role);
		loginpage.loginClick();
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {

	}

}
