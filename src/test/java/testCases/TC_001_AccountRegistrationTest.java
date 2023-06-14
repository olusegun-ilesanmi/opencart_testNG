package testCases;


import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	HomePage hp;
	RegistrationPage rp;
	
	
	@Test (groups = {"Regression" , "Master"})
	void test_account_Registration() throws InterruptedException 
	{
		
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try {
		hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account link");
		
		hp.clickRegister();
		logger.info("Clicked on register link");
		rp = new RegistrationPage(driver);
	
		logger.info("Providing customer's account details");
		rp.setUserName("Alice", "Benson");
		rp.setUserEmail(randomAlphabets() + "@qa.team");
		rp.setUserPhoneNumber(randomDigits());
		String password= randomAlphanumerics();
		rp.setUserPassword(password);
		rp.confirmUserPassword(password);
		rp.verifyTerms();
		rp.clickLoginButton();
		logger.info("Clicked on login continue button");
		
		Thread.sleep(5000);

		String confmessage = rp.verifyMessage();
		
		logger.info("validating account successful creation message");
		Assert.assertEquals(confmessage, "Your Account Has Been Created!", "Test Failed");
		
		rp.completeRegistration();
		}
		catch (Exception e) {
			Assert.fail();
			logger.info("Test failed");
		} 
		
		logger.info("*** Finished TC_001_AccountRegistrationTest ***");
	}
	

}
