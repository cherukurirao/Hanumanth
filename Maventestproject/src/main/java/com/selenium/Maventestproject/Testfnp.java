package com.selenium.Maventestproject;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testfnp {
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
		 @Test
		public void diwali()
		
			{
		String st1=driver.findElement(By.xpath("//*[@id=\"navmenubar\"]/div/ul/li[2]")).getText();
		System.out.println(st1);
		}
}

