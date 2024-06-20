package BaseClasses;

import Util.URLs;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(UITestListner.class)
public class UIBaseTest {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    public void initializeDriver(String appName){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        switch (appName.toLowerCase()){
            case "linkedin":
                driver.get(new URLs().getLinkedInURL());
                break;
            case "google":
                driver.get(new URLs().getGoogleURL());
                break;
            case "amazon":
                driver.get(new URLs().getAmazonURL());
                break;
            case "netflix":
                driver.get(new URLs().getNetflixURL());
                break;
            case "instagram":
                driver.get(new URLs().getInstagramURL());
                break;
            case "facebook":
                driver.get(new URLs().getFacebookURL());
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        tdriver.set(driver);
    }

    public WebDriver getDriver(){
        return tdriver.get();
    }

    public void closeDriver(){
        driver.close();
    }
}
