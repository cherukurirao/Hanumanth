package com.selenium.Maventestproject;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Fnpe2eflow {
	WebDriver driver;
	Properties prop = new Properties();
	@BeforeTest()
	public void test() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hanumanth\\Desktop\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.fnp.com/");
		driver.manage().window().maximize();
		}
	@DataProvider(name = "Monster")
	public Object[][] Salutation() {
		Object[][] arrayObject = ExcelDataConfig.getExcelData(prop.getProperty("Excel"), "Sheet1");
		return arrayObject;
}
	 @Test(dataProvider="Monster")
		public  void registration(String K1,String K2,String K3, String K4) throws InterruptedException, AWTException
		
			{
		String st1=driver.findElement(By.xpath("//a[@href='#diwalimenu']")).getText();
		System.out.println("st1");
		}
}