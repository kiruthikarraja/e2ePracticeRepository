package com.practiceAutomation.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.practiceAutomation.pages.BaseClass;
import com.practiceAutomation.pages.LoginPage;
import com.practiceAutomation.utilities.ExcelDataProvider;
import com.practiceAutomation.utilities.Helper;

public class LoginFlipkart extends BaseClass
{
	@Test
	public void login()
	{
		logger=report.createTest("Login to flipkart");
//		ExcelDataProvider excel=new ExcelDataProvider();
		LoginPage loginPageObj=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("starting application");
		
		loginPageObj.loginToFlipkart("8760017827", "Kiruthika.r17");//excel.getNumericData("Login",0,0)
		
		logger.pass("Login success");
		
		System.out.println("1st tc test method done!");
	}
	
	}
