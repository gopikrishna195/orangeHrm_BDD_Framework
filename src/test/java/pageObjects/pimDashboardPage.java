package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.waitHelper;

public class pimDashboardPage {
   WebDriver driver;
   waitHelper wh;
	public pimDashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	
	
	//a[normalize-space()='Personal Details']
	
	
	@FindBy(xpath="//h6[normalize-space()='PIM']")WebElement pimDashboard;
    @FindBy(xpath="//button[normalize-space()='Add']")WebElement btn_add;
    @FindBy(xpath="//input[@placeholder='First Name']")WebElement txtbox_firstname;
    @FindBy(xpath="//input[@placeholder='Last Name']")WebElement txtbox_lastname;
    @FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")WebElement txtbox_empid; 
    @FindBy(xpath="//button[normalize-space()='Save']")WebElement btn_save;
    @FindBy(xpath="//a[normalize-space()='Personal Details']")WebElement txt_personalDetails;
    
    public boolean pimDashboard() {
    	wh=new waitHelper(driver);
         wh.ExplicitWait(pimDashboard, 5);
    	return(pimDashboard.isDisplayed());
    }
    
    public void clickAddButton() {
    	    	wh.ExplicitWait(btn_add, 3);
    	          btn_add.click();
    }
    
    public void setFname(String fname) {
    	wh.ExplicitWait(txtbox_firstname, 3);
    	txtbox_firstname.sendKeys(fname);
    }
    
    public void setLname(String lname) {
    	wh.ExplicitWait(txtbox_firstname, 3);
    	txtbox_lastname.sendKeys(lname);
    }
    public void setEid(String id) {
    	wh.ExplicitWait(txtbox_empid, 5);
    	txtbox_empid.sendKeys(id);
    }
    public void clickOnSave() {
    	wh.ExplicitWait(btn_save, 3);
    	btn_save.click();
    }
    
    public boolean checkValiditionOfPdetails() {
    	wh.ExplicitWait(txt_personalDetails, 5);
    	return(txt_personalDetails.isDisplayed());
    }
}
