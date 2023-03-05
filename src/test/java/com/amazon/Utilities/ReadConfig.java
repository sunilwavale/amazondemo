package com.amazon.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {


    Properties pro;

    public ReadConfig() {
        File src = new File("./Configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is= " + e.getMessage());
        }
    }

    public String getapplicationUrl()
    {
    String url=pro.getProperty("baseUrl");
    return url;
    }
    public String getemailid()
    {
        String emailid=pro.getProperty("emailid");
        return emailid;
    }
    public String getpasswrd()
    {
        String passwrd=pro.getProperty("passwrd");
        return passwrd;
    }
    public String getchromepath()
    {
        String chromedriverpath=pro.getProperty("chromedriverpath");
        return chromedriverpath;
    }
    public String getfirefoxpath()
    {
        String firefoxdriverpath=pro.getProperty("firefoxdriverpath");
        return firefoxdriverpath;
    }
    public String getmsedgepath()
    {
        String msedgedriverpath=pro.getProperty("msedgedriverpath");
        return msedgedriverpath;
    }

}
