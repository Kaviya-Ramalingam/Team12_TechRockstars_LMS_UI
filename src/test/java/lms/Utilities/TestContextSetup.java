package lms.Utilities;

import java.io.IOException;

import lms.DriverFactory.DriverFactory;
import lms.PageObjects.PageObjectManager;

public class TestContextSetup {

	public DriverFactory driverfactory;

	public PageObjectManager pageobjectmanager;
	//public CommonUtils commonutils;
	//public ConfigReader configReader;
	public TestContextSetup() {
		driverfactory = new DriverFactory();
		pageobjectmanager = new PageObjectManager(DriverFactory.getdriver());
		//commonutils = new CommonUtils(DriverFactory.getdriver());
		//configReader=new ConfigReader();
	}


}
