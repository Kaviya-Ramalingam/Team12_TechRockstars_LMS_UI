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

	public Login_StepDefinition(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();

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

		Assert.assertEquals(loginpage.getLoginPageTitleText(), "LMS");
	}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		loginpage.getInvalidUrl();
	}

	@Then("Admin should receive application error")
	public void admin_should_receive_application_error() {
		Assert.assertEquals(loginpage.getErrorPageTitle(), "Heroku | Application Error");

	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer code) {
		loginpage.verifyBrokenLink(code);
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
		Assert.assertEquals(loginpage.getCorrectSpelling(), true);
	}

	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
		// Assert.assertEquals(loginpage.getLoginPageTitle(), "LMS - Learning Management
		// System");

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

		Assert.assertEquals(loginpage.getDropdown(), true);

	}

	@Then("Admin should see asterisk mark symbol next to text for mandatory fields")
	public void admin_should_see_asterisk_mark_symbol_next_to_text_for_mandatory_fields() {
		Assert.assertEquals(loginpage.getAsteriskSymbol1(), true);
	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String loginPassword) {
		Assert.assertEquals(loginpage.getLoginPassword(), loginPassword);
	}

	@Then("Admin should see asterisk mark symbol next to password text")
	public void admin_should_see_asterisk_mark_symbol_next_to_password_text() {
		Assert.assertEquals(loginpage.getAsteriskSymbol2(), true);

	}

	@Then("Admin should see {string} placeholder in dropdown")
	public void admin_should_see_placeholder_in_dropdown(String selectRole) {
		Assert.assertEquals(loginpage.getSelectRole(), selectRole);
	}

	@Then("Admin should see {string} options in dropdown")
	public void admin_should_see_options_in_dropdown(String string) {

		Assert.assertEquals(loginpage.getDropdownOption(), true);
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
	public void admin_should_see_password_in_gray_color() throws InterruptedException {
		loginpage.getPasswordColor();
		Thread.sleep(2000);

	}

	@When("Admin enter valid data in all field and clicks login button")
	public void admin_enter_valid_data_in_all_field_and_clicks_login_button() {
		String username = ConfigReader.getUsername();
		String password = ConfigReader.getpassword();
		String role = ConfigReader.getrole();
		loginpage.entervalidCredentials(username, password);
		// Thread.sleep(2000);
		loginpage.selectRole();
		loginpage.selectAdmin(role);
		loginpage.loginClick();
		System.out.println("**Login completed**");

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

	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() {
		Assert.assertEquals(loginpage.verifyDashboard(), true);

	}

	@When("Admin enter invalid data and clicks login button")
	public void admin_enter_invalid_data_and_clicks_login_button() {
		String username = "sdetnumpyninjaa@gmail.com";
		String password = "Feb@2027";
		String role = ConfigReader.getrole();
		loginpage.entervalidCredentials(username, password);
		loginpage.selectRole();
		loginpage.selectAdmin(role);
		loginpage.loginClick();
		System.out.println("**Error msg displayed**");
	}

	@Then("Error message {string}")
	public void error_message(String string) {

		Assert.assertTrue(false);
	}

	@When("Admin enter value only in password and clicks login button")
	public void admin_enter_value_only_in_password_and_clicks_login_button() {
		String username = "";
		String password = ConfigReader.getpassword();
		String role = ConfigReader.getrole();
		loginpage.entervalidCredentials(username, password);
		// Thread.sleep(2000);
		loginpage.selectRole();
		loginpage.selectAdmin(role);
		loginpage.loginClick();
	}

	@Then("Error message\" Please enter your user name\"")
	public void error_message_please_enter_your_user_name() {

		Assert.assertEquals(loginpage.getUserErrorMsg(), true);
	}

	@When("Admin enter value only in user name and clicks login button")
	public void admin_enter_value_only_in_user_name_and_clicks_login_button() {
		String username = ConfigReader.getUsername();
		String password = "";
		String role = ConfigReader.getrole();
		loginpage.entervalidCredentials(username, password);
		// Thread.sleep(2000);
		loginpage.selectRole();
		loginpage.selectAdmin(role);
		loginpage.loginClick();
	}

	@Then("Error message\" Please enter your password \"")
	public void error_message_please_enter_your_password() {
		Assert.assertEquals(loginpage.getPasswordErrorMsg(), true);
	}

	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
		loginpage.loginUsingKeyboard();
	}

	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
		String username = ConfigReader.getUsername();
		String password = ConfigReader.getpassword();
		String role = ConfigReader.getrole();
		loginpage.entervalidCredentials(username, password);
		// Thread.sleep(2000);
		loginpage.selectRole();
		loginpage.selectAdmin(role);
		loginpage.loginClick();

	}

}
