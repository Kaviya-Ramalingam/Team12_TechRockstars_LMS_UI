package lms.StepDefinitions;

import org.openqa.selenium.Point;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.HomePage;
import lms.PageObjects.LoginPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.LoggerLoad;
import lms.Utilities.TestContextSetup;

public class HomePage_StepDefinition {
	
	TestContextSetup testcontextsetup;
	LoginPage loginpage;
	HomePage hp;

	public HomePage_StepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		hp = testcontextsetup.pageobjectmanager.getHomePage();
	}


@Given("Admin is on login Page")
public void admin_is_on_login_page() {
	
}

@When("Admin enter valid data in all field and clicks login button")
public void admin_enter_valid_data_in_all_field_and_clicks_login_button2() {
	String username = ConfigReader.getUsername();
	String password = ConfigReader.getpassword();
	String role = ConfigReader.getrole();
	loginpage.entervalidCredentials(username, password);
	loginpage.selectRole();
	loginpage.selectAdmin(role);
	loginpage.loginClick();   
}

@Then("Admin should see LMS - Learning Management System as title")
public void admin_should_see_lms_learning_Management_System_as_title() {
    System.out.println(hp.LMS_title());
    Assert.assertEquals(hp.LMS_title(), "LMS - Learning Management System");
}

@Then("LMS title should be on the top left corner of page")
public void lms_title_should_be_on_the_top_left_corner_of_page() {
	Point location= hp.titlePosition();
	System.out.println("LMS Title element is located at: (" + location.getX() + ", " + location.getY() + ")");
    Assert.assertTrue(location.getX() <= 16 && location.getY() <= 16, "LMS Title is not in the top-left corner."); 
    
}

@Then("Admin should see correct spelling in navigation bar text")
public void admin_should_see_correct_spelling_in_navigation_bar_text() {
	hp.navigationBarSpelling();      
}

@Then("Admin should see correct spelling and space in LMS title")
public void admin_should_see_correct_spelling_and_space_in_lms_title() {
	System.out.println(hp.LMS_title());
    Assert.assertEquals(hp.LMS_title(), "LMS - Learning Management System", "LMS Title spelling or spacing is incorrect.");
}

@Then("Admin should see the navigation bar text on the top right side")
public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
	Point location= hp.navBarPosition();
	System.out.println("Navigation bar element is located at: (" + location.getX() + ", " + location.getY() + ")");
    Assert.assertTrue(location.getX() <= 882 && location.getY() <= 14, "Navigation bar element is not in the top-right side."); 
}

@Then("Admin should see home in the 1st place")
public void admin_should_see_home_in_the_1st_place() {
	Assert.assertEquals(hp.getNavItemIdex("Home"),0, "Home is not in the 1st Place");
}

@Then("Admin should see program in the 2nd place")
public void admin_should_see_program_in_the_2nd_place() {
	Assert.assertEquals(hp.getNavItemIdex("Program"),1, "Program is not in the 2nd Place");  
}

@Then("Admin should see batch in the 3rd place")
public void admin_should_see_batch_in_the_3rd_place() {
	Assert.assertEquals(hp.getNavItemIdex("Batch"),2, "Batch is not in the 3rd Place");  
}

@Then("Admin should see class in the 4th place")
public void admin_should_see_class_in_the_4th_place() {
	Assert.assertEquals(hp.getNavItemIdex("Class"),3, "Class is not in the 4th Place"); 
}

@Then("Admin should see logout in the 5th place")
public void admin_should_see_logout_in_the_5th_place() {
	Assert.assertEquals(hp.getNavItemIdex("Logout"),4, "Logout is not in the 5th Place"); 
}

@Then("Admin should see pie chart")
public void admin_should_see_pie_chart() {
   Assert.assertEquals(hp.validatePieChart(), true, "Pie chart is not available");
}

@Then("Admin should see welcome message with user name and role")
public void admin_should_see_welcome_message_with_user_name_and_role() {
    Assert.assertEquals(hp.validateUserNameAndRole(), true, "User name is not valid");
}

@Then("Admin should see bar chart for Active and inactive user")
public void admin_should_see_bar_chart_for_active_and_inactive_user() {
	Assert.assertEquals(hp.validateBarChart(), true, "Bar chart is not available");
}

@Then("Admin should see user count")
public void admin_should_see_user_count() {
   Assert.assertEquals(hp.validateUserCount(), true, "User count is not available"); 
}

@Then("Admin should see staff count")
public void admin_should_see_staff_count() {
	Assert.assertEquals(hp.validateStaffCount(), true, "Staff count is not available");
}

@Then("Admin should see Program count")
public void admin_should_see_program_count() {
	Assert.assertEquals(hp.validateProgramCount(), true, "Program count is not available");
}

@Then("Admin should see batch count")
public void admin_should_see_batch_count() {
	Assert.assertEquals(hp.validateBatchCount(), true, "Batch count is not available");
}

@Then("Admin should see staff table with pagination icons")
public void admin_should_see_staff_table_with_pagination_icons() {
	Assert.assertEquals(hp.validateStaffTablePge(), true, "Staff table with pagination icon is not avaliable ");
}

@Then("Admin should see {int} staff data in a page")
public void admin_should_see_staff_data_in_a_page(Integer int1) {
	Assert.assertEquals(hp.staffData(), true, "Staff data don't have 5 records");
}


@Then("Admin should see previous page icon disabled")
public void admin_should_see_previous_page_icon_disabled() {
	Assert.assertEquals(hp.previousButtonDisabled(), true, "Previous button is enabled");
}

@Then("Admin should see first page icon disabled")
public void admin_should_see_first_page_icon_disabled() {
	Assert.assertEquals(hp.firstButtonDisabled(), true, "First button is enabled");
}


}