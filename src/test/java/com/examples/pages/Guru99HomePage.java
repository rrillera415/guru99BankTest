package com.examples.pages;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.guru99.framework.Guru99WebDriverImpl;

public class Guru99HomePage {
	public static Logger logger;
	Guru99WebDriverImpl driver;
	By homePageUserName = By.xpath("//h2[@class='barone']");
	By generateAccessHeader = By.xpath("//h4[@class='barone']");
	By seleniumDropdown = By.cssSelector(".dropdown:first-of-type");
	By seleniumDropdownItem = By.cssSelector(".dropdown:first-of-type li");
	By bankProjectDropdown = By.cssSelector(".dropdown:nth-child(5)");
	By bankProjectDropdownItem = By.cssSelector(".dropdown:nth-child(5) li");
	By ajaxDemoDropdownItem = By.xpath("//a[@href='../../test/ajax.html']");
	public static  String LogCategory;
	


	public void setWebDriver(Guru99WebDriverImpl webDriver) {

		this.driver = webDriver;

	}
	
	public  void setLogCategory(String LogFile) {

        LogCategory = LogFile;

         logger = Logger.getLogger(LogCategory);//

 }
	public  void clickSeleniumDropdownOnPage(String dropdown) 
	{
		WebElement element = null;
		
		if (dropdown.equals("SeleniumDropdown"))
		{
			 element = driver.FindElement(seleniumDropdown);
		}
		else if (dropdown.equals("BankProjectDropdown"))
		{
			element = driver.FindElement(bankProjectDropdown);
		}

       driver.clickElement(element);
       logger = Logger.getLogger(LogCategory);//

 }

	public void clickSeleniumSelectElementFromDropDownOnPage(String Text) 
	{
		String Path = "//ul[@class='nav navbar-nav']/li[1]/ul//a[contains(text()," + "'" + Text + "'" + ")]";
		By checkText = By.xpath(Path);
		WebElement element = driver.FindElement(checkText);
		driver.clickElement(element);
	}
	
	public String getHomePageDashboardUserName(){
    	logger.info("START: getHomePageDashboardUserName");
      System.out.println("comming here");    
      //System.out.println(" The Text "+driver.FindElement(homePageUserName).getText());
      logger.info("END: getHomePageDashboardUserName");
         return    driver.FindElement(homePageUserName).getText();
         //return driver.getElementText(homePageUserName);
        }
	
	public String getGenerateAccessHeader(){
    	logger.info("START: getGenerateAccessHeader");
      System.out.println("comming here");    
      //System.out.println(" The Text "+driver.FindElement(homePageUserName).getText());
      logger.info("END: getGenerateAccessHeader");
         return driver.getElementText(generateAccessHeader);
         //return driver.getElementText(homePageUserName);
        }
	
	public int getItemsSeleniumDropDown(String name){
   
		 List<WebElement>  links = null;
	 	logger.info("START: getItemsSeleniumDropDown");
	      System.out.println("comming here");   
	      
		if (name.equals("SeleniumDropdownItems"))
		{
			 links = driver.findElements(seleniumDropdownItem);
		}
		else if (name.equals("BankProjectDropdownItems"))
		{
			links = driver.findElements(bankProjectDropdownItem);
		}

      for (int j = 0; j < links.size(); j++) {
          System.out.println(links.get(j).getText());
      }
      logger.info("END: getItemsSeleniumDropDown");
      return links.size();

        }

}
