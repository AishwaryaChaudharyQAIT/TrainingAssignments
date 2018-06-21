package com.qait.tatoc.MavenTatocTesting;
import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class MavenTatocTestNG 
{	
	
WebDriver driver;
@BeforeTest	
public void init() 
{
System.setProperty("webdriver.chrome.driver", "C:\\Users\\AishwaryaChaudhary\\Desktop\\Aishwarya june\\chromedriver_win32\\chromedriver.exe");
driver = new ChromeDriver();
}  


@Test  
public void Step01_EnterUrl() 
{    	
driver.get("http://10.0.1.86/tatoc/basic");	   
}

@Test   

public void Step02_GridGate()  
{	
driver.findElement(By.cssSelector("a")).click();
WebElement green = driver.findElement(By.cssSelector(".greenbox"));		
green.click();   
}

@Test
 public void Step03_FRAME_DUNGEON()
 {
	WebElement mainFrame = driver.findElement(By.cssSelector("#main"));
	driver.switchTo().frame(mainFrame);
	System.out.println("User has been entered into the main frame");
	String box1 = driver.findElement(By.id("answer")).getAttribute("class");
	System.out.println("Box 1 color: " + box1);
	boolean condition = true;
	while (condition) 
	  {
		driver.findElement(By.cssSelector("a[onclick*='reload']")).click();
		WebElement rightBoxFrame = driver.findElement(By.id("child"));
		driver.switchTo().frame(rightBoxFrame);
		String box2 = driver.findElement(By.id("answer")).getAttribute("class");
		System.out.println("box 2 color: " + box2);

		if (box1.equals(box2)) 
		{
			System.out.println("matched, box 1: " + box1 + " box 2 : " + box2);
			break;
	    }
		driver.switchTo().defaultContent();
		mainFrame = driver.findElement(By.cssSelector("#main"));
		driver.switchTo().frame(mainFrame);
      }
	 driver.switchTo().defaultContent();
	 mainFrame = driver.findElement(By.cssSelector("#main"));
	 driver.switchTo().frame(mainFrame);
	 driver.findElement(By.cssSelector("a[onclick*='gonext();']")).click();

 }

@Test
public void Step04_DRAG_AROUND()
{
	//Element which needs to drag.    		
	WebElement From= driver.findElement(By.cssSelector("#dragbox"));	
 
 //Element on which need to drop.		
 WebElement To=driver.findElement(By.cssSelector("#dropbox"));		
 Actions act= new Actions(driver);
//Dragged and dropped.		
 act.dragAndDrop(From, To).build().perform();
 
 driver.findElement(By.cssSelector("a[onclick*='gonext();']")).click();

 }
@Test
public void Step05_POPUP_WINDOWS()
{
	 String mainwindow = driver.getWindowHandle();// original handle
     driver.findElement(By.cssSelector("a[onclick='launchwindow();']")).click();
    for(String nextWindow : driver.getWindowHandles() )
    {
    	driver.switchTo().window(nextWindow);
    }
    
    WebElement text= driver.findElement(By.cssSelector("#name"));
    text.sendKeys("Aishwarya");
    driver.findElement(By.cssSelector("#submit")).click();
    for(String nextWindow : driver.getWindowHandles())
    {
    	driver.switchTo().window(mainwindow);
    }
 
   driver.findElement(By.cssSelector("a[onclick*='gonext();']")).click();
 }
@Test
public void Step06_COOKIE_HANDLING()
{
	driver.findElement(By.cssSelector("a[onclick*='generateToken();']")).click();
    String TotalValue= driver.findElement(By.cssSelector("#token")).getText();
    String[] tokenValue = TotalValue.split("\\s");//Value splitted into two [0]:Token: [1]: dfsffd23hj
    String token = tokenValue[1]; 
    Cookie cookie = new Cookie("Token", token);
    driver.manage().addCookie(cookie);
    driver.findElement(By.cssSelector("a[onclick*='gonext();'")).click();

 }
@AfterTest
public void after()
{
	driver.close();
	}

}

