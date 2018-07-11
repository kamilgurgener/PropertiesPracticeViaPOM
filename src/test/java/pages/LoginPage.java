package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (className= "login")
	public WebElement singIn;
	
	@FindBy (id= "email")
	public WebElement email;
	
	@FindBy (id= "passwd")
	public WebElement Password;
	
	@FindBy (id = "SubmitLogin")
	public WebElement singInButton;
	

}
