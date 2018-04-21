package com.examples.pages;

import org.openqa.selenium.WebDriver;

public class FaceBookHomePage 
{
	WebDriver driver;
	
	public FaceBookHomePage(WebDriver driver){

        this.driver = driver;

    }
	
	public void launchHomePage(String HomePage){
		driver.get(HomePage);
		driver.manage().window().maximize();
	}
	
	public String getLoginTitle(){
		return driver.getTitle();

	}
}
