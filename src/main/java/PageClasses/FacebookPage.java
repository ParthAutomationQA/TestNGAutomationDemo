package PageClasses;

import Util.AllureReportUtil;
import helpers.CommonFunctions;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

// page_url = https://www.facebook.com/
public class FacebookPage {

    WebDriver driver;
    CommonFunctions cf;

    public FacebookPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "email")
    private WebElement inputFaceBookEmail;

    @FindBy(id = "pass")
    private WebElement inputFacebookPass;

    @FindBy(name = "login")
    private WebElement buttonFacebookLogin;

    @Step("Login to facebook with username and password")
    public void loginToFacebook(String username, String password) throws InterruptedException {
        inputFaceBookEmail.sendKeys(username);
        inputFacebookPass.sendKeys(password);
        Thread.sleep(7000);
        buttonFacebookLogin.click();
    }

    @Step("Validate Facebook login Error Message")
    public void validateFaceBookErrorMessage(){
        cf = new CommonFunctions();
        cf.checkIfElementExist(driver,"//div[contains(text(), 'The email address you entered isn')]");
    }
}