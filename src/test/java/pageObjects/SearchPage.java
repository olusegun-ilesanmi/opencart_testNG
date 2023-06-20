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
	
	By list_search_products = By.xpath("//*[@id='content']/div[3]//img");
	By drpdwn_category = By.xpath("//select[@name='category_id']");
	By chkbox_subcategory = By.xpath("//input[@name='sub_category']");
	By chkbox_productdescp = By.xpath("//input[@id='description']");
	By drpdwn_sorting = By.xpath("//select[@id='input-sort']");
	By btn_search = By.xpath("//input[@id='button-search']");
	By input_txt_quantity = By.xpath("//input[@id='input-quantity']");
	By btn_addtocart = By.xpath("//button[@id='button-cart']");
	By txt_message = By.xpath("//div[contains(text() , 'Success: You have added')]");
	
	
	
	public void selectProductsFromCategory(String value) {
		WebElement category = driver.findElement(drpdwn_category);
		Select productCategory = new Select(category);
		productCategory.selectByValue(value);
	}
	
	
	public void searchInSubcategory() {
		driver.findElement(chkbox_subcategory).click();
	}
	public void searchInProductDecription() {
		driver.findElement(chkbox_productdescp).click();
	}
	
	
	public void sortProductSearch(String sorting) {
		WebElement searchSort = driver.findElement(drpdwn_sorting);
		Select sort = new Select(searchSort);
		sort.selectByVisibleText(sorting);
	}
	
	
	public void clickNewSearchButton() {
		driver.findElement(btn_search).click();
	}
	
	List<WebElement> productName = driver.findElements(list_search_products);
	public boolean verifyProductExists(String pName) 
	{
		 
		 boolean flag = false;
		 for (WebElement product:productName) {
			 
			 if (product.getAttribute("title").equals(pName)) {
				 flag = true;
				 break;
			 }
			    
		    }
		return flag;
	
      }    
	
    
	public void selectproduct(String pName) 
	{
	 
		 for (WebElement product:productName) {
			 
			 if (product.getAttribute("title").equals(pName)) 
			 {
				 product.click();
			 }
			    
		    }
      }   
	
	public void addProductQuantity(String qty) 
	{
		WebElement itemQuantity = driver.findElement(input_txt_quantity);
		itemQuantity.clear();
		itemQuantity.sendKeys(qty);
	}
	
	public void addProductToCart() {
		driver.findElement(btn_addtocart).click();
	}
	
	public boolean confirmSuccessMessage() {
		try {
		boolean succesmessage = driver.findElement(txt_message).isDisplayed();
		return succesmessage;
		}
		catch (Exception e) {
			return false;
		}
	}
	


}
