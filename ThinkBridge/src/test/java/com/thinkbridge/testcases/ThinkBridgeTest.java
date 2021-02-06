package com.thinkbridge.testcases;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thinkbridge.base.ThinkBridgeBase;
import com.thinkbridge.page.ThinkBridgePage;

public class ThinkBridgeTest extends ThinkBridgeBase {

	ThinkBridgePage signUpPage;
	
	@BeforeMethod
	 public void launchBrowser() {
		 driverInitialization();
		 signUpPage = new ThinkBridgePage();
	 }
	
	@Test
	public void ThinkBridgePage() throws InterruptedException {
		//Verifying Title
	    String title = signUpPage.JabaTalksTitle();
	    Assert.assertEquals(title, "Jabatalks");
	    
	    //Verifying Languages
	   List<WebElement> languages= signUpPage.languageValidation();
		for(int i=0; i<languages.size(); i++) {
			String language=languages.get(i).getText();
			System.out.println(language);
		    if(!(language.equals("English") || language.equals("Dutch"))) {
			    Assert.fail("The language is neither English nor Dutch");
			}
		}
		
		//SingUp and Validate Success Message
	    String message =signUpPage.JabaTalksSignUp("Sruthi", "Sruthi", "bojedla.sruthi10@gmaill.com");
	    System.out.println(message);
	    Assert.assertEquals(message, "A welcome email has been sent. Please check your email.");
		}
	
	 @AfterMethod
	 public void closeBrowser() {
		 driver.quit();
	 }
}
