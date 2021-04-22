package com.practiceAutomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentReporter;
import com.practiceAutomation.utilities.*;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite()
	{
		Reporter.log("Setting up reports and starting before suite", true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		String reportPath=System.getProperty("user.dir") +"\\Reports" + "\\Report" + Helper.getCurrentDateTime() +".html";

		System.out.println("Report path -" + reportPath);
		ExtentHtmlReporter extent =new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"\\Reports" + "\\Report"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting up reports DONE and before suite done", true);
	}
	
	@Parameters({"browser","practiceURL"})
	@BeforeClass
	public void setup(String browser,String practiceURL)
	{
		Reporter.log("Setting up browser and starting before class", true);

		//driver=BrowserFactory.startBrowser(driver, config.getBrowserFromPropFile(), config.getURLFromPropFile());
		
		driver=BrowserFactory.startBrowser(driver, browser, practiceURL);
		System.out.println("driver done!");
	
		Reporter.log("Setting up browser DONE and before class done", true);

	}
	
	@AfterClass
	public void teardown()
	{
		BrowserFactory.quitBrowser(driver);
		System.out.println("Browser quit successfully.");
	}
	@AfterMethod(alwaysRun = true)
	public void teardownMethod(ITestResult result)
	{		

		if (result.getStatus()==ITestResult.SUCCESS)
		{		
		try {
			logger.pass("Test Passed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			System.out.println("Report generated success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		else if (result.getStatus()==ITestResult.FAILURE)
		{		
		try {
			logger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			System.out.println("Report generated failed case");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		report.flush();
		System.out.println("Report output is " + Reporter.getOutput());

		Reporter.log("Test completed >>>> Reports generated", true);
	}

}
