package com.automation.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kolodiy on 7/22/16.
 */
public class MyWaits {
    public static ExpectedCondition<Boolean> visibilityOfElement(final WebElement element){
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                try {
                    return element.isDisplayed();
                }catch (NoSuchElementException e){
                    return false;
                } catch (StaleElementReferenceException e1){
                    return false;
                }
            }
        };
    }
    public static void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public static ExpectedCondition<Boolean> wait(final Boolean condition){
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return condition;
            }
        };
    }



}
