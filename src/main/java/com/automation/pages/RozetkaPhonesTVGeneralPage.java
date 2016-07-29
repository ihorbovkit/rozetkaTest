package com.automation.pages;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by kolodiy on 7/18/16.
 */
public class RozetkaPhonesTVGeneralPage extends BasePage{
    public RozetkaPhonesTVGeneralPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath= "//a[@class='novisited f-menu-sub-l-i-title-first' and .='Телефоны']") WebElement link_PhoneCategory ;

    @FindBy (css = ".pab-h1") WebElement tittlePhoneTV;


    public void clickPhoneCategory(){
        clickElement(link_PhoneCategory);
    }

}
