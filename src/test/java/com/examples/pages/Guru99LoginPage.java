	package com.examples.pages;


	import org.apache.log4j.Logger;
	import org.openqa.selenium.By;
	import com.guru99.framework.Guru99WebDriverImpl;

public class Guru99LoginPage {



		public static Logger logger;
		Guru99WebDriverImpl driver;
		By userTextBox = By.name("uid");
		By passwordTextBox = By.name("password");
		By loginButton = By.name("btnLogin");
		public static  String LogCategory;
		


		public void setWebDriver(Guru99WebDriverImpl webDriver) {

			this.driver = webDriver;

		}
		
		public  void setLogCategory(String LogFile) {

	        LogCategory = LogFile;

	         logger = Logger.getLogger(LogCategory);//

	 }
		
		public void loginToGuru99(String strUsername, String strPassword){
	    	logger.info("START: Login");
	      this.setUserName(strUsername);
	      this.setPassword(strPassword);
	      this.clickLogin();
	      logger.info("END: Login");
	     
	        }

		private void clickLogin() {
			// TODO Auto-generated method stub
			driver.FindElement(loginButton).click();
			
		}

		private void setPassword(String strPassword) {
			// TODO Auto-generated method stub
			driver.sendKeys(driver.FindElement(passwordTextBox), strPassword);
		}

		private void setUserName(String strUsername) {
	
			driver.sendKeys(driver.FindElement(userTextBox), strUsername);
		}

		public String getTitle() {
			// TODO Auto-generated method stub
			return null;
		}

	}

