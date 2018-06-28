package com.qait.Automation.POM_HRIS_MAVEN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LogInPageActions {
	WebDriver driver;

	public  LogInPageActions(WebDriver driver)
	{
		this.driver= driver;
	}


	public void userid(String username){
		driver.findElement(By.cssSelector("#txtUserName")).sendKeys(username);

	}
	public void password(String pass){
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys(pass);

	}

	public void enter() 
	{
		driver.findElement(By.cssSelector("input[type='submit']")).click();



	}
	public void clear(){

		driver.findElement(By.cssSelector("#txtUserName")).clear();
		driver.findElement(By.cssSelector("#txtPassword")).clear();
	}

	public String errorPromt()
	{
		String error=driver.findElement(By.cssSelector("div[class*='alert-error']")).getText();
		System.out.println(error);
		return error;
	}
	public String PassBoarder()
	{
		String boarder =driver.findElement(By.cssSelector("#txtPassword")).getAttribute("style");
		return boarder;
	}

	public void logInTab() {
		driver.findElement(By.cssSelector("a[href='#panel1']")).click();
		System.out.println("clicked on login tab");
	}
	public void EnterID_Pass(String username,String pass)
	{
		this.userid(username);
		this.password(pass);

	}
	public WebElement Redundency()
	{
		return driver.findElement(By.cssSelector("#txtUserName"));
	}
}
