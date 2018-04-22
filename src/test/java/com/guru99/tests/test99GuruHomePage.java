package com.guru99.tests;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;
import com.examples.pages.Guru99HomePage;
import com.guru99.framework.Guru99WebDriverFactory;
import com.guru99.framework.Guru99WebDriverImpl;

public class test99GuruHomePage
{
	final static Logger logger = Logger.getLogger("GURU99_TESTS");
	
	Guru99WebDriverImpl driver;
	GlobalDataStore gds = new GlobalDataStore();
	String BankHomePage;
	//Guru99LoginPage objLogin;
	Boolean HomePageLaunch = false;
	Guru99HomePage objHomePage;
	
	@Parameters({ "BrowserName" })
	@BeforeClass
	public void setUp(@Optional("FireFox") String BrowserName) throws MalformedURLException {
		logger.info("START: In set-up Method");
		GlobalDataStore.setLogCategory("GURU99_TESTS");
		gds.initParameters();
		// calls the init Method in getWebDriverInstance and gets the WebDriverImpl
		// Object driver..
		driver = Guru99WebDriverFactory.getWebDriverInstance(BrowserName);
		BankHomePage = GlobalDataStore.Guru99HomePage;
		HomePageLaunch = driver.navigateTo(BankHomePage);
		// objHomePage= new Guru99HomePage(driver);
		// driver.get("http://demo.guru99.com/V4/");
		objHomePage = new Guru99HomePage();
		objHomePage.setWebDriver(driver);
		objHomePage.setLogCategory("GURU99_TESTS");
		logger.info("END: In set-up Method");
	}
	
/*	* This Test verifies the DashBoard Page...It confirms that Page is launched successfully.
    * 
    */
   @Test
   public void test_Home_Page_DashBoard_UserName(){
   	
   	logger.info("START: test_Home_Page_DashBoard_UserName");
   	//objHomePage.setLogCategory("GURU99_TESTS");
   	
   	  if(HomePageLaunch==true){
   	
           String loginPageTitle =objHomePage.getHomePageDashboardUserName();
           logger.info(" The login Title " +loginPageTitle); 
           Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
   	  }
   	  logger.info("END: test_Home_Page_DashBoard_UserName");

  // Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
   }

   	  @Test
   	  public void test_getItemsSeleniumDropDown()
   	  {
   		logger.info("START: test_getItemsSeleniumDropDown");  
   		objHomePage.clickSeleniumDropdownOnPage("SeleniumDropdown");
   		int size = objHomePage.getItemsSeleniumDropDown("SeleniumDropdownItems");
   		Assert.assertEquals(size, 20);
   		logger.info("END: test_getItemsSeleniumDropDown");  
   	  }
   	  
   	  @Test
   	  public void test_getItemsBankProjectDropDown()
   	  {
   		logger.info("START: test_getItemsBankProjectDropDown");  
   		objHomePage.clickSeleniumDropdownOnPage("BankProjectDropdown");
   		int size = objHomePage.getItemsSeleniumDropDown("BankProjectDropdownItems");
   		Assert.assertEquals(size, 3);
   		logger.info("END: test_getItemsBankProjectDropDown");  
   	  }
   	  
 	  @Test
   	  public void test_clickAjaxDemo()
   	  {
   		logger.info("START: test_clickAjaxDemo");  
   objHomePage.clickSeleniumDropdownOnPage("SeleniumDropdown");
   objHomePage.clickSeleniumSelectElementFromDropDownOnPage("Ajax Demo");
   Assert.assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/test/ajax.html");
		logger.info("END: test_clickAjaxDemo");  
   
   	  }

   @AfterClass
   public void teardown()
   {
	   this.driver.quitDriver();
   }
   


}
