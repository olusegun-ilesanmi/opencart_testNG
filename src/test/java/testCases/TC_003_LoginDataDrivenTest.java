package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass{
	
	HomePage hp;
	LoginPage lp;
	MyAccountPage mp;

	
	@Test (dataProvider ="LoginData", dataProviderClass = DataProviders.class) //gets the data from dataProvider class
	public void test_logindatadriven(String email, String password, String expstatus) 
	{
		logger.info("*** Starting TC_003_LoginDataDrivenTest ***");
		try 
		{

		
		hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account link");
		hp.clickLogin();
		logger.info("Clicked on login link");
		
		lp = new LoginPage(driver);
		
		logger.info("providing login details");
		lp.enterEmail(email); //getting credentials from config.properties file
		lp.enterPassword(password);
		lp.clickLoginButton();
		logger.info("Clicked on login continue button");
		
		mp = new MyAccountPage(driver);
		boolean targetpage = mp.verifyMyAccountPageExists();
		
		//Login Validation 
		logger.info("Performing login validation for positive and negative tests");
		if (expstatus.equals("Valid")) 
		{
			
			if (targetpage == true) 
			{
				
				mp.clickLogoutButton();
				Assert.assertTrue(true); //Test passed
			}
			else 
			{
				Assert.assertTrue(false); //Test failed 
			}
		}
		
		if (expstatus.equals("Invalid"))
		{
			
			if (targetpage == true) 
			{
				MyAccountPage map = new MyAccountPage(driver);
				map.clickLogoutButton();
				Assert.assertTrue(false); //Test failed
			}
			else 
			{
				Assert.assertTrue(true); //Test passed
			}
		}
		
		}
		catch (Exception e) 
		{
			Assert.fail();
		} 

		logger.info("*** Finished TC_003_LoginDataDrivenTest ***");

}
	
}
