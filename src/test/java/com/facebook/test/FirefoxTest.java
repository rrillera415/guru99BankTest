package com.facebook.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.examples.config.GlobalDataStore;

public class FirefoxTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		basicTest();
		
	}

	public static void basicTest()
	{
		GlobalDataStore gds = new GlobalDataStore();
		gds.initParameters();
		String GeckoDriver = GlobalDataStore.GeckoDriver_MAC;
		String HomePage = GlobalDataStore.HomePage;
		System.out.println("The homepage " + HomePage);
		System.out.println("The geckoDriver " + GeckoDriver);
		//System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		System.setProperty("webdriver.gecko.driver", GeckoDriver);
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://facebook.com";
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = "";
		
		//launch firefox and direct it to base URL
		driver.get(baseUrl);
		
		actualTitle = driver.getTitle();
		actualTitle = actualTitle.trim();
		System.out.println("the actual title " + actualTitle);
		
		if(actualTitle.contentEquals(expectedTitle))
		{
			System.out.println("test passed!");
		}
		else
		{
			System.out.println("test failed!");
		}
		
		//close firefox
		driver.close();
	}
}
