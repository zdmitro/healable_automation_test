package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class VideoCallPage extends BasePage {
    public VideoCallPage(WebDriver driver) { super(driver); }
    private static final Logger log = Logger.getLogger(VideoCallPage.class);

    private By bookAppointment = By.id("example_c lcl-appointment-schedule--styling");

    public VideoCallPage validateBookAppointment() throws InterruptedException {
        log.info("validateBookAppointment");

        Thread.sleep(2000);
//        List<WebElement> elements = getDriver().findElements(By.tagName("ion-segment-button"));
//        WebElement element = getDriver().findElement(this.bookAppointment);
//        Assert.assertTrue(
//                elements.get(0).isDisplayed() &&
//                        elements.get(1).isDisplayed() &&
//                        elements.get(2).isDisplayed() &&
//                        element.isDisplayed()
//        );

        List<WebElement> fields = getDriver().findElements(By.tagName("ion-segment-button"));

        for(int i = 0; i<=2; i++) {
            System.out.println(fields.get(i).getText());

            switch (i) {
                case 0:
                    Assert.assertEquals(fields.get(0).getText(), "NOTIFICATIONS");
                    log.info(fields.get(0).getText() + " ## TEXT is " + fields.get(0).getText().equals("NOTIFICATIONS"));
                    break;
                case 1:
                    Assert.assertEquals(fields.get(1).getText(), "APPOINTMENTS");
                    log.info(fields.get(1).getText() + " ## TEXT is " + fields.get(1).getText().equals("APPOINTMENTS"));
                    break;
                case 2:
                    Assert.assertEquals(fields.get(2).getText(), "HISTORY");
                    log.info(fields.get(2).getText() + " ## TEXT is " + fields.get(2).getText().equals("HISTORY"));
                    break;

            }
        }

        assertEquals(bookAppointment, "Book Appointment");
        log.info(readText(this.bookAppointment) + " ## TEXT is " + readText(this.bookAppointment).equals("Book Appointment"));
        System.out.println(readText(bookAppointment));

        return this;
    }

}
