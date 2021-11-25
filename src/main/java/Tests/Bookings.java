package Tests;
import PageObjects.BookingPage;
import PageObjects.DriverFactory;
import PageObjects.HomePage;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Bookings {
    private static DriverFactory driverfactory = new DriverFactory();
    private static WebDriver driver = driverfactory.GetDriver();
    private HomePage homepage = new HomePage(driver);
    private BookingPage bookings = new BookingPage(driver);

    @Before
    public void TestSetUp(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homepage.GoToHomePage();
    }

    @Test
    public void BookingAnAppointment(){
        bookings.ClickOnMakeAppoint();
        bookings.SubmitLogInDetails("John Doe", "ThisIsNotAPassword");
        bookings.FillAndSubmitAppointmentForm("Tokyo CURA Healthcare Center", "20/05/2018", "Just a Test");
        BookingPage.Confirmation confirm = bookings.SuccessMsg();
        Assert.assertEquals("Appointment Confirmation", confirm.getText());
    }

    @AfterClass
    public static void TestTearDown(){
        driver.quit();
    }
}
