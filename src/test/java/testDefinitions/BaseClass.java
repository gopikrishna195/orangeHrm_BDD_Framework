package testDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.dashboardPage;
import pageObjects.loginPage;
import pageObjects.pimDashboardPage;

public class BaseClass {

	public WebDriver driver;
	public loginPage lp;
	public dashboardPage dp;
	public Logger log;
	public Properties p;
	public pimDashboardPage pd;
	
	public static String randomString() {
		String random=RandomStringUtils.randomAlphabetic(5);
		return random;
	}
	
	public static String randomNumeric() {
		String random=RandomStringUtils.randomNumeric(4);
		return random;
	}


}
