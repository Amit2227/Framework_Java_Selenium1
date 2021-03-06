package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class BaseClass {
	
public WebDriver driver;
public ExcelDataProvider excel;
public ConfigDataProvider config;
public ExtentReports report;
public ExtentTest logger;


	@BeforeSuite
	public void setUpSuite()
	
	{
		Reporter.log("Setting up reports and Test is getting ready", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/PHPTravels_"+Helper.getCurrentDateTime() +".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Down - Test Can be started", true);
	}
	
	@BeforeClass 
	public void setup()
	{
		Reporter.log("Tring to start Browser and Getting application ready", true);
		
		driver = BrowserFactory.startApplication(driver, config.getBrowser(),config.getStringURL());
		
		Reporter.log("Broswer and application is up and runing", true);
	}
	
	@AfterClass
	public void tearDown()
	{
		
		Reporter.log("Test is about to end", true);
		
		System.out.println("Sucesfully script run");
		BrowserFactory.quitBrowser(driver);
		
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		
		Reporter.log("Test is about to end", true);
		
		try {
			if(result.getStatus()==ITestResult.FAILURE)
			{
				//Helper.captureScreenshot(driver);
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			}
			else if(result.getStatus()==ITestResult.SUCCESS)
			{
				logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			}
			
			else if(result.getStatus()==ITestResult.SKIP)
			{
				logger.skip("Test skiped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reporter.log("Test Completed >>> Reports Genrated", true);
		report.flush();
	}
	

}
