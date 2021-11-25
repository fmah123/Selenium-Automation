package PageObjects;


import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static String URL = "http://demoaut.katalon.com";

    public void GoToHomePage(){
        driver.get(URL);
    }
}
