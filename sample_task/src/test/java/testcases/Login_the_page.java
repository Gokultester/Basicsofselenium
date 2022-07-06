package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import comman_funtionalities.Browsers;
import pages.Login;

public class Login_the_page {
WebDriver driver;
Browsers brow;
Login log;
@Test
public void browserlaunch(){
	driver=Browsers.StartBrowser("firefox");
	log = new Login(driver);
}

}
