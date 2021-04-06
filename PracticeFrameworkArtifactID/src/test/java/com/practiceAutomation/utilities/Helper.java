package com.practiceAutomation.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
 
	static int tcCount=0;
	public static String captureScreenshot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath=System.getProperty("user.dir") +"\\Screenshots" + "\\Screenshot" + getCurrentDateTime() +".png";
		System.out.println("Screenshot path is " + screenShotPath);
		try {
			tcCount++;
			FileHandler.copy(src, new File(screenShotPath));
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to take screenhshot " + e.getMessage());
		}
		return screenShotPath;

	}
	
	public static String getCurrentDateTime()
	{
		DateFormat cformat=new SimpleDateFormat("MMddyy_HHmmss");
		Date currentdate=new Date();
		return cformat.format(currentdate);
	}
	public void alerts()
	{
		
	}
	
	public void frames()
	{
		
	}
	
	public void syncIssue()
	{
		
	}
	
	public void javaScriptExecutor()
	{
		
	}
	
	
}
