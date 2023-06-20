package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass {
	
	
	HomePage hp;
	SearchPage sh;
	
	
	@Test 
	void testSearchProduct() throws InterruptedException {
		
		
		logger.info("***Starting TC_004_SearchProductTest***");
		
		try {
		hp = new HomePage(driver);
		
		logger.info("Enter a product name");
		hp.enterSearchItem("mac");
		
		hp.clickSearchButton();
		logger.info("clicked on search button");
		
		Thread.sleep(4000);
		
		sh = new SearchPage(driver);
		
		sh.selectProductsFromCategory("20");
		logger.info("select product category");
		Thread.sleep(2000);
		
		sh.searchInSubcategory();
		logger.info("clicked subcategory checkbox");
		Thread.sleep(2000);
		
		sh.searchInProductDecription();
		logger.info("clicked product description check box");
		Thread.sleep(2000);
		
		sh.clickNewSearchButton();
		logger.info("clicked on search button");
		Thread.sleep(2000);
		
		sh.sortProductSearch("Price (Low > High)");
		logger.info("Sort product with price from Low to high");
		Thread.sleep(2000);
		
		logger.info("***Verifying that Macbook product  exists***");
		
		boolean product = sh.verifyProductExists("MacBook");
		Assert.assertEquals(product, true);
		}
		catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("***Finished TC_004_SearchProductTest***");
		
		
		
	}
	

}
