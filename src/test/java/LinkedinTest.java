import BaseClasses.UIBaseTest;
import PageClasses.LinkedinPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("LinkedIn")
public class LinkedinTest extends UIBaseTest {

    @BeforeMethod(alwaysRun = true)
    @Step("Launch Browser")
    public void setUp(){
        initializeDriver("linkedIn");
    }

    @AfterMethod
    @Step("Close Browser")
    void tearDown() {
        closeDriver();
    }

    @Test(groups = "Sanity")
    @Step("Launching Linkedin and validate title")
    void linkedinTitleTest() {
        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up");
    }

    @Test
    @Step("Validate Linkedin Unsuccessful Login")
    void linkedinLoginTest(){
        LinkedinPage linkedinPage = new LinkedinPage(driver);
        linkedinPage.loginToLinkedIn();
        linkedinPage.validateLinkedLoginErrorMessage();
    }
}
