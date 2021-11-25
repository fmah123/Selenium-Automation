package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingPage extends BasePage {

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    private final By Make_Appointment_Button = By.cssSelector("div.text-vertical-center a#btn-make-appointment");
    private final By Username_Entry_Field = By.id("txt-username");
    private final By Password_Entry_Field = By.id("txt-password");
    private final By Submit_Button = By.id("btn-login");
    private final By Facility_Drop_Down = By.cssSelector("select#combo_facility");
    private final By Visit_Date_Entry_Field = By.id("txt_visit_date");
    private final By Comment_Entry_Field = By.cssSelector("div.col-sm-4 textarea.form-control");
    private final By Book_Appointment_Button = By.cssSelector("div.col-sm-offset-5 button#btn-book-appointment");

    public void ClickOnMakeAppoint() {
        WaitAndClick(Make_Appointment_Button);
    }

    public void SubmitLogInDetails(String name, String password) {
        FindAndType(name, Username_Entry_Field);
        FindAndType(password, Password_Entry_Field);
        WaitAndClick(Submit_Button);
    }

    public void FillAndSubmitAppointmentForm(String MenuOption, String date, String msg) {
        WaitAndClick(Facility_Drop_Down);
        SelectDropDownOption(MenuOption, Facility_Drop_Down);
        FindAndType(date, Visit_Date_Entry_Field);
        FindAndType(msg, Comment_Entry_Field);
        WaitAndClick(Book_Appointment_Button);
    }

    public Confirmation SuccessMsg(){
        return new Confirmation(driver.findElement(By.cssSelector("section#summary.bg-primary")));
    }

    public class Confirmation{
        private final WebElement element;

        public Confirmation(WebElement element){
            this.element = element;
        }

        public String getText(){
            return element.findElement(By.cssSelector("div.col-xs-12 h2")).getText().trim();
        }
    }
}
