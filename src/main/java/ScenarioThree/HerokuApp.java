package ScenarioThree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HerokuApp {
	WebDriver driver;
	HerokuAppBasic auth;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		this.auth = new HerokuAppBasic(driver);

		driver.manage().window().maximize();
		driver.get("http:admin:admin@the-internet.herokuapp.com/");

	}

	@Test
	public void successfulLogin() {
		auth.name();
		String expected = "Congratulations! You must have the proper credentials.";
		Reporter.log(expected);
		Assert.assertTrue(auth.MessageDisplayed(expected));

	}

	


}
