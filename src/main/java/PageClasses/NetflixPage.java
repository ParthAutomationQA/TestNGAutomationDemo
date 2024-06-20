package PageClasses;

import helpers.CommonFunctions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://netflix.com
public class NetflixPage {

    WebDriver driver;
    CommonFunctions cf;

    public NetflixPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(@href, 'youraccount')]")
    private WebElement linkAccount;

    @FindBy(name = "userLoginId")
    private WebElement inputLoginField;

    @FindBy(name = "password")
    private WebElement inputPasswordField;

    @FindBy(xpath = "//div[@data-uia='login-page-container']//button[@type='submit']")
    private WebElement btnSignIn;

    @Step("Login to Netflix using wrong username and password")
    public void loginToNetflix(String username, String password){
        linkAccount.click();
        inputLoginField.sendKeys(username);
        inputPasswordField.sendKeys(password);
        btnSignIn.click();
    }

    @Step("Verify Netflix Login Error Message")
    public void verifyNetflixErrorMessage(){
        cf = new CommonFunctions();
        cf.checkIfElementExist(driver,"//div[@data-uia='error-message-container+header']");
    }
}