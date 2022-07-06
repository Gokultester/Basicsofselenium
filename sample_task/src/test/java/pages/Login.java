package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(xpath ="//input[@name='user.name']")
	WebElement Username;
	
	@FindBy(xpath ="//input[@name='user.password']")
	WebElement Password;
	
	@FindBy(xpath ="//button[@type='submit']")
	WebElement Submit;
	
	public Login(WebDriver driver) 
	{
		// initialize elements
		PageFactory.initElements(driver, this);
	}
	
	public void usrname(){
		Username.sendKeys("Testingp");		
	}
	public void pswd(){
		Password.sendKeys("Vinoth@12");
	}
	public void sub1(){
		Submit.click();
	}
}
