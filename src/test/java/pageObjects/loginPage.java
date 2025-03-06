package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.waitHelper;

public class loginPage {
 WebDriver driver;
 waitHelper wh;
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wh=new waitHelper(driver);
	}
	
	
	@FindBy(xpath="//input[@placeholder='Username']")WebElement txtbox_email; 
	@FindBy(xpath="//input[@placeholder='Password']")WebElement txtbox_pass;
	@FindBy(xpath="//button[@type='submit']")WebElement btn_login;
	
	public void setEmail(String mail) {
		wh.ExplicitWait(txtbox_email, 5);
		txtbox_email.clear();
		txtbox_email.sendKeys(mail);
	}
	
	public void setPass(String pass) {
		wh.ExplicitWait(txtbox_pass, 5);
		txtbox_pass.clear();
		txtbox_pass.sendKeys(pass);
	}
	
	public void clickLogin() {
		wh.ExplicitWait(btn_login, 5);
		btn_login.click();
	}

}
