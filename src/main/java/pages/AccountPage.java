package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) { super(driver); }


    private By span = By.tagName("span");

    private By smallEmblem = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-home/ion-header/ion-navbar/div[2]/ion-grid/ion-row/ion-col[1]/img");
    private By homeBtn = By.id("divHome");
    private By videoCallBtn = By.id("divVideo");
    private By chatBtn = By.id("divChat");
    private By myNetworkBtn = By.id("divNetwork");
    private By groupsBtn = By.id("divGroup");
    private By notificationsBtn = By.id("divNotify");
    private By settingsBtn = By.id("divSetting");
    private By profileBtn = By.id("divProfile");
    private By createCaseBtn = By.id("newCase");
    private By shareAnIdeaBtn = By.id("share");

    private By userName = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[1]/ion-card/div/div[2]/p");
    private By accountUserName = By.xpath("//*[@id='tabpanel-t0-0']/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[1]/ion-card/div/div[2]/p/span");

    public By getUserName() {return userName; }

    public AccountPage validateAccountPage1() {
        HomePage homePage = new HomePage(getDriver());
        List<WebElement> elements = getDriver().findElements(span);
        Assert.assertEquals(elements.get(9).getText(),"Dmitro Zagrebenyev");
        return this;
    }

    public AccountPage validateAccountPage() throws InterruptedException {
        Thread.sleep(1000);
        assertEquals(this.accountUserName, "Dmitro Zagrebenyev");
        return this;
    }

    public AccountPage clickVideoCallBtn() throws InterruptedException {
        getDriver();
        click(this.videoCallBtn);
        return this;
    }

}
