package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginElements {


	
	@FindBy(id="ap_email")
    public static WebElement us;
	
	@FindBy(id="continue")
	public static WebElement continuebtn;

	/*public WebElement us(WebDriver driver) {

		return driver.findElement(By.id("ap_email"));
	}


	public WebElement continuebtn(WebDriver driver) {
		return driver.findElement(By.id("continue"));
	}
	
	*/

}
