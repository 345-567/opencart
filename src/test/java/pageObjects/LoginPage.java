package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}

	//locators
	@FindBy(xpath="//input[@id='input-email']") WebElement emailid;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement loginBtn; 
	
	public void setEmailid(String email)
	{
		emailid.sendKeys(email);
	}
	
	public void setPassword(String pswrd)
	{
		password.sendKeys(pswrd);
	}
	
	public void clickLoginBtn()
	{
		loginBtn.click();
	}
	
	
	
	
}
