package lms.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utilities.CommonUtils;


public class LoginPage {
	

	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "login")
	WebElement login;
	@FindBy(id ="mat-select-2")
	WebElement role;
	
	
	public void entervalidCredentials(String validUserName, String ValidPassword) {
		CommonUtils.sendInput(driver,username, validUserName);
		CommonUtils.sendInput(driver, password, ValidPassword);
	}
	
	public void selectRole(String VisibleText) {
		CommonUtils.selectByVisibleText(driver, VisibleText, role);
	}

	public void loginClick() {
		CommonUtils.moveToElementAndClick(driver, login);
	}


}
