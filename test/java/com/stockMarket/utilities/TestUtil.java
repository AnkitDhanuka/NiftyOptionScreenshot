package com.stockMarket.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.stockMarket.base.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ShootingStrategy;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestUtil extends TestBase {
	public static String screenshotPath;
	public static Calendar cal = Calendar.getInstance();
	public static String screenshotName;
	public static void caputreScreeShot() throws IOException {
		String sheetName="OptionPage";
		int rows = excel.getRowCount(sheetName);
		System.out.println("Rows"+rows);
		int cols = excel.getColumnCount(sheetName);
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Month=new SimpleDateFormat("MMM").format(cal.getTime());
		
		
		for(int rowNum=1;rowNum<=rows;rowNum++) {
			
				screenshotName = excel.sheet.getRow(rowNum).getCell(0)+"_"+cal.get(Calendar.HOUR_OF_DAY)+"_"+cal.get(Calendar.MINUTE) + ".jpg";
				System.out.println(screenshotName);
				File file = new File(System.getProperty("user.dir") +"\\src\\test\\resources\\"+Month+"\\"+excel.sheet.getRow(rowNum).getCell(0));
				if(!file.exists()) {
					file.mkdir();
				}
			Files.copy(scrFile,
						new File(System.getProperty("user.dir") +"\\src\\test\\resources\\"+Month+"\\"+excel.sheet.getRow(rowNum).getCell(0)));
				//File targetfile= new File("D:\\Pratice\\"+Month+"\\"+excel.sheet.getRow(rowNum).getCell(0) + screenshotName);
		}
//		screenshotName = excel.sheet.getRow(rows).getCell(0)+"_"+cal.get(Calendar.HOUR_OF_DAY)+"_"+cal.get(Calendar.MINUTE) + ".jpg";
//		File file = new File("C:"+Month+"\\"+excel.sheet.getRow(rows).getCell(0));
//		if(!file.exists()) {
//			file.mkdir();
//		}
		
//		Screenshot fpScreenshot = new AShot().shootingStrategy((ShootingStrategy) ShootingStrategies.viewportPasting(1500)).takeScreenshot(driver);
//		ImageIO.write(fpScreenshot.getImage(),"PNG",targetfile);
	}
	 public static Calendar getLastThrusday(Calendar cal, int offset) {
		    int dayofweek;
		    cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + offset);
		    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		    dayofweek = cal.get(Calendar.DAY_OF_WEEK); 
		    if (dayofweek < Calendar.THURSDAY) 
		      cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 7
		          + Calendar.THURSDAY - dayofweek);
		    else
		      cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)
		          + Calendar.THURSDAY - dayofweek);

		    return cal;
		  }

		  public static String getLastThrusdayofMonth(int offset) { 
		    final String DATE_FORMAT_NOW = "dd-MMM-yyyy";
		    Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		    cal = getLastThrusday(cal, offset);
		    return sdf.format(cal.getTime());
		  }

		 
}
