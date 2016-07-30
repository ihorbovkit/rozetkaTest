package com.automation.pages;

import com.automation.BasePage;
import com.automation.utilities.MyWaits;
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

    @FindBy(xpath= ".//*[@id='menu_categories_left']/li[1]/h4/a") WebElement link_PhoneCategory ;

    @FindBy (css = ".pab-h1") WebElement tittlePhoneTV;


    public void clickPhoneCategory(){
        wait.until(MyWaits.visibilityOfElement(link_PhoneCategory));
        clickElement(link_PhoneCategory);
    }

}
