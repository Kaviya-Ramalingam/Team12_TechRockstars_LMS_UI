
package lms.StepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.PageObjects.ClassPage;
import lms.PageObjects.LoginPage;
import lms.Utilities.CommonUtils;
import lms.Utilities.ConfigReader;
import lms.Utilities.TestContextSetup;

public class Sort_Class_Stepdefnition {

	TestContextSetup testcontextsetup;
	ClassPage classpage;
	LoginPage loginpage;

	public Sort_Class_Stepdefnition(TestContextSetup testcontextsetup) {

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
	
//*************************************************	Batch Name
	@When("Admin clicks on Arrow next to Batch Name")
	public void admin_clicks_on_arrow_next_to_batch_name() throws InterruptedException 
	{
		classpage.batchNameSorting();	
	}

	@Then("Admin See the Batch Name is sorted in Ascending order")
	public void admin_see_the_batch_name_is_sorted_in_ascending_order() throws InterruptedException{

		List<String> sortedList = CommonUtils.sortAscendingOrder(classpage.batchNames);
		List<String> actualList = classpage.getBatchNamesText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Batch Names are not sorted in ascending order.");
	}
	
	@Then("Admin See the Batch Name is sorted in Descending order")
	public void admin_see_the_Batch_Name_is_sorted_in_descending_order() throws InterruptedException {
		classpage.batchNameSorting();

		List<String> sortedList = CommonUtils.sortDescendingOrder(classpage.batchNames);
		List<String> actualList = classpage.getBatchNamesText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Batch Names are not sorted in descending order.");
	}
	
//****************************************** Class Topic
	@When("Admin clicks on Arrow next to Class Topic")
	public void admin_clicks_on_arrow_next_to_class_topic() throws InterruptedException
	{
		classpage.classTopicSorting();
	}
	    
	@Then("Admin See the Class Topic is sorted in Ascending order")
	public void admin_see_the_class_topic_is_sorted_in_ascending_order() throws InterruptedException {
		
		List<String> sortedList = CommonUtils.sortAscendingOrder(classpage.classTopicTableData);
		List<String> actualList = classpage.getclassTopicText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Class Topics are not sorted in ascending order.");	
	}
	
	@Then("Admin See the Class Topic is sorted in Dscending order")
	public void admin_see_the_class_topic_is_sorted_in_descending_order() throws InterruptedException {
		
		List<String> sortedList = CommonUtils.sortDescendingOrder(classpage.classTopicTableData);
		List<String> actualList = classpage.getclassTopicText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Class Topics are not sorted in descending order.");	
	}
	
	//****************************************** Class Description
	
	@When("Admin clicks on Arrow next to Class Description")
	public void admin_clicks_on_arrow_next_to_class_description() throws InterruptedException
	{
		classpage.classDescriptionSorting();
	}
	    
	@Then("Admin See the Class Topic is sorted in Ascending order")
	public void admin_see_the_class_description_is_sorted_in_ascending_order() throws InterruptedException {
		
		List<String> sortedList = CommonUtils.sortAscendingOrder(classpage.classDescriptionTableData);
		List<String> actualList = classpage.getclassDescriptionText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Class Description are not sorted in ascending order.");	
	}
	
	@Then("Admin See the Class Topic is sorted in Dscending order")
	public void admin_see_the_class_description_is_sorted_in_descending_order() throws InterruptedException {
		
		List<String> sortedList = CommonUtils.sortDescendingOrder(classpage.classDescriptionTableData);
		List<String> actualList = classpage.getclassDescriptionText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Class Description are not sorted in descending order.");	
	}
	
	//****************************************** Class Status
	

	@When("Admin clicks on Arrow next to Class Status")
	public void admin_clicks_on_arrow_next_to_class_status() throws InterruptedException
	{
		classpage.statusSorting();
	}
	    
	@Then("Admin See the Class Topic is sorted in Ascending order")
	public void admin_see_the_class_status_is_sorted_in_ascending_order() throws InterruptedException {
		
		List<String> sortedList = CommonUtils.sortAscendingOrder(classpage.statusTableData);
		List<String> actualList = classpage.getstatusTableDataText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Class Status are not sorted in ascending order.");	
	}
	
	@Then("Admin See the Class Topic is sorted in Dscending order")
	public void admin_see_the_class_status_is_sorted_in_descending_order() throws InterruptedException {
		
		List<String> sortedList = CommonUtils.sortDescendingOrder(classpage.statusTableData);
		List<String> actualList = classpage.getstatusTableDataText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Class Status are not sorted in descending order.");	
	}
	//****************************************** Class Date
	
	@When("Admin clicks on Arrow next to Class Date")
	public void admin_clicks_on_arrow_next_to_class_date() throws InterruptedException
	{
		classpage.classDateSorting();
	}
	    
	@Then("Admin See the Class Date is sorted in Ascending order")
	public void admin_see_the_class_date_is_sorted_in_ascending_order() throws InterruptedException {
		
		List<String> sortedList = CommonUtils.sortAscendingOrder(classpage.classDateTableData);
		List<String> actualList = classpage.getclassDateTableDataText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Class Date is not sorted in ascending order.");	
	}
	
	@Then("Admin See the Class Topic is sorted in Dscending order")
	public void admin_see_the_class_date_is_sorted_in_descending_order() throws InterruptedException {
		
		List<String> sortedList = CommonUtils.sortDescendingOrder(classpage.classDateTableData);
		List<String> actualList = classpage.getclassDateTableDataText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Class Status are not sorted in descending order.");	
	}
	
	//****************************************** Staff Name
	

	@When("Admin clicks on Arrow next to Class Date")
	public void admin_clicks_on_arrow_next_to_staff_name() throws InterruptedException
	{
		classpage.staffNameSorting();
	}
	    
	@Then("Admin See the Staff Name is sorted in Ascending order")
	public void admin_see_the_staff_name_is_sorted_in_ascending_order() throws InterruptedException {
		
		List<String> sortedList = CommonUtils.sortAscendingOrder(classpage.staffNameTableData);
		List<String> actualList = classpage.getstaffNameTableDataText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Staff Name is not sorted in ascending order.");	
	}
	
	@Then("Admin See the Staff Name is sorted in Dscending order")
	public void admin_see_the_staff_name_is_sorted_in_descending_order() throws InterruptedException {
		
		List<String> sortedList = CommonUtils.sortDescendingOrder(classpage.staffNameTableData);
		List<String> actualList = classpage.getstaffNameTableDataText();
		System.out.println("Sorted List: " + sortedList);
		System.out.println("Actual List: " + actualList);
		Assert.assertEquals(actualList, sortedList, "Staff Names are not sorted in descending order.");	
	}
}



	