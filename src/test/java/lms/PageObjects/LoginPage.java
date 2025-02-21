package lms.PageObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import lms.Utilities.CommonUtils;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//button[@id='login']")
	WebElement login;
	@FindBy(xpath = "//div[@id='mat-select-value-1']/span")
	WebElement role;
	@FindBy(xpath = "//mat-option[1]/span[@class='mat-option-text']")
	WebElement admin;
	@FindBy(xpath = "//img[@class='images']")
	WebElement loginPageTitle;
	@FindBy(xpath = "//div[@class='message__title']")
	WebElement errorPageTitle;
	@FindBy(xpath = "//p[normalize-space()='Please login to LMS application']")
	WebElement LMSApplication;
	@FindBy(xpath = "")
	WebElement companyName;
	@FindBy(xpath = "")
	WebElement user;
	@FindBy(xpath = "//div[@class='mat-select-arrow ng-tns-c161-11']")
	WebElement dropdownElement;
	@FindBy(xpath = "")
	WebElement loginPassword;
	@FindBy(xpath = "//span[text()='Select the role']")
	WebElement selectRole;

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

//****************
	public String getLoginPageUrl() {

		return driver.getCurrentUrl();

	}

	public String getLoginPageTitle() {
		String title = loginPageTitle.getText();
		return title;

	}

	public String getErrorPageTitle() {
		String errorTitle = errorPageTitle.getText();
		return errorTitle;

	}

	public void verifyBrokenLink(int statusCode) {
		try {

			@SuppressWarnings("deprecation")
			String url = "https://ms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/program";
			URL link = new URL(url);
			HttpURLConnection httpURLConnect = (HttpURLConnection) link.openConnection();
			httpURLConnect.setConnectTimeout(1000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= statusCode) {
				System.out.println(url + " - " + httpURLConnect.getResponseMessage() + " is a broken link");
			} else {
				System.out.println(url + " - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getInvalidUrl() {
		String invalidUrl = "https://feb-ui-hon-bbfd38d67ea9.herokuapp.com/";
		driver.get(invalidUrl);

	}

	public String getCompanyName() {
		return companyName.getText();
	}

	public String loginLmsApplication() {
		return LMSApplication.getText();
	}

	public String getUser() {
		return user.getText();
	}

	public void getDropdown() {
		Select dropdown = new Select(dropdownElement);
		List<WebElement> dropdowns = dropdown.getOptions();
		if (dropdowns.size() > 0) {
			System.out.println("Dropdown has options");
		} else {
			System.out.println("Dropdown has no options");
		}
	}

	public void getTextboxDisply() {

		if (username.isDisplayed() && password.isDisplayed()) {
			System.out.println("Two text field present");
		} else {
			System.out.println("Text field not present");
		}
	}
	public String getLoginPassword() {
		return loginPassword.getText();
	}
	
	public String getSelectRole() {
		return selectRole.getText();
	}	
	public void loginButtonDisplayed() {
		if (login.isDisplayed()) {
			System.out.println("Login button is displayed");
		}
	}
	public void getUserColor() {
		String userTextColor=user.getCssValue("color");
		System.out.println("UserText color is :" + userTextColor);
	}
	public void getPasswordColor() {
		String passwordTextColor=loginPassword.getCssValue("color");
		System.out.println("PasswordText color is :" + passwordTextColor);
	}
}
