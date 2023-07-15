package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement firstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@name='agree']") WebElement chkdPolicy;
	@FindBy(xpath="//button[normalize-space()='Continue']") WebElement Continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement cnfrmtnMessage;
	
	public void setFrstName(String fname)
	{
		firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void setEmail(String Email)
	{
		email.sendKeys(Email);
	}
	
	public void setPassword(String pswrd)
	{
		password.sendKeys(pswrd);
	}
	
	public void chkpolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		Continue.click();
	}
	
	public String getConfirmationMessage()
	{
		try 
		{
		return(cnfrmtnMessage.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
