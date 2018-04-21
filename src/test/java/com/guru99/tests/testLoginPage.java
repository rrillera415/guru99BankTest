/*package com.guru99.tests;

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
import com.examples.pages.Guru99LoginPage;
import com.guru99.framework.Guru99WebDriverFactory;
import com.guru99.framework.Guru99WebDriverImpl;

public class testLoginPage {
final static Logger logger = Logger.getLogger("GURU99_LOGIN_TESTS");
	
	Guru99WebDriverImpl driver;
	GlobalDataStore gds = new GlobalDataStore();
	String BankHomePage;
	//Guru99LoginPage objLogin;
	Boolean HomePageLaunch = false;
	Guru99HomePage objHomePage;
	Guru99LoginPage objLoginPage;
	
	@Parameters({ "BrowserName" })
	@BeforeClass
	public void setUp(@Optional("FireFox") String BrowserName) throws MalformedURLException {
		logger.info("START: In set-up Method");
		GlobalDataStore.setLogCategory("GURU99_LOGIN_TESTS");
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
		objHomePage.setLogCategory("GURU99_LOGIN_TESTS");
		objLoginPage = new Guru99LoginPage();
		objLoginPage.setWebDriver(driver);
		objLoginPage.setLogCategory("GURU99_LOGIN_TESTS");
		logger.info("END: In set-up Method");
	}
	
	 @Test
	   public void test_loginToGuru99(){
	   	
	   	logger.info("START: test_Home_Page_DashBoard_UserName");
	   	//String loginTitle = null;
	   	driver.navigateTo(BankHomePage);
	   	objLoginPage.loginToGuru99(GlobalDataStore.UserName, GlobalDataStore.Password);
	  // 	loginTitle = objLoginPage.getTitle();
	   	  logger.info("END: test_loginToGuru99");

	  // Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

	   }
	   
	
   
   @AfterClass
   public void teardown()
   {
	   this.driver.quitDriver();
   }
   

}
*/