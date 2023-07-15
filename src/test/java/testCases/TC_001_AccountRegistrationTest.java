 package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC_001_AccountRegistrationTest extends BaseClass
{
	
	@Test(groups= {"Regression","Master"})
	public void test_account_registration()
	{
		logger.debug("aplication logs");
		logger.info("*** Starting TC_001_AccountRegistrationTest *** ");
		try
		{
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		AccountRegistrationPage arp=new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		
		arp.setFrstName(Randomstring().toUpperCase());
		arp.setLastName(Randomstring().toUpperCase());
		
		//arp.setEmail("abc123@gmail.com");   static data
		arp.setEmail(Randomstring()+"@gmail.com");
		
		//arp.setPassword("abc@123");
		String passwrd=RandomalphaNumeric();
		arp.setPassword(passwrd);
		
		arp.chkpolicy();
		arp.clickContinue();
		logger.info("Clicked on continue");
		
		String cnfrmMsg=arp.getConfirmationMessage();
		logger.info("Validating expected message");
		Assert.assertEquals(cnfrmMsg,"Your Account Has Been Created!","Not geting expected message");
		}
		catch(Exception e)
		{
			logger.error("Test failed");
			Assert.fail();
		}
		
		
		logger.info("*** Finished TC_001_AccountRegistrationTest *** ");
	}

	
	
	

}
