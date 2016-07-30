package com.automation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static com.automation.utilities.DbHelper.getCurrentTimeStamp;

/**
 * Created by kolodiy on 7/19/16.
 */

public class BasePage {
    public WebDriver driver;
    public String PAGE_URL;
    public String PAGE_TITTLE;
    public WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait= new WebDriverWait(driver,10);
    }

    public void loadPage(){
        driver.manage().window().maximize();
        driver.get(getPAGE_URL());
        Assert.assertEquals(driver.getTitle(),getPAGE_TITTLE());

    }

    public void clickElement(WebElement element){
        element.click();

    }

    public void selectElementDropdown(WebElement dropdown, String value){
        Select select= new Select(dropdown);
        select.selectByValue(value);
    }

    public String getPAGE_URL() {
        return PAGE_URL;
    }

    public String getPAGE_TITTLE() {
        return PAGE_TITTLE;
    }

    boolean checkElementPresent(WebElement element){
        try{
            element.getTagName();
            return true;
        }
        catch (NoSuchElementException e){
        return false;}

    }
    public static void takeScreenshot(WebDriver driver)
    {

        System.out.println("Taking the screenshot.");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
        try {
            FileUtils.copyFile(scrFile, new File("screenshot_topSmartphones_" +getCurrentTimeStamp().toString()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return scrFile;
    }    public static void takeScreenshotAshot(WebDriver driver)
    {

        System.out.println("Taking the screenshot.");
        Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File("screenshot_topSmartphones_" +getCurrentTimeStamp().toString()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return scrFile;
    }
}

