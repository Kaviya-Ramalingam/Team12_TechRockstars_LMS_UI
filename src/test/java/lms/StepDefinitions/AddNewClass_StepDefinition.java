
	
	
	package lms.StepDefinitions;

	import org.testng.Assert;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import lms.PageObjects.ClassPage;
	import lms.PageObjects.LoginPage;
	import lms.Utilities.ConfigReader;
	import lms.Utilities.TestContextSetup;

	public class AddNewClass_StepDefinition {
		TestContextSetup testcontextsetup;
		LoginPage loginpage;
		ClassPage  classPage;
		
		public AddNewClass_StepDefinition(TestContextSetup testcontextsetup) {
			this.testcontextsetup = testcontextsetup;
			loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
			classPage = testcontextsetup.pageobjectmanager.getClassPage();
		}
		@Given("Admin is on the Manage Class page")
		public void admin_is_on_the_manage_class_page() {
			String username = ConfigReader.getUsername();
			String password = ConfigReader.getpassword();
			String role = ConfigReader.getrole();
			loginpage.entervalidCredentials(username, password);
			loginpage.selectRole();
			loginpage.selectAdmin(role);
			loginpage.loginClick();
			classPage.getClassTab();
			
		}

		@When("Admin clicks a add new class under the class menu bar.")
		public void admin_clicks_a_add_new_class_under_the_class_menu_bar() {
			classPage.clickaddNewClass();
			System.out.println("****New class added");
		}

		@Then("Admin see Class Details popup window with SAVE and CANCEL button and Close\\(X) Icon on the top right corner of the window")
		public void admin_see_class_details_popup_window_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
			Assert.assertEquals(classPage.getPopUpDetails(), true);
		}

		@Then("Admin should see few input fields and their respective text boxes in the class details window")
		public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() {
			Assert.assertEquals(classPage.getPopUpInputFields(), true);
			
		}

	}


