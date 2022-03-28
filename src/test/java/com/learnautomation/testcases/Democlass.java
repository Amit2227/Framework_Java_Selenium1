package com.learnautomation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Democlass {
	
	
	@Test
public void  Test1()
{

	System.setProperty("webdriver.chrome.driver","D:\\Selenium_java\\Java_Demo_API\\Framework_Java_Selenium\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	driver.manage().window().maximize();
	
	driver.findElement(By.name("login")).sendKeys("amit12shri@rediffmail.com");
	driver.findElement(By.name("passwd")).sendKeys("Gargi@0709#");
	driver.findElement(By.xpath("//input[@class='signinbtn']")).click();
	
	System.out.println("Browser Open");
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	String title=driver.getTitle();
	System.out.println(title);
	
	driver.quit();
	
	

}

}
