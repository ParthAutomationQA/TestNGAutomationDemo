package PageClasses;

import helpers.CommonFunctions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://google.com
public class GooglePage {

    WebDriver driver;
    CommonFunctions cf;
    public GooglePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }


    @FindBy(name = "q")
    public WebElement textareaSearch;

    @FindBy(name = "btnK")
    public WebElement btnGoogleSearch;

    @Step("Search Wikipedia on Google")
    public void searchOnGoogle(){
        textareaSearch.sendKeys("Wikipedia");
        btnGoogleSearch.click();
    }

    @Step("Validate Google Search Result")
    public void searchResultValidation(){
        cf = new CommonFunctions();
        cf.checkIfElementExist(driver,"//span[contains(text(),'created and edited by volunteers around the world and hosted by the Wikimedia Foundation')]");
    }


}