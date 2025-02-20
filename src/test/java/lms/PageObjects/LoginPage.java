package lms.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lms.Utilities.CommonUtils;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "login")
	WebElement login;
	@FindBy(xpath = "//div[@id='mat-select-value-1']/span")
	WebElement role;
	@FindBy(xpath = "//mat-option[1]/span[@class='mat-option-text']")
	WebElement admin;

	public void entervalidCredentials(String validUserName, String ValidPassword) {
		CommonUtils.sendInput(driver, username, validUserName);
		CommonUtils.sendInput(driver, password, ValidPassword);
	}

	public void selectRole() {
		CommonUtils.moveToElementAndClick(driver, role);

	}

	public void loginClick() {
		CommonUtils.moveToElementAndClick(driver, login);

	}

	public void selectAdmin(String VisibleText) {
		CommonUtils.moveToElementAndClick(driver, admin);

	}

}
