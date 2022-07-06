package comman_funtionalities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers {
	static WebDriver driver;

    public static WebDriver StartBrowser(String browsername)
    {
               
               if(browsername.equalsIgnoreCase("Firefox"))
                {
            	   WebDriverManager.firefoxdriver().setup();
            	   driver = new FirefoxDriver();
                            
                }

             
            else if(browsername.equalsIgnoreCase("Chrome"))
             {
                 WebDriverManager.chromedriver().setup();
                 driver = new ChromeDriver();
             }
          
          else if(browsername.equalsIgnoreCase("IE"))
          {
                  WebDriverManager.edgedriver().setup();
                  driver = new InternetExplorerDriver();
          }

                   driver.manage().window().maximize();
                  driver.get("http://172.16.10.154:4200/#/login");
                 return driver;
          }
}
