package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{

	ShoppingCartPage(WebDriver driver) {
		super(driver);

	}
	
	By link_view_cart = By.xpath("//span[normalize-space()='Shopping Cart']");
	By txt_total_amount = By.xpath("//*[@id='content']/div[2]/div/table//strong[text()='Total:']//following::td");
	//By txt_total_amount = By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]");
	By btn_checkout = By.xpath("//a[@class='btn btn-primary']");
	
	
	public void openShoppingCart() {
		driver.findElement(link_view_cart).click();
	}
	
	public String getTotalAmountofProduct() {
		String totalAmount = driver.findElement(txt_total_amount).getText();
		return totalAmount;
	}
	
	public void clickCheckoutButton() {
		driver.findElement(btn_checkout).click();
	}

}
