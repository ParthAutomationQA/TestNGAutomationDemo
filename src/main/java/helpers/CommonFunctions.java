package helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonFunctions {

    public void checkIfElementExist(WebDriver driver, String xpath){
        int totalElement = driver.findElements(By.xpath(xpath)).size();
        Assert.assertEquals(totalElement,1);
    }
}
