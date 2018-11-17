package com.selenium.Maventestproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class fnptest 
	{
	WebDriver driver;
	Properties prop = new Properties();
	ExtentReports extent;
	ExtentTest log;
	Actions action = new Actions(driver);
	 
		@BeforeTest
	public void FNPLAUNCH()
	{
	    File file = new File("D:\\workspace\\Maventestproject\\Data.properties");
		FileInputStream fileInput = null;
		try {	
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extent=new ExtentReports("D:\\Extentreport\\Monster.html");
		log=extent.startTest("Verify monster industry feild");	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hanumanth\\Desktop\\Selenium\\chromedriver.exe");	
		driver=new ChromeDriver();
		driver.get("https://www.fnp.com/");
		driver.manage().window().maximize();

		
	}
	
	
	@DataProvider(name="menu")
	
	public Object[][] FNPdata()
	{
		Object[][] arrayObject=ExcelDataConfig.getExcelData(prop.getProperty("Excel"), "Sheet1");
		return arrayObject;
	}
	
	@Test(dataProvider = "menu")
	public void FNPPAGE(String L1, String L2, String L3, String L4, String L5, String L6, String L7, String L8,
			String L9) throws InterruptedException
	{
	try
	{
		
		String fnp1 = driver.findElement(By.xpath("//a[@href='#flowersmenu']")).getText();
		
	Thread.sleep(2000);
		System.out.println(fnp1);
		Assert.assertEquals(fnp1, L1);		
		String fnp2=driver.findElement(By.xpath("//a[@href='#cakesmenu']")).getText();
		Thread.sleep(2000);
		System.out.println(fnp2);
		Assert.assertEquals(fnp2, L2);		
		String fnp3=driver.findElement(By.xpath("//a[@href='#personalizedmenu']")).getText();
		Thread.sleep(2000);
		System.out.println(fnp3);
		Assert.assertEquals(fnp3, L3);
		String fnp4=driver.findElement(By.xpath("//a[@href='#plantsmenu']")).getText();
		Thread.sleep(2000);
		System.out.println(fnp4);
		Assert.assertEquals(fnp4, L4);		
		String fnp5=driver.findElement(By.xpath("//a[@href='#birthdaymenu']")).getText();
		Thread.sleep(2000);
		System.out.println(fnp5);
		Assert.assertEquals(fnp5, L5);		
		String fnp6=driver.findElement(By.xpath("//body[@class='ng-scope']/header[@data-ga-category='Header']/nav[@id='navmenubar']/div[@class='header-wrapper']/ul/li[6]")).getText();
		Thread.sleep(2000);
		System.out.println(fnp6);
		Assert.assertEquals(fnp6, L6);		
		String fnp7=driver.findElement(By.xpath("//body[@class='ng-scope']/header[@data-ga-category='Header']/nav[@id='navmenubar']/div[@class='header-wrapper']/ul/li[7]")).getText();
		Thread.sleep(2000);
		System.out.println(fnp7);
		Assert.assertEquals(fnp7, L7);			
		String fnp8=driver.findElement(By.xpath("//a[@href='#othergiftsmenu']")).getText();
		Thread.sleep(2000);
		System.out.println(fnp8);
		Assert.assertEquals(fnp8, L8);		
		String fnp9=driver.findElement(By.xpath("//body[@class='ng-scope']/header[@data-ga-category='Header']/nav[@id='navmenubar']/div[@class='header-wrapper']/ul/li[9]")).getText();
		Thread.sleep(2000);
		System.out.println(fnp9);
		Assert.assertEquals(fnp9, L9);			
		//String fnp10=driver.findElement(By.xpath("//*[@id=\"navmenubar\"]/div/ul/li[11]/a")).getText();
		//Thread.sleep(2000);
		//System.out.println(fnp10);
		//Assert.assertEquals(fnp10, L11);	
		
		log.log(LogStatus.INFO, "URL in Browser Launched Successfully");
		log.log(LogStatus.INFO, "ALL UI headers are verified");
		String screenshot_path = Screenshot.createScreenshot(driver);
		String image = log.addScreenCapture(screenshot_path);
		log.log(LogStatus.PASS, "Verify UI of the FNP application", image);
		
		String URL = driver.getCurrentUrl();
		log.log(LogStatus.INFO, "Current URL:" + URL + " ");
		extent.endTest(log);
		
			
	}
	
	catch (Exception e)
	{
		log.log(LogStatus.INFO, "Failed");
		String screenshot_path = Screenshot.createScreenshot(driver);
		String image = log.addScreenCapture(screenshot_path);
		log.log(LogStatus.FAIL, "Failed", image);
		String URL = driver.getCurrentUrl();
		log.log(LogStatus.INFO, "Current URL:" + URL + " ");

		extent.endTest(log);
		e.printStackTrace();
				throw e;
		
		
	}
	
	}
	
}			
	

				
		
		


