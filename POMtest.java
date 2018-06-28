package com.qait.Automation.POM_HRIS_MAVEN;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qait.Automation.POM_HRIS_MAVEN.LogInPageActions;

public class  ProjectObjectModel extends Base {

	LogInPageActions loginPage;

	//	@BeforeTest
	//	public void init()
	//	{
	//		System.out.println(System.getProperty("user.dir"));
	//		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
	//		driver = new ChromeDriver();
	//		loginPage  = new LogInPageActions(driver);
	//	}
	@BeforeTest
	public void init()
	{

		loginPage = new LogInPageActions(driver);
	}



	@Test
	public void Step01_Launch_Application() {
		driver.get("http://hris.qainfotech.com");
	}

	@Test
	public void step02_EnterInvalidPassword() {
		loginPage.logInTab();
		loginPage.EnterID_Pass("aishwaryachaudhary", "Aishwarya@321");
		loginPage.enter();
		loginPage.logInTab();
		Assert.assertTrue(loginPage.errorPromt().equals("Invalid Login"));
	}
	@Test
	public void step03_EnterNoPassword() 
	{
		loginPage.logInTab();
		loginPage.EnterID_Pass("aishwaryachaudhary", "");
		loginPage.enter();
		
		Assert.assertTrue(loginPage.PassBoarder().contains("red"));
		loginPage.clear();

	}

	@Test
	public void step04_EnterValidPassword() 
	{
		loginPage.logInTab();
		loginPage.EnterID_Pass("aishwaryachaudhary", "Aishwarya@321#");
		loginPage.enter();
	}
	@Test
	public void step05_CheckRedundency() //throws Exception 
	{
		boolean status= false;
		try
		{
			loginPage.Redundency().isDisplayed();

		}
		catch(NoSuchElementException e){  

			status=true;
		}


		Assert.assertTrue(status);
	}
}
