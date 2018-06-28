package com.qait.Automation.POM_HRIS_MAVEN;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {
WebDriver driver;
public Base()
{
//System.out.println(System.getProperty("user.dir"));
System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
driver = new ChromeDriver();

}


}
