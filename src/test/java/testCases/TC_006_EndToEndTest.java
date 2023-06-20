package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;
import pageObjects.SearchPage;
import testBase.BaseClass;


public class TC_006_EndToEndTest extends BaseClass{
	
	HomePage hp;
	MyAccountPage mp;
	RegistrationPage rp;
	LoginPage lp;
	SearchPage sp;
	
	
	
	@Test
	void endToEnd() throws InterruptedException
	{

		logger.info("***Starting TC_006_EndToEndTest***");
		logger.info("regristering user");
		//try {
		hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account link");
		
		hp.clickRegister();
		logger.info("Clicked on register link");
		rp = new RegistrationPage(driver);
	
		logger.info("Providing customer's account details");
		rp.setUserName(randomAlphabets(),randomAlphabets());
		String email = (randomAlphabets() + "@qa.team");
		rp.setUserEmail(email);
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
		
		logger.info("registration successful");
		
		Thread.sleep(3000);

		mp = new MyAccountPage(driver);
		mp.clickLogoutButton();
		mp.clickLogout();
		Thread.sleep(3000);

		hp.clickMyAccount();
		hp.clickLogin();
		logger.info("Clicked on login link");
		
		lp = new LoginPage(driver);
		
		logger.info("providing login details");
		lp.enterEmail(email); 
		lp.enterPassword(password); 
		lp.clickLoginButton();
		logger.info("Clicked on login continue button");
		Thread.sleep(2000);

		
		logger.info("Check if my account heading is displayed");
		boolean targetpage = mp.verifyMyAccountPageExists();
		Assert.assertEquals(targetpage, true, "Invalid login details"); //If the heading exists, login was successful
		
		logger.info("Login was successful");
		
		Thread.sleep(3000);
		
		logger.info("Enter a product name");
		hp.enterSearchItem("MacBook");
		hp.clickSearchButton();
		logger.info("clicked on search button");
		
		sp = new SearchPage(driver);

		Thread.sleep(2000); 
		
		logger.info("***Verifying that Macbook product exists***");

		if (sp.verifyProductExists("MacBook Pro")) 
		{
		
			sp.selectproduct("MacBook Pro");
			logger.info("Clicked on the product");
			Thread.sleep(3000);
			
			logger.info("Add the quantity to be purchased");
			sp.addProductQuantity("3");
			Thread.sleep(3000);
			
			sp.addProductToCart();
			logger.info("Added product to cart");
			Thread.sleep(2000);
		}
		
		logger.info("Confirm success message is displayed");
		boolean message = sp.confirmSuccessMessage();
		Assert.assertEquals(message, true);
		/*}
		catch (Exception e) {
			Assert.fail();
		} */
		logger.info("***Finished TC_006_EndToEndTest***");
		
		
	}

}
