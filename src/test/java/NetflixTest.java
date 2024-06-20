import BaseClasses.UIBaseTest;
import PageClasses.NetflixPage;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.NetflixCredentialPojo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Epic("Netflix")
public class NetflixTest extends UIBaseTest {

    @BeforeMethod(alwaysRun = true)
    @Step("Launch Browser")
    public void setUp(){
        initializeDriver("netflix");
    }

    @AfterMethod(alwaysRun = true)
    @Step("Close Browser")
    void tearDown() {
        closeDriver();
    }

    @Test(groups = "Smoke")
    @Step("Netflix Title Test")
    void netflixTitleTest() {
        Assert.assertEquals(driver.getTitle(),"Netflix");
    }

    @Test(dataProvider = "netflixUsersData")
    @Step("Netflix Login Test")
    void netflixFailedLoginTest(NetflixCredentialPojo netflixCredentialPojo ) {
        NetflixPage netflixPage = new NetflixPage(driver);
        netflixPage.loginToNetflix(netflixCredentialPojo.getEmail(),netflixCredentialPojo.getPassword());
        netflixPage.verifyNetflixErrorMessage();
    }

    @DataProvider
    public Object[][] netflixUsersData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/main/resources/Data/Users_Netflix.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("credentials");
        List<NetflixCredentialPojo> testData = new Gson().fromJson(dataSet, new TypeToken<List<NetflixCredentialPojo>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}
