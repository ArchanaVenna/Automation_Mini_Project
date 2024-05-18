package ScenarioTwo;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import ScenarioOne.EbayOne;
import ScreenShot_Results.ScreenShot;

public class EbayTwo {

	Wait<WebDriver>wait;
	By search=By.cssSelector("input.gh-tb.ui-autocomplete-input");
	By searchbutton=By.id("gh-btn");
	By pageload=By.xpath("//a[text()='About eBay']");
	
	By product=By.xpath("((//span[text()='Dell laptop Latitude 7480 14\" i7 2.60GHz 16GB NEW 512GB SSD Win 11 Pro WIFI Cam'])[position()=2])");
	By addtocart=By.xpath("//span[text()='Add to cart']");
	By buyit=By.id("binBtn_btn_1");
	By checkout=By.xpath("//span[text()='Check out as guest'] | //button[text()='Check out as a guest']");
	By verifyproduct=By.xpath("(//span[text()='Dell laptop Latitude 7480 14\" i7 2.60GHz 16GB NEW 512GB SSD Win 11 Pro WIFI Cam'])[position()=2]");
	static WebDriver driver;
	String pdtext;
	String expected="Dell laptop Latitude 7480 14\" i7 2.60GHz 16GB NEW 512GB SSD Win 11 Pro WIFI Cam";
	public void assign(WebDriver driver)
	{   
		this.driver=driver;
		wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(8)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class); 
	}
	public void searchBar() {
		WebElement searching=wait.until(ExpectedConditions.visibilityOfElementLocated(search));
		searching.click();
		searching.sendKeys("MacBook");
		
		searching.clear();
		
		searching.sendKeys(expected);
	}
	
	
	public void clickSearch() {
		WebElement button=wait.until(ExpectedConditions.visibilityOfElementLocated(searchbutton));
		button.click();
	}
	
	
	public void pageLoad() {
		WebElement page=wait.until(ExpectedConditions.visibilityOfElementLocated(pageload));
		 boolean visible=page.isDisplayed();
		 if(visible) {
			 System.out.println("the page displayed completely");
		 }
	}
	
	public boolean verifyingProduct() {
		WebElement actualtext=wait.until(ExpectedConditions.visibilityOfElementLocated(verifyproduct));
		return actualtext.getText().equalsIgnoreCase(expected);
		
	}
	
	public void productSelect() {
		
		WebElement first=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//span[text()='Dell laptop Latitude 7480 14\" i7 2.60GHz 16GB NEW 512GB SSD Win 11 Pro WIFI Cam'])[position()=2])")));//span[text()='eBay Refurbished'])[position()=4]/ancestor::div[@class='s-item__wrapper clearfix']/child::div[1]")));
		first.click();
        Set<String> handles=driver.getWindowHandles();
		 
		 for(String a:handles)
		 {
			 if(!a.equals(handles))
			 {
				 driver.switchTo().window(a);
				// System.out.println(a);
			 }
		 }
	}
	public boolean addCart() {
		try{
			WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addtocart));
			pdtext=addToCartButton.getText();
            ScreenShot obj=new ScreenShot();
		obj.screenShot(driver,"ScenarioTwoAddToCartDisplayed");
//        return pdtext.equals("Add to cart");
//        System.out.println(pdtext);
	    }
		catch(Exception e) {
			System.out.println("Add to cart button is not available.");
		}
		return pdtext.equals("Add to cart");
		
		
		}
	public void buy() {
		driver.findElement(buyit).click();
	}

	public void checkOutGuest() {
		 WebElement guest = wait.until(ExpectedConditions.visibilityOfElementLocated(checkout));
     	 guest.click();
		
	}
	public void terminate() {
		System.out.println("Terminating the code because it is asking for human verification which is not supported by automation");
		
	}
}
