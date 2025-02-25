package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.regex.Pattern;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.ClassPage;
import lms.PageObjects.LoginPage;
import lms.Utilities.ConfigReader;
import lms.Utilities.TestContextSetup;

public class Class_Page_Validation_Stepdefnition {

	TestContextSetup testcontextsetup;
	LoginPage loginpage;
	ClassPage classpage;

	public Class_Page_Validation_Stepdefnition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		loginpage = testcontextsetup.pageobjectmanager.getLoginPage();
		classpage = testcontextsetup.pageobjectmanager.getClassPage();
	}

@Given("Admin is on the home page after login")
public void admin_is_on_the_home_page_after_login() {
	
	String username = ConfigReader.getUsername();
	String password = ConfigReader.getpassword();
	String role = ConfigReader.getrole();
	
	loginpage.entervalidCredentials(username, password);
	loginpage.selectRole();
	loginpage.selectAdmin(role);
	loginpage.loginClick();
}

@Given("Admin is on the Manage class page after login")
public void admin_is_on_the_manage_class_page_after_login() {
    
	assertEquals(classpage.pageTitle(), "LMS");

}

@When("Admin clicks the Class Navigation bar in the Header")
public void admin_clicks_the_class_navigation_bar_in_the_header() {
   
	classpage.classLinkInNavigationBar();

}

@Then("Admin should land on the Manage class page")
public void admin_should_land_on_the_manage_class_page() {
   
	assertEquals(classpage.pageTitle(), "LMS");

}


@Then("Admin should see the LMS-Learning Management System Title")
public void admin_should_see_the_lms_learning_management_system_title() {
	String title = classpage.titleInNavigationBar();

    assertEquals(title, "[[LMS - Learning Management System]]");
}

@Then("Admin should see the Mange Class Header")
public void admin_should_see_the_mange_class_header() {
	String header = classpage.manageClassHeader();
	assertEquals(header, "Manage Class");
}

@Then("Admin should see the Search Bar in Manage class page")
public void admin_should_see_the_search_bar_in_manage_class_page() {
     
	boolean stb = classpage.searchTextBox();
	assertTrue(stb,"search bar not displayed");
	
}

@Then("Admin should see the datatable heading like Batchname,class topic,class description,status,class Date,staff name,Edit\\/Delete")
public void admin_should_see_the_datatable_heading_like_batchname_class_topic_class_description_status_class_date_staff_name_edit_delete() {
    
	assertTrue(classpage.batchNameTableHeader());
	assertTrue(classpage.classTopicTableHeader());
	assertTrue(classpage.classDescriptionTableHeader());
	assertTrue(classpage.statusTableHeader());
	assertTrue(classpage.classDateTableHeader());	
	assertTrue(classpage.staffNameTableHeader());
	assertTrue(classpage.editOrDeleteTableHeader());
					
}

@Then("Admin should see the text as {string} and enabled pagination controls under the data table")
public void admin_should_see_the_text_as_and_enabled_pagination_controls_under_the_data_table(String string) {
    
	assertTrue(classpage.doubleLeftAngleIconPagination());
    assertTrue(classpage.leftAngleIconPagination());
    assertTrue(classpage.RightAngleIconPagination());
    assertTrue(classpage.doubleRightAngleIconPagination());
    
}

@Then("Admin should see the Sort icon of all the field in the datatable.")
public void admin_should_see_the_sort_icon_of_all_the_field_in_the_datatable() {
   
	assertTrue(classpage.batchNameSortIcon(),"batchNameSortIcon is not enabled or displayed");
	assertTrue(classpage.classTopicSortIcon(),"classTopicSortIcon is not enabled or displayed");
	assertTrue(classpage.classDescriptionSortIcon(),"classDescriptionSortIconis not enabled or displayed");
	assertTrue(classpage.classDateSortIcon(),"classDateSortIcon is not enabled or displayed");
	assertTrue(classpage.statusSortIcon(),"statusSortIcon is not enabled or displayed");
	assertTrue(classpage.staffNameSortIcon(),"staffNameSortIcon is not enabled or displayed");
		
}

/*@Then("Admin should see the Delete button under the Manage class page header.")
public void admin_should_see_the_delete_button_under_the_manage_class_page_header() {
   assertTrue(classpage.deleteBtnUnderManageClassHeader(),"delete Icon is not displayed or enabled");
}

@Then("Admin should see Total no of classes in below of the data table.")
public void admin_should_see_total_no_of_classes_in_below_of_the_data_table() {
	
}*/
}
