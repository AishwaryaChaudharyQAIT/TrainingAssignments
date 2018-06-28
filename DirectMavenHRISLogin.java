package com.qait.Automation.MavenHRIS;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MavenHRISLogin

{
	WebDriver driver;

	@BeforeTest
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AishwaryaChaudhary\\Desktop\\Aishwarya june\\chromedriver_win32\\chromedriver.exe");
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
		driver.findElement(By.cssSelector("a[href='#panel1']")).click();
		WebElement loginID =driver.findElement(By.cssSelector("#txtUserName"));
		WebElement password =driver.findElement(By.cssSelector("#txtPassword"));
		WebElement submit =driver.findElement(By.cssSelector("div[class='loginTxtBtn extraText']"));
		loginID.sendKeys("aishwaryachaudhary");
		password.sendKeys("Aishwarya");
		submit.submit();
		driver.findElement(By.cssSelector("a[href='#panel1']")).click();
		//Check By detecting Error Prompt
		Assert.assertTrue(driver.findElement(By.cssSelector("#login > form > div.loginTxt.txtHideDiv.alert.alert-error > div")).getText().equals("Invalid Login"));


	}
	@Test

	public void step03_EnterNoPassword()
	{
		driver.findElement(By.cssSelector("a[href='#panel1']")).click();
		WebElement loginID =driver.findElement(By.cssSelector("#txtUserName"));
		WebElement password =driver.findElement(By.cssSelector("#txtPassword"));
		WebElement submit =driver.findElement(By.cssSelector("div[class='loginTxtBtn extraText']"));
		loginID.sendKeys("aishwaryachaudhary");
		password.sendKeys("");
		submit.submit();
		//Check by red boarder
		String Boarder =driver.findElement(By.cssSelector("#txtPassword")).getAttribute("style");
		
		Assert.assertTrue(Boarder.contains("red"));
		loginID.clear();
		password.clear();
	}
	
	@Test
	public void step04_EnterValidPassword()
	{
		driver.findElement(By.cssSelector("a[href='#panel1']")).click();
		WebElement loginID =driver.findElement(By.cssSelector("#txtUserName"));
		WebElement password =driver.findElement(By.cssSelector("#txtPassword"));
		WebElement submit =driver.findElement(By.cssSelector("div[class='loginTxtBtn extraText']"));
		loginID.sendKeys("aishwaryachaudhary");
		password.sendKeys("Aishwarya@321#");
		submit.submit();


	}
	@Test
public void step05_CheckRedundency() //throws Exception 
{
		boolean status= false;
try
{
driver.findElement(By.cssSelector("#txtUserName")).isDisplayed();

}
catch(NoSuchElementException e){  
    	  
    	  status=true;
      }


Assert.assertTrue(status);

}
	}
