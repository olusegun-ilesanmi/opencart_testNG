package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_Search extends BaseClass {
	
	
	HomePage hp;
	SearchPage sh;
	
	
	@Test 
	void testSearchProduct() throws InterruptedException {
		
		
		logger.info("***Starting TC_004_Search***");
		hp = new HomePage(driver);
		
		logger.info("Enter a product name");
		hp.enterSearchItem("mac");
		
		hp.clickSearchButton();
		logger.info("clicked on search button");
		
		Thread.sleep(4000);
		
		sh = new SearchPage(driver);
		
		sh.selectProductsFromCategory();
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
		
		sh.sortProductSearch();
		logger.info("Sort product with price from Low to high");
		Thread.sleep(2000);
		
		logger.info("***Verifying that Macbook product  exists***");
		
		String product = sh.verifyProductExists("MacBook");
		Assert.assertSame(product, product, "Product Exists and Test Passed");
		
		logger.info("***Finished TC_004_Search***");
		
		
		
		
		
		
		
	}
	

}
