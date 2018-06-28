package com.qait.Automation.POM_HRIS_MAVEN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn_Page {
	private static WebElement element = null;
	public static WebElement userid(WebDriver driver){
		WebElement element=driver.findElement(By.cssSelector("#txtUserName"));
		return element;
	}
	public static WebElement password(WebDriver driver){
		WebElement element =driver.findElement(By.cssSelector("#txtPassword"));
		return element;
	}
public static WebElement logInTab(WebDriver driver){
	WebElement element=driver.findElement(By.cssSelector("a[href='#panel1']")); 
return element;
}
public static WebElement submit(WebDriver driver)
{
	WebElement element =driver.findElement(By.cssSelector("div[class='loginTxtBtn extraText']"));
	return element;

}
public static WebElement errorPromt(WebDriver driver)
{
	WebElement element=driver.findElement(By.cssSelector("#login > form > div.loginTxt.txtHideDiv.alert.alert-error > div"));
	return element;
}
public static String PassBoarder(WebDriver driver)
{
	String element =driver.findElement(By.cssSelector("#txtPassword")).getAttribute("style");
	return element;
}
}
