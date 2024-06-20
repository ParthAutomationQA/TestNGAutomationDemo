import BaseClasses.UIBaseTest;
import PageClasses.AmazonPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("Amazon")
public class AmazonTest extends UIBaseTest {

    @BeforeMethod(alwaysRun = true)
    @Step("Launch Browser")
    public void setUp(){
        initializeDriver("amazon");
    }

    @AfterMethod(alwaysRun = true)
    @Step("Close Browser")
    void tearDown() {
        closeDriver();
    }

    @Test
    @Step("Amazon Title Test")
    void amazonTitleTest() {
        Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    }

    @Test(dataProvider = "AuthorName-provider")
    @Step("Amazon Get Book Price Test")
    void amazonBookPriceTest(String author) {
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.openBookSection();
        amazonPage.getBookPriceByAuthorName(author);
    }

    @DataProvider(name = "AuthorName-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"Paul G. Hewitt"}, {"GERONIMO STILTON"}, {"Hanya Yanagihara"}, {"Ana Huang"}};
    }
}
