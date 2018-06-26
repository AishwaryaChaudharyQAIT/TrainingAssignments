package com.qait.Automation.POM_HRIS_MAVEN;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import com.qait.Automation.POM_HRIS_MAVEN.LogIn_Page;

public class  ProjectObjectModel
{
	private static WebDriver driver;
   
      
   @BeforeTest
public void init()
{
	System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
	driver = new ChromeDriver(); 


}
@Test
public void step01_LaunchHRIS()
{
	driver.get("http://hris.qainfotech.com");
}

@Test
public void step02_EnterInvalidPassword()
{
	LogIn_Page.logInTab(driver).click();
    LogIn_Page.userid(driver).sendKeys("aishwaryachaudhary");
    LogIn_Page.password(driver).sendKeys("Aishwarya@321");
	LogIn_Page.submit(driver).submit();
	LogIn_Page.logInTab(driver).click();
	//Check By detecting Error Prompt
	Assert.assertTrue(LogIn_Page.errorPromt(driver).getText().equals("Invalid Login"));


}
@Test

public void step03_EnterNoPassword()
{
	LogIn_Page.logInTab(driver).click();
	LogIn_Page.userid(driver).sendKeys("aishwaryachaudhary");
    LogIn_Page.password(driver).sendKeys("");
    LogIn_Page.submit(driver).submit();
	//Check by red boarder
	Assert.assertTrue(LogIn_Page.PassBoarder(driver).contains("red"));
	 LogIn_Page.userid(driver).clear();
	    LogIn_Page.password(driver).clear();
}

@Test
public void step04_EnterValidPassword()
{
	LogIn_Page.logInTab(driver).click();
	
	LogIn_Page.userid(driver).sendKeys("aishwaryachaudhary");
	LogIn_Page.password(driver).sendKeys("Aishwarya@321#");
	 LogIn_Page.submit(driver).submit();


}
@Test
public void step05_CheckRedundency() //throws Exception 
{
	boolean status= false;
	try
	{
		LogIn_Page.userid(driver).isDisplayed();

	}
	catch(NoSuchElementException e){  

		status=true;
	}


	Assert.assertTrue(status);
}
}