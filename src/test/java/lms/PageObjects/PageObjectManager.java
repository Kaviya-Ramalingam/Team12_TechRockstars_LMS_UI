package lms.PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public LoginPage loginPage;
	public WebDriver driver;

	public ProgramPage programPage;
	public BatchPage bp;
	public ClassPage classPage;
	public HomePage homePage;


	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public HomePage getHomePage() {
		homePage = new HomePage(driver);
		return homePage;
		
	}

	public ProgramPage getProgramPage() {
		programPage = new ProgramPage(driver);
		return programPage;
	}

	public BatchPage getBatchPage() {
		bp = new BatchPage(driver);
		return bp;
	}

	public ClassPage getClassPage() {
		classPage = new ClassPage(driver);
		return classPage;
	}

	

}
