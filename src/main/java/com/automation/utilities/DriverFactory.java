package com.automation.utilities;

import junitx.util.PropertyManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by kolodiy on 7/21/16.
 */
public class DriverFactory {

    public enum BrowserType{
        FIREFOX("firefox"),
        CHROME("chrome"),
        SAFARI("safari");

        private String value;

        BrowserType(String value){
            this.value = value;
        }

        public String getBrowserName(){
            return this.value;
        }
    }

    public static WebDriver getDriver (BrowserType type) throws Exception {

        if(PropertyManager.getProperty("USE_GRID").equalsIgnoreCase("true")){
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName(type.getBrowserName());
            desiredCapabilities.setPlatform(Platform.MAC);
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
        }

        switch(type){
            case FIREFOX:
                return new FirefoxDriver();
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
                return new ChromeDriver();
            case SAFARI:
                return new FirefoxDriver();
            default:
                return new FirefoxDriver();
        }
    }

    public static BrowserType getBrowserTypeByProperty(){
        BrowserType type = null;
        String browsername = PropertyManager.getProperty("BROWSER");
        for(BrowserType bType : BrowserType.values())
            if (bType.getBrowserName().equalsIgnoreCase(browsername))
            {
                type = bType;
                System.out.println("BROWSER = " + type.getBrowserName());
            }
        return type;
    }

}
