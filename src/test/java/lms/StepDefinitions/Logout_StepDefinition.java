package lms.StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.LoginPage;
import lms.PageObjects.LogoutPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.TestContextSetup;

public class Logout_StepDefinition {
	TestContextSetup testcontextsetup;
	LoginPage loginpage;
	LogoutPage logoutPage;

	public Logout_StepDefinition(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		logoutPage = testcontextsetup.pageobjectmanager.getLogoutPage();
	}

	@Given("Admin is logged into the application")
	public void admin_is_logged_into_the_application() {
		ConfigReader.getBrowser();
	}

	@Given("Admin is in home page")
	public void admin_is_in_home_page() {
		// Assert.assertEquals(loginpage.verifyDashboard(), " Dashboard");
		String username = ConfigReader.getUsername();
		String password = ConfigReader.getpassword();
		String role = ConfigReader.getrole();
		loginpage.entervalidCredentials(username, password);
		// Thread.sleep(2000);
		loginpage.selectRole();
		loginpage.selectAdmin(role);
		loginpage.loginClick();

	}

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
		logoutPage.clickLogout();

	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
		Assert.assertEquals(loginpage.getLoginPageTitleText(), "LMS");
	}

	@Given("Admin is in login page")
	public void admin_is_in_login_page() {
		ConfigReader.getBrowser();
	}

	@When("Admin clicks  browser back button")
	public void admin_clicks_browser_back_button() {
		logoutPage.getBackButton();

	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
		Assert.assertTrue(false);
	}

}
