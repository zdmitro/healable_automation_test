package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) { super(driver); }


    private By span = By.tagName("span");
    private By smallEmblem = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-header/ion-navbar/div[2]/ion-grid/ion-row/ion-col[1]/img");
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
    private By largeEmblem = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[1]/ion-card/div/div[1]/div/img");
    private By endOfPostsLabel = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[2]/p");

    private By userName = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[1]/ion-card/div/div[2]/p");
    private By accountUserName = By.xpath("//*[@id='tabpanel-t0-0']/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[1]/ion-card/div/div[2]/p/span");


    public By getUserName() { return userName; }
    public By getVideoCallBtn() { return videoCallBtn; }
    public By getChatBtn() { return chatBtn; }
    public By getMyNetworkBtn() { return myNetworkBtn; }
    public By getGroupsBtn() { return groupsBtn; }
    public By getSettingsBtn() { return settingsBtn; }
    public By getProfileBtn() { return profileBtn; }

    public AccountPage validateAccountPage1() {
        HomePage homePage = new HomePage(getDriver());
        List<WebElement> elements = getDriver().findElements(span);
        Assert.assertEquals(elements.get(9).getText(),"Dmitro Zagrebenyev");
        return this;
    }

    public AccountPage validateAccountPage(String accountUser) throws InterruptedException {
        Thread.sleep(2000);
        assertEquals(this.accountUserName, accountUser);
        return this;
    }

    public AccountPage checkElementsDisplayed() throws InterruptedException {
        List<By> byList = Arrays.asList(
                this.smallEmblem,
                this.homeBtn,
                this.videoCallBtn,
                this.chatBtn,
                this.myNetworkBtn,
                this.groupsBtn,
                this.notificationsBtn,
                this.settingsBtn,
                this.profileBtn,
                this.createCaseBtn,
                this.shareAnIdeaBtn,
                this.largeEmblem
//                this.endOfPostsLabel
        );
        Thread.sleep(4000);
        assertElementsDisplayed(byList);

//        JavascriptExecutor js = (JavascriptExecutor)getDriver();
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        return this;
    }

//    JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
//    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


}
