package PageClasses;

import helpers.CommonFunctions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://www.amazon.in/
public class AmazonPage {
    WebDriver driver;
    CommonFunctions cf;
    public AmazonPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text()='Books']")
    private WebElement linkBooks;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement linkSearchBar;

    @Step("User opens books section in Amazon")
    public void openBookSection(){
        linkSearchBar.click();
        linkBooks.click();
    }

    @Step("User checking for book price using book Author Name")
    public void getBookPriceByAuthorName(String author){
        String xpath = "//span[text()='"+author+"']//ancestor::li//div[contains(@class,'acsProductBlockV2__price')]//span[contains(@class,'price-buying')]//span[@class='a-price-whole']";
        String bookPrice = driver.findElement(By.xpath(xpath)).getText();
        System.out.println("Amazon book Author Name: "+author+" Price: "+bookPrice);
    }
}