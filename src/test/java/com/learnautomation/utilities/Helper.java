package com.learnautomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//Screenshorts, alerts, fream, windows, sync issue, javascript executor

	
	public static String captureScreenshot(WebDriver driver)
	{
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshort=System.getProperty("user.dir")+"./Screensorts/"+ getCurrentDateTime() +".png";
		
		try {
			FileHandler.copy(src,new File(screenshort));
			
			System.out.println("Screenshot Captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture Screenshot" +e.getMessage() );
		}
		
		return screenshort;
	}
	
	public static String getCurrentDateTime() 
	{
		DateFormat customeformat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date dateformat= new Date();
		
		return customeformat.format(dateformat);		
				
}
	
}
