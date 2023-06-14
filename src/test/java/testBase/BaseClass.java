package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger; //declaring logging statement
	public ResourceBundle rb; //to access the resources package
	
	@BeforeClass (groups = {"Master", "Sanity", "Regression"})
	@Parameters({"browser"})
	public void setUp(String br)
	{
		rb = ResourceBundle.getBundle("config"); //load config.properties file
		
		logger = LogManager.getLogger(this.getClass()); //instantiate log variable and store the logs in the current executable class
		
		/*
		//to remove the "this browser is controlled by automation" message
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		*/
		if (br.equals("chrome")) {
		    driver = new ChromeDriver(); 
		}
		else if (br.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass (groups = {"Master", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
	
	//generating random strings 
	public String randomAlphabets() {
		String alphabet = RandomStringUtils.randomAlphabetic(6);
		return (alphabet);
	}
	
	public String randomDigits() {
		String num = RandomStringUtils.randomNumeric(10);
		return (num);
	}
	
	public String randomAlphanumerics() {
		String alphanum = RandomStringUtils.randomAlphanumeric(8);
		return (alphanum);
	}

	public String catureScreen(String tname) throws IOException {
		
		
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE); //capture the screenshot
	    String destination = System.getProperty("user.dir") + "/Screenshots/" +tname + "_" +timeStamp+ ".png";
	    try {
	    FileUtils.copyFile(source, new File(destination));
	    }
	    catch (Exception e) {
	    	e.getMessage();
	    }
		return destination;
	}
	
	
}
