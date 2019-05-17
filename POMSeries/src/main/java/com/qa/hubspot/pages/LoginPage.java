package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {
	
	WebDriver driver;

	//1. Create objects of each page and create constructor of page class
		
		@FindBy(id="username")
		WebElement emailId;
		
		@FindBy(id="password")
		WebElement password;
		
		@FindBy(id="loginBtn")
		WebElement loginButton;
		
		@FindBy(linkText= "Sign Up")
		WebElement signUp;
		
		public LoginPage(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//Initialize methods
		
		public String getLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean verifySignUpLink(){
			return signUp.isDisplayed();
		}
		
		public void doLogin(String un, String pwd){
			emailId.sendKeys(un);
			password.sendKeys(pwd);
			loginButton.click();
		}
		
}
