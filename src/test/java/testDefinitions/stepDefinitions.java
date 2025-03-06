package testDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.dashboardPage;
import pageObjects.loginPage;
import pageObjects.pimDashboardPage;

public class stepDefinitions extends BaseClass {
	@BeforeStep
	public void beforestep() {
		System.out.println("beforestep");
	}
	@AfterStep
	public void afterStep() {
		System.out.println("afterStep");
	}
	

	@Before("@sanity")
	public void setup() throws IOException {
		System.out.println("this is setup method execution");
		FileInputStream file = new FileInputStream(".//src/test/resources//config.properties");
		p = new Properties();
		p.load(file);
		String br = p.getProperty("browser");
		switch (br.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("invalid browser");
			return;

		}
		log = LogManager.getLogger(stepDefinitions.class);

		log.trace("****launching the setup*******");
	}
	
	@Before("@regression")
	public void setup1() throws IOException {
		System.out.println("this is setup1 method execution");
		FileInputStream file = new FileInputStream(".//src/test/resources//config.properties");
		p = new Properties();
		p.load(file);
		String br = p.getProperty("browser");
		switch (br.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("invalid browser");
			return;

		}
		log = LogManager.getLogger(stepDefinitions.class);

		log.trace("****launching the setup*******");
	}

	@Given("user open the browser")
	public void user_open_the_browser() {
		log.info("browser is opened");
		lp = new loginPage(driver);
		dp = new dashboardPage(driver);
		pd= new pimDashboardPage(driver);
	}

	@When("user enter url as {string}")
	public void user_enter_url_as(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		log.info("user enter the url");
	}

	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String string, String string2) {
		lp.setEmail(string);
		lp.setPass(string2);
		log.info("user enter the mail and password");
	}

	@When("user click on login")
	public void user_click_on_login() {
		lp.clickLogin();
		log.info("user click on login");
	}

	@Then("user able to see dashboard")
	public void user_able_to_dashboard() {
		boolean value = dp.dashboard();
		if (value == true) {
			Assert.assertEquals(value, true);
			log.warn("Test passed:user can able to see dashboard");
		} else {
			Assert.assertTrue(false);
			log.warn("Test failed:user cannot see dashboard");
		}
	}

	@When("close the browser")
	public void close_the_browser() {
		
	}
	@After
	public void tearDown(Scenario sc) {
		if(sc.isFailed()==true) {
		File file=new File(".//screenshots//error_screenshots.png");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		sourcefile.renameTo(file);
		driver.quit();
		log.info("close the browser");
		}
		
	}
///	///***adding employee****///////////////////////////////////////////////////////////////////////
	@When("user click on PIM")
	public void user_click_on_pim() {
		log.info("user click on pimbutton");
	    dp.clickPimbutton();
	}

	@Then("he can see PIM dashboard")
	public void he_can_see_pim_dashboard() {
	   boolean value= pd.pimDashboard();
	   if(value==true) {
		   log.warn("pim dashboard is visible");
		   Assert.assertEquals(value, true);
	   }
	   else {
		   log.warn("pim dashboard is not visible");
		   Assert.assertTrue(false);
	   }
	   
	}

	@When("user click on add")
	public void user_click_on_add() {
		log.info("click on add button");
	   pd.clickAddButton();
	}

	@When("user fill the values")
	public void user_fill_the_values() throws InterruptedException {
		log.info("filling the details");
		Thread.sleep(2000);
	    pd.setFname( randomString());
	    Thread.sleep(2000);
	    pd.setLname( randomString());
	    Thread.sleep(2000);
	    pd.setEid(randomNumeric());
	    
	}

	@When("click on save")
	public void click_on_save() {
		log.info("click on save");
	    pd.clickOnSave();
	}

	@Then("user can see profiles details")
	public void user_can_see_profiles_details() {
	    boolean val=pd.checkValiditionOfPdetails();
	    if(val==true) {
	    	 log.warn("profile details is  visible");
	    	Assert.assertTrue(true);
	    }
	    else{
	    	 log.warn("profile detials is not visible");
	    	Assert.assertTrue(false);
	    }
	}
	
	

}
