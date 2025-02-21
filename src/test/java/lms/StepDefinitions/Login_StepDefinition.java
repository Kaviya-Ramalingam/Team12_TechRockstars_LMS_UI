package lms.StepDefinitions;

import org.testng.Assert;

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
	// ConfigReader configReader;

	public Login_StepDefinition(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		// String url=testcontextsetup.configReader.getBrowser();
	}

	@Given("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		ConfigReader.getBrowser();

	}

	@Given("The browser is open")
	public void the_browser_is_open() {
		LoggerLoad.info("Admin opens the browser");
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {

		Assert.assertEquals(loginpage.getLoginPageUrl(), ConfigReader.getUrl());
	}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		loginpage.getInvalidUrl();
	}

	@Then("Admin should receive application error")
	public void admin_should_receive_application_error() {
		Assert.assertEquals(loginpage.getErrorPageTitle(), " There's nothing here, yet. ");

	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer code) {
		loginpage.verifyBrokenLink(code);
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {

	}

	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
		Assert.assertEquals(loginpage.getLoginPageTitle(), "LMS - Learning Management System");

	}

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
		// Assert.assertEquals(loginpage.getCompanyName(),"NumpyNinja");

	}

	@Then("Admin should see {string}")
	public void admin_should_see(String lmsApplication) {
		Assert.assertEquals(loginpage.loginLmsApplication(), lmsApplication);

	}

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		loginpage.getTextboxDisply();
	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String user) {
		Assert.assertEquals(loginpage.getUser(), user);
	}

	@Then("Admin should see one dropdown")
	public void admin_should_see_one_dropdown() {
		loginpage.getDropdown();
	}

	@Then("Admin should see asterisk mark symbol next to text for mandatory fields")
	public void admin_should_see_asterisk_mark_symbol_next_to_text_for_mandatory_fields() {

	}
	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String loginPassword) {
		Assert.assertEquals(loginpage.getLoginPassword(), loginPassword);
	}

	@Then("Admin should see asterisk mark symbol next to password text")
	public void admin_should_see_asterisk_mark_symbol_next_to_password_text() {
	}

	@Then("Admin should see {string} placeholder in dropdown")
	public void admin_should_see_placeholder_in_dropdown(String selectRole) {
		Assert.assertEquals(loginpage.getSelectRole(),selectRole);
	}
	@Then("Admin should see {string} options in dropdown")
	public void admin_should_see_options_in_dropdown(String string) {
	    
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
	    
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	    loginpage.loginButtonDisplayed();
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
		loginpage.getUserColor();
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		loginpage.getPasswordColor();
	}



}
