package com.stockMarket.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class WebTablePratice {

	@Test
	public void WebTableTesting() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		//driver.get(" http://demo.guru99.com/test/web-table-element.php");
		
		driver.get("https://gaana.com/album/hindi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//*[@id="leftcontainer"]/table/tbody/tr[5]/td[4]
		//html/body/div/div[3]/div[1]/table/tbody/tr[5]/td[4]
		//*[@id="leftcontainer"]/table
//		List<WebElement>Col=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
//		System.out.println(Col.size());
//		//*[@id="leftcontainer"]/table/tbody/tr[1]/td[1]
//		List<WebElement>row=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
//		System.out.println(row.size());
//		for(int i=1;i<row.size();i++) {
//			for(int j=1;j<Col.size();j++) {
//				String S=driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
//			System.out.print(S+" ");
//			if(S.equalsIgnoreCase("Cox & Kings L")) {
//				String Cox=driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td["+j+"]//following::td")).getText();
//				System.out.println("Cox and Kings L+++ "+Cox);
//			
//			}
//			}
//			System.out.println(" ");
//		}
		String Test1=driver.findElement(By.xpath("//*[contains(text(),'Kabir Singh')]//preceding::li")).getText();
		//String Test=driver.findElement(By.xpath("//*[contains(text(),'Top Gainers')]")).getText();
	System.out.println(Test1);
	}
}
