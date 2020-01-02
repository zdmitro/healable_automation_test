package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SettingsPage extends BasePage {
    public SettingsPage(WebDriver driver) { super(driver); }
    private static final Logger log = Logger.getLogger(SettingsPage.class);

    private By accountTab = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-more/ion-content/div[2]/div/ion-row/ion-col[2]/div/ion-grid/ion-row");
    private By generalTab = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-more/ion-content/div[2]/div/ion-row/ion-col[2]/div/ion-grid/h6[2]");
    private By version1 = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-more/ion-content/div[2]/div/ion-grid/ion-row/ion-col[2]/div/ion-grid/p");
    private By logoutBtn = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-more/ion-content/div[2]/div/ion-grid/ion-row/ion-col[2]/div/ion-grid/button/span");

    public SettingsPage validateAccountAndGeneral() throws InterruptedException {

        log.info("validateAccountAndGeneral");

        Thread.sleep(2000);

        List<WebElement> elements = getDriver().findElements(By.tagName("h6"));

        Assert.assertEquals(elements.get(0).getText(), " Account");
        log.info(elements.get(0).getText() + " ## TEXT is " + elements.get(0).getText().equals(" Account"));
        Assert.assertEquals(elements.get(1).getText(), " General");
        log.info(elements.get(1).getText() + " ## TEXT is " + elements.get(1).getText().equals(" General"));

        System.out.println(elements.get(0).getText());
        System.out.println(elements.get(1).getText());
        return this;
    }

    public SettingsPage validateFields() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> fields = getDriver().findElements(By.tagName("ion-item"));

        for(int i = 0; i<=7; i++) {
            System.out.println(fields.get(i).getText());

            switch (i) {
                case 0:
                    Assert.assertEquals(fields.get(0).getText(), "My Posts");
                    log.info(fields.get(0).getText() + " ## TEXT is " + fields.get(0).getText().equals("My Posts"));
                    break;
                case 1:
                    Assert.assertEquals(fields.get(1).getText(), "Invite Users");
                    log.info(fields.get(1).getText() + " ## TEXT is " + fields.get(1).getText().equals("Invite Users"));
                    break;
                case 2:
                    Assert.assertEquals(fields.get(2).getText(), "Book Appointment");
                    log.info(fields.get(2).getText() + " ## TEXT is " + fields.get(2).getText().equals("Book Appointment"));
                    break;
                case 3:
                    Assert.assertEquals(fields.get(3).getText(), "Notification Settings");
                    log.info(fields.get(3).getText() + " ## TEXT is " + fields.get(3).getText().equals("Notification Settings"));
                    break;
                case 4:
                    Assert.assertEquals(fields.get(4).getText(), "Privacy Settings");
                    log.info(fields.get(4).getText() + " ## TEXT is " + fields.get(4).getText().equals("Privacy Settings"));
                    break;
                case 5:
                    Assert.assertEquals(fields.get(5).getText(), "Connection Requests");
                    log.info(fields.get(5).getText() + " ## TEXT is " + fields.get(5).getText().equals("Connection Requests"));
                    break;
                case 6:
                    Assert.assertEquals(fields.get(6).getText(), "Change Password");
                    log.info(fields.get(6).getText() + " ## TEXT is " + fields.get(6).getText().equals("Change Password"));
                    break;
                case 7:
                    Assert.assertEquals(fields.get(7).getText(), "Edit Profile");
                    log.info(fields.get(6).getText() + " ## TEXT is " + fields.get(6).getText().equals("Edit Profile"));
                    break;

            }
        }

        System.out.println(readText(version1));
        System.out.println(readText(logoutBtn));

        assertEquals(this.version1, "Version 1");
        log.info(readText(this.version1) + " ## TEXT is " + readText(this.version1).equals("Version 1"));
        assertEquals(this.logoutBtn, "Logout");
        log.info(readText(this.logoutBtn) + " ## TEXT is " + readText(this.logoutBtn).equals("Logout"));

        return this;

    }

    public SettingsPage validateFields1() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> fields = getDriver().findElements(By.tagName("ion-item"));

        Assert.assertTrue(
                "My Posts".equals(fields.get(0).getText()) &&
                        "Invite Users".equals(fields.get(1).getText()) &&
                        "Book Appointment".equals(fields.get(2).getText()) &&
                        "Notification Settings".equals(fields.get(3).getText()) &&
                        "Privacy Settings".equals(fields.get(4).getText()) &&
                        "Change Password".equals(fields.get(5).getText()) &&
                        "Edit Profile".equals(fields.get(6).getText()) &&
                        "Version 1".equals(readText(this.version1)) &&
                        "Logout".equals(readText(this.logoutBtn))
        );
        return this;
    }
}
