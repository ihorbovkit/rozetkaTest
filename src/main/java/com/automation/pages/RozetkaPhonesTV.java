package com.automation.pages;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by kolodiy on 7/18/16.
 */
public class RozetkaPhonesTV extends BasePage{
    public RozetkaPhonesTV(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath= "//a[@class='novisited f-menu-sub-l-i-title-first' and .='Телефоны']") WebElement link_PhoneTVCategory ;

    @FindBy (css = ".pab-h1") WebElement tittlePhoneTV;


    public void clickPhoneTVCategory(){
        clickElement(link_PhoneTVCategory);
    }

/*    public boolean checkPhoneTvTittle() {
        try {
            return tittlePhoneTV.getText().equals("Телефоны, ТВ и электроника");
        }
        catch (NoSuchElementException e)
        {
            return false;}
    }*/


}
