package ScreenShot_Results;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	WebDriver driver;
	 
	public void screenShot(WebDriver driver,String imageName) {
		this.driver = driver;
 
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 
		File destination = new File("/Users/archana/eclipse-workspace/MiniProjectAutomation/src/main/java/ResultImage"+imageName+".jpg");
		try {
			FileUtils.copyFile(source, destination);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}

}
