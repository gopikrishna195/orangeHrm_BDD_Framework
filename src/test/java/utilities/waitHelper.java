package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitHelper {
   WebDriver driver;
   WebDriverWait wait;
   
	public waitHelper(WebDriver driver) {
		this.driver=driver;
		
	}
	
	

	public void ExplicitWait(WebElement element, long timeoutinseconds) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(timeoutinseconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
