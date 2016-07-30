package com.automation.pages;


import com.automation.BasePage;
import com.automation.utilities.MyWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by kolodiy on 7/15/16.
 *
 *Page Object for  main page
 */
public class RozetkaMainPage extends BasePage {


    @FindBy(xpath= ".//*[@id='2']/a") WebElement link_PhoneTVMain ;




    public RozetkaMainPage(WebDriver driver){
        super(driver);
        this.PAGE_TITTLE = "Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие";
        this.PAGE_URL= "http://rozetka.com.ua/";

    }

    public void clickPhoneTVCategory(){
        wait.until(MyWaits.visibilityOfElement(link_PhoneTVMain));
        clickElement(link_PhoneTVMain);
    }

    }


