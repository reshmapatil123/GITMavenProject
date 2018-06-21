package com.selenium.MavenSelenium;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class ExtendReportBy {
	WebDriver driver;
	 ExtentReports extent;
	 ExtentTest test;
  @Test
  public void f() {
	  
	  
	  ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("ExtentReport.hmtl");
	  extent=new ExtentReports();
	  extent.attachReporter(htmlReporter);
	 test=extent.createTest("first test");
	  test.pass("start report");
	  
	  
	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	    test.pass("entered username");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		 test.info("entered password");
		driver.findElement(By.id("btnLogin")).click();
		 test.info("clicked on login button");
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.get("http://opensource.demo.orangehrmlive.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	  
  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
	  driver.quit();
  }

}
