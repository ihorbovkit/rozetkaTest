package com.automation.pages;


import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by kolodiy on 7/15/16.
 *
 *Page Object for FB main page
 */
public class RozetkaMainPage extends BasePage {


    @FindBy(xpath= ".//*[@id='2']/a") WebElement link_PhoneMain ;

    @FindBy(xpath= "") WebElement link_PhoneSmartphone ;

//    @FindBy(name = "firstname") WebElement fieldFirstNameSingUp ;
//    @FindBy(name = "lastname") WebElement fieldLastNameSingUp ;
//    @FindBy(name = "reg_email__") WebElement fieldEmailSingUp ;
//    @FindBy(name = "reg_email_confirmation__") WebElement fieldEmailConfirmSingUp ;
//    @FindBy(name = "reg_passwd__") WebElement fieldPasswordSingUp ;
//
//    @FindBy(id = "month") WebElement dropdown_Month;
//    @FindBy(id = "day") WebElement dropdown_Day;
//    @FindBy(id = "year") WebElement dropdown_Year;
//
//    @FindBy(css = "span+span input[name='sex']") WebElement radio_Male;
//    @FindBy(css = "button[name='websubmit']") WebElement button_SignUp;


    public WebDriver driver;

    public RozetkaMainPage(WebDriver driver){
        super(driver);
        this.PAGE_TITTLE = "Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие";
        this.PAGE_URL= "http://rozetka.com.ua/";

    }


    public void clickPhoneCategory(){
        clickElement(link_PhoneMain);
    }
//
//    public void setText_FirstNameField(String text){
//        sendElementText(fieldFirstNameSingUp, text);
//    }
//
//    public void setText_LastNameField(String text){
//        sendElementText(fieldLastNameSingUp, text);
//    }
//
//    public void setText_EmailMobileField(String text){
//        sendElementText(fieldEmailSingUp, text);
//    }
//
//    public void setText_ReenterEmailMobileField(String text){
//        sendElementText(fieldEmailConfirmSingUp, text);
//    }
//
//    public void setText_PasswordField(String text){
//        sendElementText(fieldPasswordSingUp, text);
//    }
//    public void selectMonth(String value){
//        selectElementDropdown(dropdown_Month, value);
//    }
//
//    public void selectDay(String value){
//        selectElementDropdown(dropdown_Day, value);
//    }
//
//    public void selectYear(String value){
//        selectElementDropdown(dropdown_Year, value);
//    }
//
//    public void click_MaleRadio(){
//        clickElement(radio_Male);
//    }
//
//    public void click_SignUpButton(){
//        clickElement(button_SignUp);
//    }

//    public void login( String email, String password){
//
//        wait.until(MyWaits.visibilityOfElement(link_PhoneMain));
//        System.out.println("I WAIT");
//        wait.until(ExpectedConditions.elementToBeClickable(field_Email));
//        setText_emailField(email);
//        setText_passwordField(password);
//        clickLogin();
    }


