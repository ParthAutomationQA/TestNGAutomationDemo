import BaseClasses.UIBaseTest;
import PageClasses.FacebookPage;
import Util.AllureReportUtil;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Epic("Meta")
@Feature("Facebook")
public class FaceBookTest extends UIBaseTest {

    @BeforeMethod(alwaysRun = true)
    @Step("Launch Browser")
    public void setUp(){
        initializeDriver("facebook");
    }

    @AfterMethod(alwaysRun = true)
    @Step("Close Browser")
    void tearDown() {
        closeDriver();
    }

    @AfterClass
    void removeParametersFromRepor(){
        try {
            AllureReportUtil.removeParametersInReport();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(groups = "Smoke")
    @Step("Facebook Test")
    void faceBookTitleTest() {
        Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");
    }

    @Test(dataProvider = "testFacebookUsers")
    void faceBookLoginTest(String username, String password) throws InterruptedException {
        FacebookPage facebookPage = new FacebookPage(driver);
        facebookPage.loginToFacebook(username,password);
        facebookPage.validateFaceBookErrorMessage();
    }

    @DataProvider(name = "testFacebookUsers")
    public Iterator<Object []> provider( ) throws InterruptedException, IOException {
        List<Object []> testCases = new ArrayList<>();
        String[] data= null;
        String csvFile = "src/main/resources/Data/Users_Facebook.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            data= line.split(cvsSplitBy);
            testCases.add(data);
        }

        return testCases.iterator();
    }
}
