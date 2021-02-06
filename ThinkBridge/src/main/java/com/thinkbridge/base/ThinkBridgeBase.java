package com.thinkbridge.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThinkBridgeBase {

	public static WebDriver driver;

	public static void driverInitialization(){
		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ChromeDriver\\chromedriver.exe"); 
		    driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to("http://jt-dev.azurewebsites.net/#/SignUp");
		
	}
}
