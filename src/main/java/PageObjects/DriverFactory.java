package PageObjects;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    static{
        ChromeDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    public WebDriver GetDriver(){
        if (driver == null){
            SetDriver();
        }

        return driver;
    }

    public void SetDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
