package com.automation.testProject;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.automation.utility.Log;

public class TestOne {
	
	//Logger log = Logger.getLogger("devpinoyLogger");
	
  @Test
  public void f() throws Exception {
	  WebDriver driver =null;
	  
	  Logger log = Logger.getLogger("devpinoyLogger");
	  try {
	  
	  	System.setProperty("webdriver.chrome.driver","C:\\Users\\Viraj\\eclipse-workspace\\testProject\\src\\resource\\chromedriver.exe");
	  	driver = new ChromeDriver();
		
		DOMConfigurator.configure("log4j.xml");
		//Logger log = Logger.getLogger("devpinoyLogger");

		Log.startTestCase("Selenium_Test_001");
		log.debug("opening webiste");	
		
		String baseUrl = "https://opensource-demo.orangehrmlive.com/";
		Log.info("Open URL");
		Reporter.log("Open URL");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		
		if(driver.findElements(By.xpath("//h1[text()=\"Dashboard\"]")).size() != 0) {
			//System.out.println("Element is Present");
			Log.info("Element is Present");
			Reporter.log("Element is Present");
		}else {
			//System.out.println("Element is Absent");
			Log.info("Element is Absent");
			Reporter.log("Element is Absent");
		}
		
		System.out.println("AsserTrue");
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()=\"Dashboard\"]")).isDisplayed());
		
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()=\"DashboardOne\"]")).isDisplayed());
		
		
		/*System.out.println("AssertFalse");
		Assert.assertFalse(driver.findElement(By.xpath("//h1[text()=\"DashboardOne\"]")).isDisplayed());
		
		Assert.assertFalse(driver.findElement(By.xpath("//h1[text()=\"Dashboard\"]")).isDisplayed());	
		
		System.out.println("AssertEquals");
		Assert.assertEquals("Dashboard",driver.findElement(By.xpath("//div[@class=\"head\"]//h1")).getText());  
		
		Assert.assertEquals("DashboardOne",driver.findElement(By.xpath("//div[@class=\"head\"]//h1")).getText()); 
		
		System.out.println("AssertNotEquals");
		Assert.assertNotEquals("Hello", "How are you"); 
		
		 Assert.assertNotEquals("Hello", "Hello");  
		
		System.out.println("AssertNull");
		Assert.assertNull(null);
		Assert.assertNull(10);
		
		System.out.println("AssertNotNull");
		Assert.assertNotNull(10);
		Assert.assertNotNull(null);
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//h1[text()=\"DashboardOne\"]"));
		action.moveToElement(element).click().perform();*/
		
		
		driver.quit();
	  }catch (Exception e) {
		// TODO: handle exception
		  driver.quit();
		  e.printStackTrace();
	}
		
  }
}
