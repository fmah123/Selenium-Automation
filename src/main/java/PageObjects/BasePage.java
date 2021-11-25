package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    //protected access modifier allows driver instance to be accessible to child class from parent class.
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void WaitAndClick(By Selector){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Selector));
        element.click();
    }

    public void FindAndType(String input, By Selector){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Selector));
        element.sendKeys(input);
    }

    public void SelectDropDownOption(String input, By Selector){
        Select selectOption = new Select(driver.findElement(Selector));
        selectOption.selectByVisibleText(input);
    }
}
