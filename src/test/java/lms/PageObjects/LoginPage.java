package lms.PageObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import lms.Utilities.CommonUtils;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
	@FindBy(xpath = "//p")
	WebElement LMSApplication;
	@FindBy(xpath = "")
	WebElement companyName;
	@FindBy(xpath = "//label[@id='mat-form-field-label-1']/span[1]")
	WebElement user;
	@FindBy(xpath = "//label[@id='mat-form-field-label-1']/span[2]")
	WebElement asteriskSymbol1;
	@FindBy(xpath = "//div[@class='mat-select-arrow ng-tns-c161-11']")
	WebElement dropdownElement;
	@FindBy(xpath = "//label[@id='mat-form-field-label-3']/span[1]")
	WebElement loginPassword;
	@FindBy(xpath = "//label[@id='mat-form-field-label-3']/span[2]")
	WebElement asteriskSymbol2;
	@FindBy(xpath = "//span[text()='Select the role']")
	WebElement selectRole;
	@FindBy(xpath = "//div[@id='mat-select-value-1']/span")
	WebElement dropdown;
	// **//div[@class='mat-form-field-infix ng-tns-c158-2']//selectrole;
	@FindBy(xpath = "//span[text()=' Admin ']")
	WebElement optionAdmin;
	@FindBy(xpath = "//span[text()=' Staff ']")
	WebElement optionStaff;
	@FindBy(xpath = "//span[text()=' Student ']")
	WebElement optionStudent;
	// *****************************
	@FindBy(xpath = "//mat-error[@id='mat-error-0']")
	WebElement userErrormsg;
	@FindBy(xpath = "//mat-error[@id='mat-error-1']")
	WebElement passwordErrormsg;
	@FindBy(xpath = "//div[@class='box']")
	WebElement dashboard;


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


	public String getLoginPageTitleText() {
	
		return driver.getTitle();

	}

	public String getLoginPageTitle() {
		String title = loginPageTitle.getText();
		return title;

	}

	public String getErrorPageTitle() {
		String invalidUrl = "https://feb-ui-hon-bbfd38d67ea9.herokuapp.com/";
		driver.get(invalidUrl);
		String errorTitle = driver.getTitle();
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

	public boolean getDropdown() {
		return dropdown.isDisplayed();

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
		String userTextColor = user.getCssValue("color");
		System.out.println("UserText color is :" + userTextColor);
	}

	public void getPasswordColor() {
		String passwordTextColor = loginPassword.getCssValue("color");
		System.out.println("PasswordText color is :" + passwordTextColor);
	}

	public boolean getAsteriskSymbol1() {
		return asteriskSymbol1.isDisplayed();
	}

	public boolean getAsteriskSymbol2() {
		return asteriskSymbol2.isDisplayed();
	}

	public boolean getCorrectSpelling() {
		String givenString = "User,Password,Select the role";
		String spelling1 = user.getText();
		String spelling2 = loginPassword.getText();
		String spelling3 = selectRole.getText();
		if (givenString.contains(spelling1) && givenString.contains(spelling2) && givenString.contains(spelling3)) {
			System.out.println("spelling is correct");
			return true;

		} else
			return false;
	}

	public boolean getDropdownOption() {
		dropdown.click();
		String givenString = "Admin , Staff, Student";
		String s1 = optionAdmin.getText();
		String s2 = optionStaff.getText();
		String s3 = optionStudent.getText();
		if (givenString.contains(s1) && givenString.contains(s2) && givenString.contains(s3)) {
			System.out.println("Dropdown options present");
			return true;
		} else
			return false;
	}

	public boolean getUserErrorMsg() {

		return userErrormsg.isDisplayed();
	}

	public boolean getPasswordErrorMsg() {

		return userErrormsg.isDisplayed();
	}

	public boolean verifyDashboard() {
		return dashboard.isDisplayed();

	}

	public void loginUsingKeyboard() {
		Actions actions = new Actions(driver);
		String value1 = "sdetnumpyninja@gmail.com";
		String value2 = "Feb@2025";
		String value3 = "Admin";
		actions.sendKeys(username, value1).sendKeys(Keys.TAB).sendKeys(password, value2).sendKeys(Keys.TAB).click()
				.sendKeys(role, value3).sendKeys(Keys.TAB).click().perform();
	}


}
