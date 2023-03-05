package com.amazon.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	
	WebDriver ldriver;

    public AmazonHomePage(WebDriver rdriver)
    {
       ldriver=rdriver;
       PageFactory.initElements(rdriver,this);
    }
    

}
