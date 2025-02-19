package lms.Utilities;

import lms.DriverFactory.DriverFactory;
import lms.PageObjects.PageObjectManager;

public class TestContextSetup {

	public DriverFactory driverfactory;

	public PageObjectManager pageobjectmanager;
	public CommonUtils commonutils;

	public TestContextSetup() {
		driverfactory = new DriverFactory();
		pageobjectmanager = new PageObjectManager(DriverFactory.getdriver());
		commonutils = new CommonUtils(DriverFactory.getdriver());
	}


}
