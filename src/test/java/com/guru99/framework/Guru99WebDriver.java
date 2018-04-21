package com.guru99.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Guru99WebDriver 
{
	void init(String Browser);
	Boolean navigateTo(final String relativeURL);
	WebElement FindElement(By element);
	void quitDriver();
	void clickElement(WebElement element);
	List<WebElement> findElements(By element);


	
}
