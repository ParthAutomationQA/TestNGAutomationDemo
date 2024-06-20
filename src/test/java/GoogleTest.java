import BaseClasses.UIBaseTest;
import PageClasses.GooglePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("Google")
public class GoogleTest extends UIBaseTest {

    @BeforeMethod(alwaysRun = true)
    @Step("Launch Browser")
    public void setUp(){
        initializeDriver("google");
    }

    @AfterMethod(alwaysRun = true)
    @Step("Close Browser")
    void tearDown() {
        closeDriver();
    }

    @Test(groups = "Smoke")
    @Step("Google Title Test")
    void googleTitleTest() {
        Assert.assertEquals(driver.getTitle(),"Google");
    }

    @Test
    @Step("Google Search Test")
    void googleSearchTest(){
        GooglePage googlePage = new GooglePage(driver);
        googlePage.searchOnGoogle();
        googlePage.searchResultValidation();
    }
}
