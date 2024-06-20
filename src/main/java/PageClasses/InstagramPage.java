package PageClasses;

import helpers.CommonFunctions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://instagram.com
public class InstagramPage {

    WebDriver driver;
    CommonFunctions cf;
    public InstagramPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement inputInstaEmail;

    @FindBy(name = "password")
    public WebElement inputInstaPassword;

    @FindBy(xpath = "//div[text()='Log in']/parent::button")
    public WebElement btnInstLogin;

    @Step("Login to Instagram with username and password")
    public void loginToInstagram(){
        inputInstaEmail.sendKeys(System.getProperty("instusername"));
        inputInstaPassword.sendKeys(System.getProperty("instapassword"));
        btnInstLogin.click();
    }

    @Step("Validate Instagram login Error Message")
    public void validateInstagramErrorMessage(){
        cf = new CommonFunctions();
        cf.checkIfElementExist(driver,"//div[contains(text(), 'your password was incorrect')]");
    }
}