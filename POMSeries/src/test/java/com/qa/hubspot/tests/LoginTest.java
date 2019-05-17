package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.commons.Constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.CommonUtil;

public class LoginTest {
	
	BasePage basePage;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url")); 
		CommonUtil.mediumWait();
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: " +title);
		Assert.assertEquals(title, Constants.LOGINPAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginPage.verifySignUpLink(), "SignUp link is not visible");
	}
	
	@Test(priority=3)
	public HomePage loginTest(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		return new HomePage();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
