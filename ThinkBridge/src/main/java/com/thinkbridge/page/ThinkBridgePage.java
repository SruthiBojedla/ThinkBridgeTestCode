package com.thinkbridge.page;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.thinkbridge.base.ThinkBridgeBase;

public class ThinkBridgePage extends ThinkBridgeBase{

	@FindBy(id = "name")	//Full Name
	WebElement fullName;
	
	@FindBy(id = "orgName")		// Organization Name
	WebElement organization;
	
	@FindBy(id = "singUpEmail")		// SignUp Mail ID
	WebElement emailID;
	
	@FindBy(xpath = "//span[@class = 'black-color ng-binding']")
	WebElement checkBox;			//Terms and Conditions Check Box
	
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement getStarted;			//Get Started Button
	
	@FindBy(id = "language")
	WebElement languageDropDown;	//Language Drop Down	
	
	@FindBy(xpath = "//span[text() = ' A welcome email has been sent. Please check your email. ']")
	WebElement textMessage;			// Text Message after SignUp
	
	@FindBy(xpath = "//div[contains(@id,'ui-select-choices-row-1-')]")    
	List<WebElement> languages;		// Store Languages in Drop down
	
	public ThinkBridgePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Page Title
	public String JabaTalksTitle(){
		return driver.getTitle();
	}
	
	//SignUp
	public String JabaTalksSignUp(String name, String orgName, String singUpEmail) throws InterruptedException {
		fullName.sendKeys(name);
		organization.sendKeys(orgName);
		emailID.sendKeys(singUpEmail);
		checkBox.click();
		getStarted.click();
		Thread.sleep(2000);
		String messagee = textMessage.getText();
		return messagee;
	}
	
	//Languages drop down
	public List<WebElement> languageValidation() {
		languageDropDown.click();			
		return languages;										
	}
	
	
}
