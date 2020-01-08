package com.stockMarket.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.stockMarket.utilities.TestUtil;

public class CustomeListners implements ITestListener {

	public CustomeListners() {
		// TODO Auto-generated constructor stub
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}

	public void onTestFailure(ITestResult arg0) {
//		System.setProperty("org.uncommons.reportng.escape-output","false");
//		try {
//			TestUtil.caputreScreeShot();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Reporter.log("Click to see Screenshot");
//		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
//		Reporter.log("<br>");
//		Reporter.log("<br>");
//		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");
//		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
//		System.setProperty("org.uncommons.reportng.escape-output","false");
//		try {
//			TestUtil.caputreScreeShot();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Reporter.log("Click to see Screenshot");
//		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
//		Reporter.log("<br>");
//		Reporter.log("<br>");
//		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");
//		
//		
	}

}
