package lms.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import lms.Utilities.CommonUtils;
import lms.Utilities.ConfigReader;


public class HomePage {
	

	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
	WebElement titleOfLMS;
	
	@FindBy(xpath = "//div[normalize-space()='Manage Batch']")
	WebElement manageBatchHeading;
	
	@FindBy(xpath = "//div[@class = 'ng-star-inserted']")
	WebElement navigation_buttons;
	
	@FindBy(xpath = "//canvas['_ngcontent-isf-c205']")
	WebElement pieChart;

	@FindBy(xpath = "//canvas['_ngcontent-isf-c206']")
	WebElement barChart;
	
	@FindBy(xpath = "//div[@class = 'widget green']/div[2]/div[1]")
	WebElement userCount;
	
	@FindBy(xpath = "//div[@class = 'widget yellow']/div[2]/div[1]")
	WebElement staffCount;
	
	@FindBy(xpath = "//div[@class = 'widget red']/div[2]/div[1]")
	WebElement programCount;
	
	@FindBy(xpath = "//div[@class = 'widget blue']/div[2]/div[1]")
	WebElement batchCount;
	
	@FindBy(xpath = "//strong['_ngcontent-isf-c146']")
	WebElement userName;
	
	@FindBy(xpath = "//div['_ngcontent-isf-c146'][@class='bottom']")
	WebElement userRole;
	
	@FindBy(xpath = "//button[@class='mat-focus-indicator mat-tooltip-trigger mat-paginator-navigation-previous mat-icon-button mat-button-base mat-button-disabled']")
	WebElement previousBtn;
	
	@FindBy(xpath = "//button[@class='mat-focus-indicator mat-tooltip-trigger mat-paginator-navigation-first mat-icon-button mat-button-base mat-button-disabled ng-star-inserted']")
	WebElement firstBtn;
	
	@FindBy(xpath = "//mat-table[@class='mat-table cdk-table table-container mat-elevation-z8']")
	WebElement staffDataTable;
	
	@FindBy(xpath = "//div['_ngcontent-isf-c206']")
	WebElement staffTablePeg;
	
	
	public String LMS_title() {
		String pageTitle= titleOfLMS.getText();		
		return pageTitle;
	}
	
	public Point titlePosition() {
	Point location = titleOfLMS.getLocation();
	return location;

	}
	
	public void navigationBarSpelling() {
		List<WebElement> navElements = navigation_buttons.findElements(By.tagName("button"));
		
        String[] expectedNavText = {"Home", "Program", "Batch", "Class", "Logout"}; 

         if(navElements.size() != expectedNavText.length)
         {
            Assert.fail("Number of LMS navigation items does not match");
         }

        for (int i = 0; i < navElements.size(); i++) 
        {
            String actualText = navElements.get(i).getText().trim(); 
            
            String expectedText = expectedNavText[i];

            Assert.assertEquals(actualText, expectedText, "Navigation item '" + actualText + "' has incorrect spelling.");
            System.out.println("Navigation item '" + actualText + "' is spelled correctly.");
        }
    }
	
	public Point navBarPosition() {
		Point location = navigation_buttons.getLocation();
		return location;

		}
	
	public int getNavItemIdex(String navItemName) {
		
		List<WebElement> navElements = navigation_buttons.findElements(By.tagName("button"));
		
		for (int i = 0; i < navElements.size(); i++) 
        {
            String itemText = navElements.get(i).getText().trim(); 
            
                     
            if(itemText.equals(navItemName))
            {
            	return i;
            }
        }
		return -1;
	}
	
	public boolean validatePieChart()
	{
		if(pieChart != null)
		{
			System.out.println("Pie chart is  available ");
			return true;
		}
		return false;
	}
	
	public boolean validateUserNameAndRole()
	{
		String userNameValue= userName.getText();		
		String userRoleValue = userRole.getText();
		
	    if(userNameValue.equals("Welcome " + ConfigReader.getUsername()) && userRoleValue.toLowerCase().equals(ConfigReader.getrole().toLowerCase()))
	    {
	    	System.out.println("User Name = " +userNameValue + " role: " + userRoleValue);
			return true;
		}
		return false;	    		
	}
	
	
	public boolean validateBarChart()
	{
		if(barChart != null)
		{
			System.out.println("Bar chart is  available ");
			return true;
		}
		return false;
	}
	
	public boolean validateUserCount()
	{
		int userCountNumber = Integer.parseInt(userCount.getText());
		if(userCountNumber >=0)
		{
			System.out.println("User Count is: " + userCountNumber);
			return true;
		}
		return false;
	}
	
	public boolean validateStaffCount()
	{
		int staffCountNumber = Integer.parseInt(staffCount.getText());
		if(staffCountNumber >=0)
		{
			System.out.println("Staff Count is: " + staffCountNumber);
			return true;
		}
		return false;
	}
	
	public boolean validateProgramCount()
	{
		int programCountNumber = Integer.parseInt(programCount.getText());
		if(programCountNumber >=0)
		{
			System.out.println("Program Count is: " + programCountNumber);
			return true;
		}
		return false;
	}
	
	public boolean validateBatchCount()
	{
		int batchCountNumber = Integer.parseInt(batchCount.getText());
		if(batchCountNumber >=0)
		{
			System.out.println("Batch Count is: " + batchCountNumber);
			return true;
		}
		return false;
	}
	
	public boolean validateStaffTablePge (){
		if(staffTablePeg != null)
		{
			System.out.println(" Staff Table with Pagination is  available ");
			return true;
		}
		return false;
		
	}
	
	public boolean staffData()
	{
		
		List<WebElement> rows = staffDataTable.findElements(By.tagName("mat-row"));
		System.out.println("Total rows " +rows.size());
		if (rows.size() == 5)
		{
			return true;
		}
		return false;
	}
	
	
	public boolean previousButtonDisabled()
	{		
        if (!previousBtn.isEnabled()) {
            return true;
        }
		return false;
	}
	
	public boolean firstButtonDisabled()
	{		
        if (!firstBtn.isEnabled()) {
            return true;
        }
		return false;
	}

}
