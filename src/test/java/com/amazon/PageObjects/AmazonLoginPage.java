package com.amazon.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {
    WebDriver ldriver;

    public AmazonLoginPage(WebDriver rdriver)
    {
       ldriver=rdriver;
       PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath="//span[@class='nav-line-2 ']")
    @CacheLookup
    WebElement signinclick;
    @FindBy(xpath="//input[@type='email']")
    @CacheLookup
    WebElement email;

    @FindBy(xpath="//input[@id='continue']")
    @CacheLookup
    WebElement afteremail_click;

    @FindBy(xpath="//input[@type='password']")
    @CacheLookup
    WebElement password;

    @FindBy(xpath="//input[@id='signInSubmit']")
    @CacheLookup
    WebElement afterPasswrd_click;

    public void setsigninclick()
    {
        signinclick.click();
    }
    public void setemail(String uemail)
    {
        email.sendKeys(uemail);
    }
public void setAfteremail_click()
{
    afteremail_click.click();
}
public void setPassword(String upass)
{
    password.sendKeys(upass);
}

public void setAfterPasswrd_click()
{
    afterPasswrd_click.click();
}

}
