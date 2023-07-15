package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	void test_loginDDT(String email, String password, String expected)//excel sheet has 3 columns
	{
		try
		{
		logger.info("****Starting TC_))#_Login DDT****");
		
		HomePage hp=new HomePage(driver);
		 hp.clickMyAccount();
		 
		 hp.clickLogin();

		 
		 LoginPage lp=new LoginPage(driver);
		 
		 lp.setEmailid(email);
		 
		 lp.setPassword(password);
		  
		 lp.clickLoginBtn();
		 
		 MyAccountPage ap=new MyAccountPage(driver);
		 boolean targetPage=ap.isMyAccountExists();
		 //consider valid /invalid data (expected column)
		 if(expected.equals("Valid"))
		 {
			 if(targetPage==true)
			 {
				 ap.clickLogout();
				Assert.assertTrue(true);
			 }
			 else
			 {
				Assert.fail();
				//Assert.assertTrue(false);
			 }
		 }
		 if(expected.equals("Invalid"))
		 {
			 if(targetPage==true)
			 {
				 ap.clickLogout();
				 Assert.assertTrue(false);
			 }
			 else
			 {
				 Assert.assertTrue(true);
			 }
		 }
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****TC_003_loginDDT finished");
		
		
		
		
		
		 
	}

}
