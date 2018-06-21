package com.selenium.MavenSelenium;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class Logg {
	WebDriver driver;
	
    static Logger logx=Logger.getLogger(Logg.class);

	  @Test
	  public void f() {
		
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			logx.info("entered username");
		    
			driver.findElement(By.id("txtPassword")).sendKeys("admin");
			logx.info("entered password");
		
			driver.findElement(By.id("btnLogin")).click();
			logx.info("clicked on login button");
		    
		  
		 }
	  @BeforeTest
	  public void beforeTest() {
		  PropertyConfigurator.configure("resources/log4j.properties");
		  System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
		  WebDriver driver=new FirefoxDriver();
		  driver.get("http://opensource.demo.orangehrmlive.com/");
		  logx.info("opened URL");
		  driver.manage().window().maximize();
			logx.info("max");
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	  }

	  @AfterTest
	  public void afterTest() {
		  
		  driver.quit();
	  }

	}
	
	


