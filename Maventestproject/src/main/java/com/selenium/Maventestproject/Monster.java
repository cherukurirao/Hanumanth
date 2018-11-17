package com.selenium.Maventestproject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Monster {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest log;
	Properties prop = new Properties();
	
@BeforeTest
	public void launch1()
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
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hanumanth\\Desktop\\Selenium\\chromedriver.exe");			driver=new ChromeDriver();
		driver.get("https://my.monster.com.my/create_account.html?r=1481333332");	
		driver.manage().window().maximize();
		
	}
	@DataProvider(name = "Monster")
	public Object[][] Salutation() {
		Object[][] arrayObject = ExcelDataConfig.getExcelData(prop.getProperty("Excel"), "Sheet1");
		return arrayObject;
	}
	@AfterTest
	public void tes88()
	{
		extent.flush();
	}
public void screen()
{
	String screenshot_path = Screenshot.createScreenshot(driver);
	String image = log.addScreenCapture(screenshot_path);
}
	 @Test(dataProvider="Monster")
	public  void registration(String name,String last,String gmail, String test) throws InterruptedException, AWTException
	
		{
			//while(!isSuccessful) 	
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='firstName_id']")).sendKeys(name);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='lastName_id']")).sendKeys(last);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(gmail);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='passwd_id']")).sendKeys(name);
			Thread.sleep(2000);
			String screenshot_path = Screenshot.createScreenshot(driver);
			String image = log.addScreenCapture(screenshot_path);
			log.log(LogStatus.PASS, "Verify login Page", image);
			driver.findElement(By.xpath("//span[@id='select2-chosen-2']")).click();
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//span[@id='select2-chosen-2']")).click();
			driver.findElement(By.xpath("//ul[@id='select2-results-2']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@id='select2-chosen-1']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul[@id='select2-results-1']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='mobile2']")).sendKeys("183928821");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='expYrMonth_value']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[@for='exp_year0']//div[1]//div[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='exp_month3']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='right clip_image closedropdown']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='skills']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='skills']")).sendKeys("Testing");
			Thread.sleep(2000);
			Robot robot = new Robot();
			Thread.sleep(2000); // Thread.sleep throws InterruptedException	
	           robot.keyPress(KeyEvent.VK_DOWN);
	           Thread.sleep(2000);
	           robot.keyPress(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("//input[@id='mobile2']")).click();
	           Thread.sleep(4000);
			driver.findElement(By.xpath("//div[@id='ind_value']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='other_ind_8_val']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='right clip_image closedropdown']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='cat_value']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='other_cat_22_check']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='right clip_image closedropdown']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'ind\']")).click();
			String screenshot_path1= Screenshot.createScreenshot(driver);
			String image1 = log.addScreenCapture(screenshot_path1);
			log.log(LogStatus.PASS, "Verify Register Page", image1);
			extent.endTest(log);
			
	    	}
}
		