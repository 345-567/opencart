package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void test_login()
	{
		try
		{
		 logger.info("***TC_002_Login Test started***");
		 
		 HomePage hp=new HomePage(driver);
		 hp.clickMyAccount();
		 logger.info("clicked on myaccount");
		 hp.clickLogin();
		 logger.info("clicked on login link");
		 
		 LoginPage lp=new LoginPage(driver);
		 logger.info("providing login details");
		 lp.setEmailid(rb.getString("email"));
		 
		 lp.setPassword(rb.getString("password"));
		 Thread.sleep(3000);
		 lp.clickLoginBtn();
		 logger.info("clicked on login button");
		 
		 MyAccountPage ap=new MyAccountPage(driver);
		 boolean targetPage=ap.isMyAccountExists();
		 Assert.assertEquals(targetPage,true,"INvalid login data");
		 
		}
		
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		 
		 logger.info("******TC_002_LogIn test finished");
	}

}
