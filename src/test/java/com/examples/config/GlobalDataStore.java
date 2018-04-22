package com.examples.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class GlobalDataStore {
	


	public static String Guru99HomePage;
	public static String ChromeDriver_WIN;
	public static String GeckoDriver_WIN;
	private Properties configFile= new Properties();
	public static String GeckoDriver_MAC;
	public static String ChromeDriver_MAC;
	public static String SafariDriver_MAC;
	//public static String GeckoDriver_WIN;
	public static String HomePage;
	public String Password;
	public static  String LogCategory;
	public static Logger logger;
	public String UserName;
	
	public static void setLogCategory(String logFile) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
        LogCategory = logFile;

        logger = Logger.getLogger(LogCategory);//
	}

	public void initParameters()
	{
		logger.info("START:Global Data Store initParameters Method");
	String baseDir= System.getProperty("user.dir");
	
	String propFile="selenium.properties";
	FileInputStream fis = null;
	
	
	try{
		
		///Users/srinivasnayani/Documents/SQAToolsAutomation/SQASeleniumProject/src/test/resources/selelium.properties
		fis=new FileInputStream(baseDir+ "/" +"src/test/resources/" +propFile);			
	    configFile.load(fis);
		
	    GeckoDriver_MAC = configFile.getProperty("GECKO_DRIVER_MAC");
	    ChromeDriver_MAC = configFile.getProperty("CHROME_DRIVER_MAC");
	    SafariDriver_MAC = configFile.getProperty("SAFARI_DRIVER_MAC");
	    
	    //logger.info("GeckoDriver_MAC Value " +GeckoDriver_MAC);
	   // GeckoDriver_WIN=configFile.getProperty("GECKO_DRIVER_WIN");
	    Guru99HomePage=configFile.getProperty("GURU99_HOMEPAGE");
	    UserName = configFile.getProperty("USERNAME");
	    Password= configFile.getProperty("PASSWORD");
	
	}catch(FileNotFoundException e){
    	
		System.out.println("File not Found" +e.getMessage());
		
	    }catch(IOException e){
	    	
		System.out.println("IO Exception " +e.getMessage());
		
	 }
		logger.info("END:Global Data Store initParameters Method");
	}






}
