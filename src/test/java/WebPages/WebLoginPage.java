package WebPages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class WebLoginPage {
	WebDriver driver;

	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();

	}

	@Test()
	public void positiveloginTest() throws IOException {
		

		Properties prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("./config.properties");
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		driver.get(prop.getProperty("URL"));
		LoginPage page = new LoginPage(driver);
		page.singIn.click();

		page.email.sendKeys(prop.getProperty("User"));
		page.Password.sendKeys(prop.getProperty("Password"));
		page.singInButton.click();

	}

}
