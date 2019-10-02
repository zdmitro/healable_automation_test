package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class VideoCallPage extends BasePage {
    public VideoCallPage(WebDriver driver) { super(driver); }

    //private By bookAppointment = By.xpath("//*[@id='example_c']/span");
    //private By bookAppointment = By.id("startChatBtn");
    //private By bookAppointment = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/page-videocalldetails/ion-content/div[2]/div/ion-grid/ion-row/ion-col[3]/div/span");
    private By bookAppointment = By.id("example_c");


    private By notifucationsBtn = By.xpath("//*[@id='hideTabs']/page-videocalldetails/ion-content/div[2]/div/ion-grid/ion-row/ion-col[2]/div/ion-segment/ion-segment-button[1]");

    public VideoCallPage validateBookAppointment() throws InterruptedException {

        Thread.sleep(2000);
        List<WebElement> elements = getDriver().findElements(By.tagName("ion-segment-button"));
        WebElement element = getDriver().findElement(this.bookAppointment);
        Assert.assertTrue(
                elements.get(0).isDisplayed() &&
                        elements.get(1).isDisplayed() &&
                        elements.get(2).isDisplayed() &&
                        element.isDisplayed()
        );

        assertEquals(bookAppointment, "BOOK APPOINTMENT");

        System.out.println(elements.get(0).getText());
        System.out.println(readText(bookAppointment));
        return this;

    }

}
