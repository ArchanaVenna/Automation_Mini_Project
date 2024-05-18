package ScenarioThree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ScreenShot_Results.ScreenShot;

public class HerokuAppBasic extends HerokuApp {

	WebDriver driver;

	
	By basicAuth=By.linkText("Basic Auth");
	By Message=By.tagName("p");
	
	
	HerokuAppBasic(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void name()
	{
		
	   driver.findElement(basicAuth).click();
		
	}
	
	public boolean MessageDisplayed(String expectedMessage)
	{
		ScreenShot obj=new ScreenShot();
		obj.screenShot(driver,"ScenarioThreeSuccessfullMessages");
		return driver.findElement(Message).getText().equals(expectedMessage);
		
	}
}

