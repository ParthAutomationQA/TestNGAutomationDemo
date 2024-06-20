package PageClasses;

import helpers.CommonFunctions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://www.linkedin.com/
public class LinkedinPage {

    WebDriver driver;
    CommonFunctions cf;

    public LinkedinPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    public WebElement linklogin;

    @FindBy(id = "username")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonLoginSubmit;

    @Step("User Login to Linkedin using Username And Password")
    public void loginToLinkedIn(){
        linklogin.click();
        inputUsername.sendKeys("uuafhuffahfu@gmail.com");
        inputPassword.sendKeys("Test@123");
        buttonLoginSubmit.click();
    }

    @Step("Validate Error Message when user enters incorrect credentials")
    public void validateLinkedLoginErrorMessage(){
        cf = new CommonFunctions();
        cf.checkIfElementExist(driver,"//div[@id='error-for-password']");
    }

}