package com.automation.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Hello world!
 *
 */

public class App 
{
	@Test
    public void testcase()
    {

    	WebDriver driver = null;
    	
    	try {
    	
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Viraj\\eclipse-workspace\\testProject\\src\\resource\\chromedriver.exe");
    	driver = new ChromeDriver();
    	
    	String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    	driver.get(baseUrl);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		if(driver.findElements(By.xpath("//h6text()=\"Dashboard\"]")).size() != 0) {
			System.out.println("Element is Present");
		}else {
			System.out.println("Element is Absent");
		
		}
		
		System.out.println("AsserTrue");
		Assert.assertTrue(driver.findElement(By.xpath("//h6[text()=\"Dashboard\"]")).isDisplayed());
		
		Assert.assertTrue(driver.findElement(By.xpath("//h6[text()=\"DashboardOne\"]")).isDisplayed());
		
		
		/*System.out.println("AssertFalse");
		Assert.assertFalse(driver.findElement(By.xpath("//h6[text()=\"DashboardOne\"]")).isDisplayed());
		
		Assert.assertFalse(driver.findElement(By.xpath("//h6[text()=\"Dashboard\"]")).isDisplayed());	
		
		System.out.println("AssertEquals");
		Assert.assertEquals("Dashboard",driver.findElement(By.xpath("//div[@class=\"head\"]//h6")).getText());  
		
		Assert.assertEquals("DashboardOne",driver.findElement(By.xpath("//div[@class=\"head\"]//h6")).getText()); 
		
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
		WebElement element = driver.findElement(By.xpath("//h6[text()=\"DashboardOne\"]"));
		action.moveToElement(element).click().perform();*/
		
		
		driver.quit();
		
    	}catch (Exception e) {
    		// TODO: handle exception
  		  driver.quit();
  		  e.printStackTrace();
  	}
    }
}
