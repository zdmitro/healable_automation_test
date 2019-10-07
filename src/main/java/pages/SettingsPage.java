package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SettingsPage extends BasePage {
    public SettingsPage(WebDriver driver) { super(driver); }

    private By accountTab = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-more/ion-content/div[2]/div/ion-row/ion-col[2]/div/ion-grid/ion-row");
    private By generalTab = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-more/ion-content/div[2]/div/ion-row/ion-col[2]/div/ion-grid/h6[2]");
    private By version1 = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-more/ion-content/div[2]/div/ion-row/ion-col[2]/div/ion-grid/p");
    private By logoutBtn = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-more/ion-content/div[2]/div/ion-row/ion-col[2]/div/ion-grid/button/span");

    public SettingsPage validateAccountAndGeneral() throws InterruptedException {

        Thread.sleep(2000);

        List<WebElement> elements = getDriver().findElements(By.tagName("h6"));

        Assert.assertEquals(elements.get(0).getText(), " Account");
        Assert.assertEquals(elements.get(1).getText(), " General");

        System.out.println(elements.get(0).getText());
        System.out.println(elements.get(1).getText());
        return this;
    }

    public SettingsPage validateFields() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> fields = getDriver().findElements(By.tagName("ion-item"));

        for(int i = 0; i<=6; i++) {
            System.out.println(fields.get(i).getText());

            switch (i) {
                case 0:
                    Assert.assertEquals(fields.get(0).getText(), "My Posts");
                    break;
                case 1:
                    Assert.assertEquals(fields.get(1).getText(), "Invite Users");
                    break;
                case 2:
                    Assert.assertEquals(fields.get(2).getText(), "Book Appointment");
                    break;
                case 3:
                    Assert.assertEquals(fields.get(3).getText(), "Notification Settings");
                    break;
                case 4:
                    Assert.assertEquals(fields.get(4).getText(), "Privacy Settings");
                    break;
                case 5:
                    Assert.assertEquals(fields.get(5).getText(), "Change Password");
                    break;
                case 6:
                    Assert.assertEquals(fields.get(6).getText(), "Edit Profile");
                    break;
            }
        }



        System.out.println(readText(version1));
        System.out.println(readText(logoutBtn));

        assertEquals(this.version1, "Version 1");
        assertEquals(this.logoutBtn, "Logout");

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
