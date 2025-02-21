package lms.PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LoginPage loginPage;
	public WebDriver driver;
	public BatchPage bp;
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}

	public LoginPage getLoginPage() {
		 loginPage = new LoginPage(driver);
		 return loginPage;
	}
	public BatchPage getBatchPage() {
		bp=new BatchPage(driver);
		return bp;
	}
	

}
