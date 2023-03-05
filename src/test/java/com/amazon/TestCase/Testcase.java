package com.amazon.TestCase;

import com.amazon.PageObjects.AmazonLoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.annotations.VisibleForTesting;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase extends Baseclass {
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setupExtentReport()
	{
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/R5.html"); 
		htmlReporter.config().setDocumentTitle("Automation Test Report"); //Title of the report
		htmlReporter.config().setReportName("Regression Testing Report"); //Name of the report
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		 extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "DevServer");
		extent.setSystemInfo("OS", "Window 10.1");
		extent.setSystemInfo("Browser Name","Chrome");
		extent.setSystemInfo("Tester Name", "Sunil Wavale");
	}
	@AfterTest
	public void endExtentReport()
	{
		extent.flush();
	}
	

	
    @Test
    public void logintest()
    {
      extent.createTest("Demo");
        logger.info("Amazon url Opened");
        AmazonLoginPage lp=new AmazonLoginPage(driver);
        lp.setsigninclick();
        logger.info("Clicked Account Successfully");
        lp.setemail(emailid);
        logger.info("emailId Entered SuccessFully");
        lp.setAfteremail_click();
        logger.info("After Entering EmailId clicked on continue button successfully");
        lp.setPassword(passwrd);
        logger.info("Password Entered SuccessFully");
        lp.setAfterPasswrd_click();
        logger.info("After Entering Password clicked on Sign In Button succesfully");
        System.out.println("Title=="+driver.getTitle());
        String title=driver.getTitle();
        if(title.contains("Amazon.com"))
        {
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }
        else
        {
            Assert.assertTrue(false);
            logger.info("Login test failed");
        } 

    }
    @AfterMethod
   	public void tearDown(ITestResult result) throws IOException
   	{
   		if(result.getStatus() == ITestResult.FAILURE)
   		{
   			test.log(Status.FAIL,"Test Case Failed Is : " + result.getName());
   			test.log(Status.FAIL,"Test Case Failed Is : " + result.getThrowable());
   			
   			String screenshotpath = Testcase.getScreenshot(driver, result.getName());
   			test.addScreenCaptureFromPath(screenshotpath);
   		}
   		else if (result.getStatus() == ITestResult.SKIP)
   		{
   			test.log(Status.SKIP, "Test Case Skipped Is : " + result.getName());
   		}
   		else if (result.getStatus() == ITestResult.SUCCESS)
   		{
   			test.log(Status.PASS,"Test Case Passed Is : " + result.getName());
   		}
   	}
   	
   	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
   	{
   		String dateFormat = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
   		TakesScreenshot ts = (TakesScreenshot) driver;
   		File source = ts.getScreenshotAs(OutputType.FILE);
   		
   		//Create folder 'FailedTestsScreenshots' under SRC folder
   		String destination = System.getProperty("user.dir")+"/Screenshots/"+ screenshotName + dateFormat + ".png";
   		File finalDestination = new File(destination);
   		FileHandler.copy(source, finalDestination);
   		return destination;
   		
   	}
   
}
