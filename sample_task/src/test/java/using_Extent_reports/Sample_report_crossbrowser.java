package using_Extent_reports;

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




@SuppressWarnings("deprecation")
public class Sample_report_crossbrowser {
	WebDriver driver;
	ExtentReports extentreports;
	ExtentTest testCase;
	@SuppressWarnings("deprecation")
	ExtentHtmlReporter htmlReporter;
	@SuppressWarnings("deprecation")
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		if (browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			//test.log(LogStatus.PASS, "Navigated to the specified URL");
		}
		else if (browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		//	test.log(LogStatus.PASS, "Navigated to the specified URL");
		}
		else if (browser.equalsIgnoreCase("IE")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			//test.log(LogStatus.PASS, "Navigated to the specified URL");
		}
		else{
			//test.log(LogStatus.FAIL, "Test Failed");
			throw new Exception("Browser is not correct");
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void testParameterWithXML() throws InterruptedException{
		driver.get("http://172.16.10.154:4200/#/login");
		driver.quit();			
	}
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void launchBrowser(){
		extentreports = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extentreports.attachReporter(htmlReporter);
		
	}
}
