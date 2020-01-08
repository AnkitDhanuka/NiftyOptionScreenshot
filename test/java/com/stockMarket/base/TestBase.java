package com.stockMarket.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.stockMarket.utilities.ExcelReader;



public class TestBase {


	public static WebDriver driver;

	public static Properties config= new Properties();
	public static Properties OR= new Properties();
	public static FileInputStream fis ;
	public static Logger log= Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	//public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	@BeforeSuite
	public void setUP() throws FileNotFoundException {
		if(driver==null) {
			fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			try {
				config.load(fis);
				log.debug("config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		try {
			OR.load(fis);
			log.debug("OR file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.debug("FireFox driver launched firefox browser");
		}else if(config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("Chrome driver launched Chrome browser");
		}else if(config.getProperty("broswer").equals("IE")) {
			driver = new InternetExplorerDriver();
		}

		driver.get(config.getProperty("testsiteurl"));
		log.debug("NSE Site Open for Options");
		driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		wait= new WebDriverWait(driver, 5);
		
	}

public boolean isElementPresent(By by) {
	try {
		driver.findElement(by);
		return true;
	}catch(NoSuchElementException ex){
	return false;	
	}
}
	@AfterSuite
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
	}

}
