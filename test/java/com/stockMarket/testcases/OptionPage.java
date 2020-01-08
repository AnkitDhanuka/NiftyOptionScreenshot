package com.stockMarket.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.google.common.io.Files;
import com.stockMarket.base.TestBase;
import com.stockMarket.utilities.TestUtil;
import com.sun.javafx.webkit.theme.ScrollBarThemeImpl;

public class OptionPage extends TestBase {
	public static Calendar cal = Calendar.getInstance();
	
	@Test(enabled=true)
	public void optionPageForIndexNifty() throws InterruptedException, IOException {
		Select select= new Select(driver.findElement(By.id(OR.getProperty("OptnContractDropDown"))));
		List<WebElement>allOptionsIndex=select.getOptions();
		select.selectByIndex(1);

		Select expirydate= new Select(driver.findElement(By.id(OR.getProperty("expire"))));
		List<WebElement>allOptions=	expirydate.getOptions();
		String lastThursday=TestUtil.getLastThrusdayofMonth(0);
		 final String DATE_FORMAT_NOW = "dd-MMM-yyyy";
		    Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		    String date = sdf.format(new Date());
		    if (date.compareTo(lastThursday) > 0) {
	            System.out.println("Date1 is after Date2");
	            lastThursday= TestUtil.getLastThrusdayofMonth(1);
		    }
		String datelastthursday=lastThursday.replaceAll("-", "");
		System.out.println("LastThursday :"+datelastthursday);
		//allOptions.size();
		for(int i=1;i<5;i++) {
			expirydate= new Select(driver.findElement(By.id(OR.getProperty("expire"))));
			List<WebElement>allOptions1=	expirydate.getOptions();
			System.out.println("option expiry date Size is :"+allOptions1.size()+"date"+allOptions1.get(i).getText());
			String Expiredate=allOptions1.get(i).getText();

			expirydate.selectByVisibleText(Expiredate);
			driver.findElement(By.linkText("Hide")).click();
			Thread.sleep(500);
			File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//		String Month=new SimpleDateFormat("MMM").format(cal.getTime());
			Thread.sleep(500);

			String screenshotName ="Nifty"+"_"+(cal.get(Calendar.MONTH)+1)+"_"+cal.get(Calendar.DAY_OF_MONTH)+"_"+cal.get(Calendar.HOUR_OF_DAY)+"_"+cal.get(Calendar.MINUTE) + ".png";
			System.out.println(screenshotName);
			File file = new File("D:\\Pratice\\"+datelastthursday+"\\IndexNifty\\"+Expiredate);
			if(!file.exists()) {

				file.mkdirs();
			}
//			Files.copy(scrFile,
//					new File("D:\\Pratice\\"+"Index"+"\\"+Expiredate+"\\"+screenshotName));
			FileUtils.copyFile(scrFile, new File("D:\\Pratice\\"+datelastthursday+"\\IndexNifty\\"+Expiredate+"\\"+screenshotName));
			//Shutterbug.shootPage(driver,ScrollStrategy.BOTH_DIRECTIONS,500,true).withName(screenshotName).save("D:\\Pratice\\"+"IndexNifty\\"+Expiredate+"\\");
		}
	}

	@Test(enabled=false)
	public void optionPageForIndexNiftyIT() throws InterruptedException, IOException {
		Select select= new Select(driver.findElement(By.id(OR.getProperty("OptnContractDropDown"))));
		List<WebElement>allOptionsIndex=select.getOptions();
		select.selectByIndex(2);

		Select expirydate= new Select(driver.findElement(By.id(OR.getProperty("expire"))));
		List<WebElement>allOptions=	expirydate.getOptions();
		//allOptions.size();
		String lastThursday=TestUtil.getLastThrusdayofMonth(0);
		 final String DATE_FORMAT_NOW = "dd-MMM-yyyy";
		    Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		    String date = sdf.format(new Date());
		    if (date.compareTo(lastThursday) > 0) {
	            System.out.println("Date1 is after Date2");
	            lastThursday= TestUtil.getLastThrusdayofMonth(1);
		    }
		String datelastthursday=lastThursday.replaceAll("-", "");
		System.out.println("LastThursday :"+datelastthursday);
		for(int i=1;i<allOptions.size();i++) {
			expirydate= new Select(driver.findElement(By.id(OR.getProperty("expire"))));
			List<WebElement>allOptions1=	expirydate.getOptions();
			System.out.println("option expiry date Size is :"+allOptions1.size()+"date"+allOptions1.get(i).getText());
			String Expiredate=allOptions1.get(i).getText();

			expirydate.selectByVisibleText(Expiredate);
			Thread.sleep(500);
			File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//		String Month=new SimpleDateFormat("MMM").format(cal.getTime());
			Thread.sleep(500);

			String screenshotName ="NiftyIT"+"_"+(cal.get(Calendar.MONTH)+1)+"_"+cal.get(Calendar.DAY_OF_MONTH)+"_"+cal.get(Calendar.HOUR_OF_DAY)+"_"+cal.get(Calendar.MINUTE) + ".png";
			System.out.println(screenshotName);
			File file = new File("D:\\Pratice\\IndexNIFTYIT\\"+Expiredate);
			if(!file.exists()) {

				file.mkdirs();
			}
//			Files.copy(scrFile,
//					new File("D:\\Pratice\\"+"Index"+"\\"+Expiredate+"\\"+screenshotName));
			FileUtils.copyFile(scrFile, new File("D:\\Pratice\\"+datelastthursday+"\\IndexNIFTYIT\\"+Expiredate+"\\"+screenshotName));
			//Shutterbug.shootPage(driver,ScrollStrategy.BOTH_DIRECTIONS,500,true).withName(screenshotName).save("D:\\Pratice\\"+datelastthursday+"\\IndexNIFTYIT\\"+Expiredate+"\\");
		}
	}
	@Test(enabled=true)
	public void optionPageForIndexBANKNIFTY() throws InterruptedException, IOException {
		Select select= new Select(driver.findElement(By.id(OR.getProperty("OptnContractDropDown"))));
		List<WebElement>allOptionsIndex=select.getOptions();
		select.selectByIndex(3);

		Select expirydate= new Select(driver.findElement(By.id(OR.getProperty("expire"))));
		List<WebElement>allOptions=	expirydate.getOptions();
		String lastThursday=TestUtil.getLastThrusdayofMonth(0);
		
		 final String DATE_FORMAT_NOW = "dd-MMM-yyyy";
		    Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		    String date = sdf.format(new Date());
		    if (date.compareTo(lastThursday) > 0) {
	            System.out.println("Date1 is after Date2");
	            lastThursday= TestUtil.getLastThrusdayofMonth(1);
		    }
		String datelastthursday=lastThursday.replaceAll("-", "");
		System.out.println("LastThursday :"+datelastthursday);
		//allOptions.size();
		for(int i=1;i<5;i++) {
			expirydate= new Select(driver.findElement(By.id(OR.getProperty("expire"))));
			List<WebElement>allOptions1=	expirydate.getOptions();
			System.out.println("option expiry date Size is :"+allOptions1.size()+"date"+allOptions1.get(i).getText());
			String Expiredate=allOptions1.get(i).getText();

			expirydate.selectByVisibleText(Expiredate);
			driver.findElement(By.linkText("Hide")).click();
			Thread.sleep(500);
			File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//		String Month=new SimpleDateFormat("MMM").format(cal.getTime());
			Thread.sleep(500);

			String screenshotName ="BANKNIFTY"+"_"+(cal.get(Calendar.MONTH)+1)+"_"+cal.get(Calendar.DAY_OF_MONTH)+"_"+cal.get(Calendar.HOUR_OF_DAY)+"_"+cal.get(Calendar.MINUTE) + ".png";
			System.out.println(screenshotName);
			File file = new File("D:\\Pratice\\"+datelastthursday+"\\IndexBANKNIFTY\\"+Expiredate);
			if(!file.exists()) {

				file.mkdirs();
			}
//			Files.copy(scrFile,
//					new File("D:\\Pratice\\"+"Index"+"\\"+Expiredate+"\\"+screenshotName));
			FileUtils.copyFile(scrFile, new File("D:\\Pratice\\"+datelastthursday+"\\IndexBANKNIFTY\\"+Expiredate+"\\"+screenshotName));
			//Shutterbug.shootPage(driver,ScrollStrategy.BOTH_DIRECTIONS,500,true).withName(screenshotName).save("D:\\Pratice\\"+datelastthursday+"\\IndexBANKNIFTY\\"+Expiredate+"\\");
		}
	}


	//		log.debug("Option Page opened successfully");
	//		Reporter.log("Option Page opened successfully");
	//		Reporter.log("<a target=\"_blank\" href=\"D:\\OptionChainScreenshot\\Apr\\ADANIPORTS\\ADANIPORTS_7-32.png\">Screenshot</a>");


	@Test(dataProvider="getData",enabled=true)
		public void addStocks(String StockName,String ExpireDate) throws InterruptedException, IOException {
			
			
			driver.findElement(By.id(OR.getProperty("searchText"))).clear();
			driver.findElement(By.id(OR.getProperty("searchText"))).sendKeys(StockName);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			String lastThursday=TestUtil.getLastThrusdayofMonth(0);
			 final String DATE_FORMAT_NOW = "dd-MMM-yyyy";
			    Calendar cal = Calendar.getInstance();
			    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			    String date = sdf.format(new Date());
			    if (date.compareTo(lastThursday) > 0) {
		            System.out.println("Date1 is after Date2");
		            lastThursday= TestUtil.getLastThrusdayofMonth(1);
			    }
//		        } else if (date.compareTo(lastThursday) < 0) {
//		            System.out.println("Date1 is before Date2");
//		        } else if (date.compareTo(lastThursday) == 0) {
//		            System.out.println("Date1 is equal to Date2");
//		        }
			    System.out.println(date);
			String datelastthursday=lastThursday.replaceAll("-", "");
			System.out.println("LastThursday :"+datelastthursday);
			driver.findElement(By.xpath(("//input[contains(@src,'"+OR.getProperty("gobutton")+"')]"))).click();
	
			Select expirydate= new Select(driver.findElement(By.id(OR.getProperty("expire"))));
			List<WebElement>allOptions=	expirydate.getOptions();
			//allOptions.size();
			for(int i=1;i<=1;i++) {
				System.out.println("option expiry date Size is :"+allOptions.size()+"date"+allOptions.get(i).getText());
				String Expiredate=allOptions.get(i).getText();
	
				expirydate.selectByVisibleText(Expiredate);
				driver.findElement(By.linkText("Hide")).click();
				Thread.sleep(500);
				File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				//		String Month=new SimpleDateFormat("MMM").format(cal.getTime());
				Thread.sleep(500);
				
				File file = new File("D:\\Pratice\\"+datelastthursday+"\\Nifty50Stocks\\"+StockName);
				System.out.println("D:\\Pratice\\"+datelastthursday+"\\Nifty50Stocks\\"+StockName);
				if(!file.exists()) {
	
					file.mkdirs();
				}
				String screenshotName = StockName+"_"+(cal.get(Calendar.MONTH)+1)+"_"+cal.get(Calendar.DAY_OF_MONTH)+"_"+cal.get(Calendar.HOUR_OF_DAY)+"_"+cal.get(Calendar.MINUTE) + ".png";
				System.out.println(screenshotName);
//				Files.copy(scrFile,
//						new File("D:\\Pratice\\"+Expiredate+"\\"+StockName+"\\"+screenshotName));
				
				//js.executeScript("window.scrollBy(0,1000)");
				//Shutterbug.shootPage(driver,ScrollStrategy.VERTICALLY,3000,true).withName(screenshotName).save("D:\\Pratice\\"+datelastthursday+"\\Nifty50Stocks\\"+StockName+"\\");
				
				FileUtils.copyFile(scrFile, new File("D:\\Pratice\\"+datelastthursday+"\\Nifty50Stocks\\"+StockName+"\\"+screenshotName));
	
			}
		}
	@DataProvider
	public Object[][] getData(){
		String sheetName="OptionPage";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data= new Object[rows-1][cols];

		for(int rowNum=2;rowNum<=rows;rowNum++) {
			for(int colNum=0;colNum<cols;colNum++) {
				data[rowNum-2][colNum]=excel.getCellData(sheetName,colNum,rowNum);
			}
		}
		return data;}
}
