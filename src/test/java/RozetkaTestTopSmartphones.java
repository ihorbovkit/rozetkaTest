import com.automation.pages.RozetkaMainPage;
import com.automation.pages.RozetkaPhonesPage;
import com.automation.pages.RozetkaPhonesTVGeneralPage;
import com.automation.pages.RozetkaSmartphonesPage;
import com.automation.utilities.MyTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.SQLException;

import static com.automation.utilities.DriverFactory.getBrowserTypeByProperty;
import static com.automation.utilities.DriverFactory.getDriver;

/**
 * Created by kolodiy on 7/29/16.
 */

@Listeners(MyTestListener.class)
public class RozetkaTestTopSmartphones {

    RozetkaMainPage rozetkaMainPage;
    RozetkaPhonesTVGeneralPage rozetkaPhonesTVGeneralPage;
    RozetkaPhonesPage rozetkaPhonesPage;
    RozetkaSmartphonesPage rozetkaSmartphonesPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() throws Exception {

        this.driver = getDriver(getBrowserTypeByProperty());
        rozetkaMainPage = PageFactory.initElements(driver, RozetkaMainPage.class);
        rozetkaPhonesTVGeneralPage = PageFactory.initElements(driver, RozetkaPhonesTVGeneralPage.class);
        rozetkaPhonesPage = PageFactory.initElements(driver, RozetkaPhonesPage.class);
        rozetkaSmartphonesPage = PageFactory.initElements(driver, RozetkaSmartphonesPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }


    @Test
    public void loadPage(){
        rozetkaMainPage.loadPage();
    }

    @Test(dependsOnMethods = "loadPage")
    public void navigateToSmartphones() {
        rozetkaMainPage.clickPhoneTVCategory();
        rozetkaPhonesTVGeneralPage.clickPhoneCategory();
        rozetkaPhonesPage.clickLinkSmartphones();
        rozetkaSmartphonesPage.selectTopSort();
        Assert.assertTrue(driver.getCurrentUrl().contains("sort=popularity"));
    }
    @Test(dependsOnMethods = "navigateToSmartphones")
    public void writeTopSmartphonesToDB() throws SQLException {
        try {
            rozetkaSmartphonesPage.writeToDb();
        } catch (SQLException e) {
            Assert.fail();
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void afterSuite() {

    }

}
