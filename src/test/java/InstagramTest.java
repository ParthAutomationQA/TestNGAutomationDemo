import BaseClasses.UIBaseTest;
import PageClasses.InstagramPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Meta")
@Feature("Instagram")
public class InstagramTest extends UIBaseTest {

    @BeforeMethod(alwaysRun = true)
    @Step("Launch Browser")
    public void setUp(){
        initializeDriver("instagram");
    }

    @AfterMethod(alwaysRun = true)
    @Step("Close Browser")
    void tearDown() {
        closeDriver();
    }

    @Test(groups = "Smoke1")
    @Step("Instagram Title Test")
    void instagramTitleTest() {
        Assert.assertEquals(driver.getTitle(),"Instagram");
    }

    @Test(groups = {"Insta"})
    @Step("Instagram Login Test")
    void instagramLoginTest() throws InterruptedException {
        InstagramPage instagramPage = new InstagramPage(driver);
        instagramPage.loginToInstagram();
        Thread.sleep(7000);
        instagramPage.validateInstagramErrorMessage();
    }


}
