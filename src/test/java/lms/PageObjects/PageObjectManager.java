package lms.PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LoginPage loginPage;
	public WebDriver driver;
	public LogoutPage logoutPage;
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}

	public LoginPage getLoginPage() {
		 loginPage = new LoginPage(driver);
		 return loginPage;
	}
	public LogoutPage getLogoutPage() {
		logoutPage = new LogoutPage(driver);
		 return logoutPage;
	}

}
