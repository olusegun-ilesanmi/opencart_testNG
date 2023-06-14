package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods
	
	String repName;

	public void onStart(ITestContext testcontext) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //Create time stamp
		repName = "Test-Report-" + timeStamp + ".html"; //creating report name with time stamp
			
		sparkReporter=new ExtentSparkReporter("./reports/" +repName);//specify location of the report
		
		sparkReporter.config().setDocumentTitle("opencart Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("opencart Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK); //dark and standard themes
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application","opencart");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("Sub-Module","Customer");
		extent.setSystemInfo("Tester Name","Samuel Ilesanmi");
		extent.setSystemInfo("Operating system", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Browser name","Chrome,Firefox,Edge");
		extent.setSystemInfo("Environment","QA");
					
	}


	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName()); // create a new entry in the report
		test.log(Status.PASS, "Test Passed"); // update test status p/f/s
		
	}

	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage()); 
		
		try {
			String imgPath = new BaseClass().catureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
					
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage()); 
		
	}

	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
	

}
