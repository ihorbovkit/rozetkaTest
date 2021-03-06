package com.automation.pages;

import com.automation.BasePage;
import com.automation.utilities.MyWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.automation.utilities.DbHelper.insertRecordIntoTable;
import static com.automation.utilities.MyWaits.waitForPageLoad;

/**
 * Created by kolodiy on 7/27/16.
 */
public class RozetkaSmartphonesPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'g-tag  g-tag-icon-middle-popularity sprite')]/../../..//*[@class='g-price-uah']")
    List<WebElement> smartphonesTop_price;

    @FindBy(xpath = "//*[contains(@class, 'g-tag  g-tag-icon-middle-popularity sprite')]/../../..//*[@class='g-i-tile-i-title clearfix']")
    List<WebElement> smartphoneTop_name;

    @FindBy (xpath = ".//h1") WebElement smartphonesHeader;

    @FindBy(xpath = "//*[@id=\"sort_view\"]/div/ul/li[3]") WebElement dropdown_Top;
    @FindBy(xpath = "//*[@id=\"sort_view\"]/a") WebElement dropdown_Sort;


    public List<WebElement> getSmartphonesTop_price() {
        return smartphonesTop_price;
    }

    public List<WebElement> getSmartphoneTop_name() {
        return smartphoneTop_name;
    }


    public Map<String, String> getTopSmart() {
        return topSmart;
    }

    private Map<String, String> topSmart = new HashMap<>();



    public RozetkaSmartphonesPage(WebDriver driver)

    {
        super(driver);

    }

    public Map<String, String> putElementsToMap() {

        int i = 0;
        while (i < smartphoneTop_name.size()) {
            topSmart.put(smartphoneTop_name.get(i).getText(), smartphonesTop_price.get(i).getText());
            i++;
        }
        return topSmart;
    }

    public void writeToDb() throws SQLException {

        insertRecordIntoTable(smartphoneTop_name, smartphonesTop_price);
    }

    public void selectTopSort(){

        wait.until(MyWaits.visibilityOfElement(dropdown_Sort));
        clickElement(dropdown_Sort);
        clickElement(dropdown_Top);
        waitForPageLoad(driver);
        takeScreenshotAshot(driver);
    }
}



