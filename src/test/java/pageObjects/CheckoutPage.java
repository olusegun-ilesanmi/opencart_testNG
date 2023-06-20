package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

	CheckoutPage(WebDriver driver) {
		super(driver);

	}
	
	By input_firstname = By.name("firstname");
	By input_lastname = By.name("lastname");
	By input_address = By.name("address_1");
	By input_city = By.name("city");
	By input_postcode = By.name("postcode");
	By input_countrydrpdown = By.name("country_id");
	By input_statedrpdown = By.name("zone_id");
	By btn_ctn_BillingAddress = By.xpath("//input[@id='button-payment-address']");
	By checkbox_agreement = By.xpath("//input[@name='agree']");
	By btn_ctn_PaymentMethod = By.xpath("//input[@id='button-payment-method']");
    By input_paymentmessage = By.xpath("//textarea[@name='comment']");
}
