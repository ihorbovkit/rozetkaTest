package com.automation;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
        driver.get(getPAGE_URL());
        Assert.assertEquals(driver.getTitle(),getPAGE_TITTLE());

    }

    public void clickElement(WebElement element){
        element.click();

    }

    public void sendElementText (WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
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
}

