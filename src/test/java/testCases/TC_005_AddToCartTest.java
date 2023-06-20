package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_005_AddToCartTest extends BaseClass{
	
	HomePage hp;
	SearchPage sp;

	
	
	@Test
	void addTocart() throws InterruptedException 
	{
		
		logger.info("***Starting TC_005_AddToCartTest***");
		
		try {
		hp = new HomePage(driver);
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
		}
		catch (Exception e) {
			Assert.fail();
		} 
		logger.info("***Finished TC_005_AddToCartTest***");
		
	}

}
