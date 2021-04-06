package com.practiceAutomation.pages;

import java.math.BigInteger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver1)
	{
		this.driver=driver1;
	}
	
	@FindBy(xpath="((//form)[2]/div/input)[1]") 
	WebElement mail;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement login;
	

	public void loginToFlipkart(String emailid, String pwd) 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mail.sendKeys(emailid);
		password.sendKeys(pwd);
		login.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
