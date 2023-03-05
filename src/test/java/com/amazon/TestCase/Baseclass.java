package com.amazon.TestCase;

import com.amazon.Utilities.ReadConfig;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Baseclass {

ReadConfig readConfig=new ReadConfig();

    public String baseUrl=readConfig.getapplicationUrl();
    public String emailid=readConfig.getemailid();
    public String passwrd=readConfig.getpasswrd();
    public  static WebDriver driver;
    public static Logger logger;
   

    @Parameters("browser")
	@BeforeMethod
	    public void setup(String br)
	    {
	        logger=Logger.getLogger("amazon");
	        PropertyConfigurator.configure("log4j.properties");
	if(br.equals("chrome"))
	{
	    System.setProperty("webdriver.chrome.driver", readConfig.getchromepath());
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	      else if(br.equals("Firefox"))
	        {
	            System.setProperty("webdriver.gecko.driver", readConfig.getfirefoxpath());
	            driver =new FirefoxDriver();
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	        }
	else if(br.equals("msedge"))
	{
	    System.setProperty("webdriver.msedge.driver", readConfig.getmsedgepath());
	    driver =new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	        driver.get(baseUrl);
	    }

    
	
	


}
