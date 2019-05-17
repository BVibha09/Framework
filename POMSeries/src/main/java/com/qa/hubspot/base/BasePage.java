package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver initialize_driver(Properties prop){
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:/ECLIPSE/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:/ECLIPSE/chromedriver_win32/geckodriver.exe");
		driver = new FirefoxDriver();
		}
		else {
			System.out.println("Browser not found");
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		if(prop.getProperty("fullscreen").equals("yes")) {
			driver.manage().window().fullscreen();
		}
		
		return driver;
	}
	
	public Properties initialize_properties(){
		
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("C:/ECLIPSE/POMSeries/src/main/java/com/qa/hubspot/configuration/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return prop;	
	}
}
