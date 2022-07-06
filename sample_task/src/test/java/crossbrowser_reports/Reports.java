package crossbrowser_reports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports {
	static WebDriver driver;
	static ExtentReports extentreports;
	ExtentHtmlReporter htmlreport;
	static ExtentTest testCase;

	
	public void starttest(){
		extentreports = new ExtentReports();
		htmlreport = new ExtentHtmlReporter("extent.html");
		extentreports.attachReporter(htmlreport);
	}
@BeforeTest
public void setup (String browser) throws Exception{
	if(browser.equalsIgnoreCase("Chrome")){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		String title=driver.getTitle();
		if(driver.getTitle().equals("firefox"))
		{
		testCase.log(Status.PASS, "Navigated to the specified URL");
		}
		else
		{
		testCase.log(Status.FAIL, "Test Failed");
		}
	}
	else if (browser.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("http://172.16.10.74:8186/StarCreditApp/#/login");
		String title=driver.getTitle();
		if(driver.getTitle().equals("edge"))
		{
		testCase.log(Status.PASS, "Navigated to the specified URL");
		}
		else
		{
		testCase.log(Status.FAIL, "Test Failed");
		}
	}
	else if (browser.equalsIgnoreCase("IE"))
	{
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		driver.get("http://172.16.10.74:8186/StarCreditApp/#/login");
		String title=driver.getTitle();
		testCase.log(Status.INFO, "Actual title:"+ title);
		testCase.log(Status.INFO, "Expected title:"+ "IE");
		testCase.log(Status.INFO, "verification of actual and expected title");
		if(title.equals("Chrome"))
		{
			testCase.log(Status.PASS, "actual and expected title are equal");
		}
		else
		{
			testCase.log(Status.FAIL, "actual and expected title are not equal ");
		}
	}
	else
	{
		
		throw new Exception("Browser is not correct");
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Test
public void testparameter(){
	driver.get("http://172.16.10.154:4200/#/login");
	driver.quit();
}

public static void endTest() {
	driver.close();
	extentreports.flush();
}
}
