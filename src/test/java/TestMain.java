import com.automation.pages.RozetkaSmartphonesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.automation.utilities.DbHelper.insertRecordIntoTable;

/**
 * Created by kolodiy on 7/22/16.
 */


public class TestMain  {


    public static void main(String args[]) {
        RozetkaSmartphonesPage smartPage;

        WebDriver driver;
        driver = new FirefoxDriver();
        driver.get("http://rozetka.com.ua/mobile-phones/c80003/filter/preset=smartfon;sort=popularity/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        smartPage= PageFactory.initElements(driver, RozetkaSmartphonesPage.class);
        smartPage.putElementsToMap();

        for (Map.Entry<String, String> entry : smartPage.getTopSmart().entrySet()) {
            System.out.println(entry);
        }
        try {
            insertRecordIntoTable(smartPage.getSmartphoneTop_name(), smartPage.getSmartphonesTop_price());
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        System.out.println (smartPage.getTopSmart().entrySet() );
        //div[contains (@class, 'g-price-uah')]
        //div[contains (@class, 'g-i-tile g-i-tile-catalog')][.//i[@class="g-tag g-tag-icon-middle-popularity sprite"]]
        System.out.println("args = [" + args + "]");



    }

}

