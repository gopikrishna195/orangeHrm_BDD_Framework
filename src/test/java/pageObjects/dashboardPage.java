package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.waitHelper;

public class dashboardPage {
	WebDriver driver;
	waitHelper wh;

	public dashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// pim button

	@FindBy(xpath = "//div[@class='oxd-topbar-header-title']")
	WebElement dashboard;

	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")
	WebElement btn_pim;

	public boolean dashboard() {
		wh = new waitHelper(driver);
		wh.ExplicitWait(dashboard, 10);
		return (dashboard.isDisplayed());
	}
	
	public void clickPimbutton() {
		wh.ExplicitWait(btn_pim, 5);
		btn_pim.click();
	}

}
