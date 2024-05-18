package ScenarioTwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EbayBuy extends EbayTwo {
	String firstwindow="";
	@BeforeMethod
	public  WebDriver getDriver() {
        if (driver == null) {
           
 
            // Initialize ChromeDriver
            driver = new ChromeDriver();
        }
        return driver;
    }
	@Parameters({"url"})
	@Test(description="Access a Product via Search")
	public void testCases(String url) {
		driver=getDriver();
    	driver.manage().window().maximize();
    	driver.get(url);
    	EbayTwo buy=new EbayTwo();
    	firstwindow=driver.getWindowHandle();
    	buy.assign(driver);
    	buy.searchBar();
    	buy.clickSearch();
    	buy.pageLoad();
    	Assert.assertTrue(buy.verifyingProduct());
    	buy.productSelect();
    	boolean a=buy.addCart();
    	Assert.assertTrue(a);
    	Reporter.log("add to cart button available");
    	buy.buy();
//    	buy.checkOutGuest();
    	buy.terminate();
	}
	@AfterClass
	public void close() {
		driver.quit();
		System.exit(0);
	}

}
