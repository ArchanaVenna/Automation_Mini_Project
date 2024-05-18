package ScenarioOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EbayCart extends EbayOne {

	@BeforeMethod
	public  WebDriver getDriver() {
        if (driver == null) {
           
 
            // Initialize ChromeDriver
            driver = new ChromeDriver();
        }
        return driver;
    }

	@Parameters({"url"})
	@Test(description="Access a Product via category after applying multiple filters")
	
	 public void testCase(String url) {
	       
	    	driver=getDriver();

	    	driver.manage().window().maximize();
	    	driver.get(url);
			EbayOne cart =new EbayOne();
			cart.assign(driver);
		    cart.shopCategoryFlow();
			cart.cellAndAccesories();
			cart.filters();
			cart.applying();

			cart.productSize();
			cart.listOfProducts();
			
	}
	@AfterClass
	public void exit() {
		driver.quit();
		}
	}
