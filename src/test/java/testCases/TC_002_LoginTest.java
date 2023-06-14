package testCases;

import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	HomePage hp;
	LoginPage lp;
	MyAccountPage mp;
	ResourceBundle rb;
	
	@Test (groups = {"Sanity","Master"})
	void test_login() 
	{
		logger.info("*** Starting TC_002_LoginTest ***");
		try {

		rb = ResourceBundle.getBundle("config");
		
		hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account link");
		hp.clickLogin();
		logger.info("Clicked on login link");
		
		lp = new LoginPage(driver);
		
		logger.info("providing login details");
		lp.enterEmail(rb.getString("email")); //getting credentials from config.properties file
		lp.enterPassword(rb.getString("password")); //getting credentials from config.properties file
		lp.clickLoginButton();
		logger.info("Clicked on login continue button");
	    
		mp = new MyAccountPage(driver);
		boolean targetpage = mp.verifyMyAccountPageExists();
		Assert.assertEquals(targetpage, true, "Invalid login details"); //If the heading exists, login was successful
		
		logger.info("Check if my account heading is displayed");
		}
		catch (Exception e) {
			Assert.fail();
		} 
		logger.info("*** Finished TC_002_LoginTest ***");
		
	}

}
