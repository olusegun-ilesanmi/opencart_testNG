package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	By list_products = By.xpath("//body/div[@id='product-search']/div[@class='row']/div[@id='content']/div[3]");
	By drpdwn_category = By.xpath("//select[@name='category_id']");
	By chkbox_subcategory = By.xpath("//input[@name='sub_category']");
	By chkbox_productdescp = By.xpath("//input[@id='description']");
	By drpdwn_sorting = By.xpath("//select[@id='input-sort']");
	By btn_search = By.xpath("//input[@id='button-search']");
	
	
	
	public void selectProductsFromCategory() {
		WebElement category = driver.findElement(drpdwn_category);
		Select productCategory = new Select(category);
		productCategory.selectByValue("20");
	}
	
	
	public void searchInSubcategory() {
		driver.findElement(chkbox_subcategory).click();
	}
	public void searchInProductDecription() {
		driver.findElement(chkbox_productdescp).click();
	}
	
	
	public void sortProductSearch() {
		WebElement searchSort = driver.findElement(drpdwn_sorting);
		Select sort = new Select(searchSort);
		sort.selectByVisibleText("Price (Low > High)");
	}
	
	
	public void clickNewSearchButton() {
		driver.findElement(btn_search).click();
	}
	
	
	public String verifyProductExists(String pName) 
	{
	
		try {
			
		
		    List<WebElement> productName = driver.findElements(list_products);
		 
		    for (WebElement product:productName) {
		    	
		        String newProduct = product.getAttribute(pName);
			    return newProduct;
			    
		    }
		    
	     }
		catch (Exception e) {
			return null;
		}
		return null;
	
}
		

}
