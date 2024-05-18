package ScenarioOne;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;
import org.testng.Assert;


public class EbayOne {

	Wait<WebDriver>wait;
	By shop=By.id("gh-shop-a");
	By cells=By.xpath("(//a[text()='Cell phones & accessories'])");
	By accessories=By.xpath("(//div[text()='Cell Phones & Smartphones'])");
	By filter=By.cssSelector("button.brm__all-filters.fake-link");
	By condition=By.xpath("(//span[text()='Condition'])[position()=2]");
	By checkbox=By.xpath("(//span[text()='Excellent - Refurbished'])[position()=2]");
	By price =By.xpath("(//span[text()='Price'])[position()=2]");
	By pricefrom=By.cssSelector("input.x-textrange__input.x-textrange__input--from");
	By priceto=By.cssSelector("input.x-textrange__input.x-textrange__input--to");
	By itemlocation=By.xpath("(//span[text()='Item Location'])");
	By worldwide=By.cssSelector("input[value='Worldwide']");
	By apply=By.xpath("(//button[text()='Apply'])");
	By size=By.className("s-item__image-helper");
	By productname=By.xpath("//h3[@class='s-item__title']");
	By productprice=By.xpath("//span[@class='s-item__price']");
	static WebDriver driver;
	List<WebElement> products;
	
	public void assign(WebDriver driver)
	{   
		this.driver=driver;
		wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(90)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class); 
	}
	public void shopCategoryFlow() {
		driver.findElement(shop).click();
		driver.findElement(cells).click();
	}
	public void cellAndAccesories() {
		WebElement shopcat=wait.until(ExpectedConditions.visibilityOfElementLocated(accessories));
		shopcat.click();
	}
	public void filters() {
		WebElement allfilter=wait.until(ExpectedConditions.visibilityOfElementLocated(filter));
		allfilter.click();
	}
	public void applying() {
		WebElement conditions=wait.until(ExpectedConditions.visibilityOfElementLocated(condition));
		conditions.click();
		
		WebElement box=wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
		if(!box.isSelected())
		{
			box.click();
		}
		
		WebElement prices=wait.until(ExpectedConditions.visibilityOfElementLocated(price));
		prices.click();
		
		WebElement price1=wait.until(ExpectedConditions.visibilityOfElementLocated(pricefrom));
		price1.click();
		price1.sendKeys("50");
		
		WebElement price2=wait.until(ExpectedConditions.visibilityOfElementLocated(priceto));
		price2.click();
		price2.sendKeys("100");
		
		WebElement itemloc=wait.until(ExpectedConditions.visibilityOfElementLocated(itemlocation));
		itemloc.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(worldwide).click();
		
		WebElement app= wait.until(ExpectedConditions.visibilityOfElementLocated(apply));
		app.click();
	}
	
	public void productSize() {
		products=driver.findElements(size);
		System.out.println(products.size());
	}
	public void listOfProducts() {
		for (int i = 0; i < 3; i++) { // Retry 3 times
		    try {
		        List<WebElement> name = driver.findElements(productname);
		        List<WebElement> prices = driver.findElements(productprice);
		        
		        
		        for (int j = 0; j < name.size(); j++) {
				    WebElement productElement = name.get(j);
				    WebElement priceElement = prices.get(j);
				    
				    String productName = productElement.getText();
				    String productPrice = priceElement.getText();
				    
//				    System.out.println("Product: " + productName + " Price: " + productPrice);
				    String logMessage = "Product: " + productName + " Price: " + productPrice;
	                Reporter.log(logMessage);
				}
		        break; // Break the loop if successful
		    } catch (StaleElementReferenceException e) {
		        System.out.println("Elements became stale. Retrying...");    
		}
		
		}	
	}
	
	}
	

	

