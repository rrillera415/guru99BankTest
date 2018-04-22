package com.facebook.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;
import com.examples.pages.FaceBookHomePage;

public class TestHomePage {
	
	
	WebDriver driver = null;
	FaceBookHomePage FBPage;
	String HomePage;
	
	@Parameters({"BrowserName"})
	@BeforeClass
	public void setUp(@Optional("FireFox")String BrowserName)
	{
		GlobalDataStore gds = new GlobalDataStore();
		//String BrowserName = "chrome";
		gds.initParameters();
		String GeckoDriver = GlobalDataStore.GeckoDriver_MAC;
		String ChromeDriver = GlobalDataStore.ChromeDriver_MAC;
		String SafariDriver = GlobalDataStore.SafariDriver_MAC;
	    HomePage = GlobalDataStore.HomePage;
		//this.HomePage = HomePage;
		System.out.println("The homepage " + HomePage);
		System.out.println("The geckoDriver " + GeckoDriver);
		System.out.println("The chromeDriver " + ChromeDriver);
		
		if(BrowserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", GeckoDriver);
			driver = new FirefoxDriver();
		
		}
		else if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ChromeDriver);
			driver = new ChromeDriver();
		
		}
		else if(BrowserName.equalsIgnoreCase("safari"))
		{
			//System.setProperty("webdriver.safari.driver", SafariDriver);
			driver = new SafariDriver();
		
		}
	}
	
	@Test
	  public void testFaceBookTitleOnPageLoad() {
		  
			//String baseUrl = "http://facebook.com";
			String expectedTitle = "Facebook - Log In or Sign Up";
			String actualTitle = "";
			
			FBPage= new FaceBookHomePage(driver);
			FBPage.launchHomePage(HomePage);
		     actualTitle=FBPage.getLoginTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
	  }
	
	@Test
	@Parameters({"sUsername", "sPassword"})
	public void testUserLogin(String sUsername, String sPassword)
	{
		System.out.println("the username " + sUsername);
		System.out.println("the password " + sPassword);
		FBPage = new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		//driver.findElement(By.id("email")).sendKeys(sUsername);
		//driver.findElement(By.id("pass")).sendKeys(sPassword);
		
		//driver.findElement(By.xpath("//input[@id='email']")).sendKeys(sUsername);
		//driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(sPassword);
		//driver.findElement(By.name("email")).sendKeys(sUsername);
		//driver.findElement(By.name("pass")).sendKeys(sPassword);
		driver.findElement(By.cssSelector("#email")).sendKeys(sUsername);
		driver.findElement(By.cssSelector("#pass")).sendKeys(sUsername);
		driver.findElement(By.cssSelector("#pass")).sendKeys(sUsername);
		//driver.findElement(By.id("loginbutton")).click();
		
		
	}
	
	@Test
	public void verifyTextforCreateNewAccountOf()
	{
		FBPage = new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		WebElement element = driver.findElement(By.xpath("//h2[contains(text(), 'Sign Up')]"));
		System.out.println("the text " + element.getText());
		Assert.assertEquals(element.getText(), "Sign Up");
	}
	
	@Test
	public void verifyTextforConnectWithFriends()
	{
		FBPage = new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		WebElement element = driver.findElement(By.xpath("//h2[contains(text(), 'Connect with friends')]"));
		System.out.println("the text " + element.getText());
		Assert.assertTrue(element.getText().contains("Connect with friends"));
	
	}	
	
	@Test
	public void verifyForgotAccountLink()
	{
		FBPage = new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		WebElement element = driver.findElement(By.linkText("Forgot account?"));
		element.click();
	     String actualTitle = FBPage.getLoginTitle();
		Assert.assertEquals(actualTitle, "Forgot Password | Can't Log In | Facebook");
	
	}	
	
	@Test
	@Parameters({"sFirstName", "sLastName", "sMobileEmail", "sPasswordSignup"})
	public void testUserSignup(String sFirstName, String sLastName, String sMobileEmail, String sPasswordSignup)
	{
		FBPage = new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		WebElement element = driver.findElement(By.name("firstname"));
		element.sendKeys(sFirstName);
		element = driver.findElement(By.name("lastname"));
		element.sendKeys(sLastName);
		element = driver.findElement(By.name("reg_email__"));
		element.sendKeys(sMobileEmail);
		element = driver.findElement(By.name("reg_passwd__"));
		element.sendKeys(sPasswordSignup);
		//element = driver.findElement(By.xpath("//label[contains(text(), 'Male')]"));
		//element = driver.findElement(By.xpath("//input[@name = 'sex' and @value = 2]"));
		Select sel1 = new Select(driver.findElement(By.id("month")));
		sel1.selectByVisibleText("Sep");
		Select sel2 = new Select(driver.findElement(By.id("day")));
		sel2.selectByValue("20");
		Select sel3 = new Select(driver.findElement(By.id("year")));
		sel3.selectByIndex(36);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Male')]")));
		element.click();
		WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Create Account')]")));
		signup.click();
	
	}
	
	
	
	@AfterClass
	  public void afterClass() {
		// close Fire fox
		//driver.close();

	  }
}
