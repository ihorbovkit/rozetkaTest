package com.automation.pages;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by kolodiy on 7/18/16.
 */

public class RozetkaPhonesPage extends BasePage {
    public RozetkaPhonesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = ".//*[@id='menu_categories_left']/li[1]/h4") WebElement link_Smartphones;

    public void clickLinkSmartphones(){
        clickElement(link_Smartphones);
    }
}
