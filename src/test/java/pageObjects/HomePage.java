package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
		
		
		//Elements locator
		
		By link_MyAccount = By.xpath("//span[normalize-space()='My Account']");
		By link_Register = By.xpath("//a[normalize-space()='Register']");
		By link_login = By.xpath("//a[normalize-space()='Login']");
		By input_txt_search = By.name("search");
		By btn_search = By.xpath("//button[@class='btn btn-default btn-lg']");
		
		
		
		
		public void clickMyAccount() {
			driver.findElement(link_MyAccount).click();
		}
		
		public void clickRegister() {
			driver.findElement(link_Register).click();
		}
		
		public void clickLogin() {
			driver.findElement(link_login).click();
		}
		
		public void enterSearchItem(String sch) {
			
			driver.findElement(input_txt_search).sendKeys(sch);
		}
		
		public void clickSearchButton() {
			driver.findElement(btn_search).click();
		}
	}

	

