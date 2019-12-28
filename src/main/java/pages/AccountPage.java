package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) { super(driver); }
    private static final Logger log = Logger.getLogger(LoginPage.class);


    private final By span = By.tagName("span");
    private By smallEmblem = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-header/span/ion-grid/ion-row/ion-col[1]/div/img");
    private  By searchField = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-header/span/ion-grid/ion-row/ion-col[2]/div/ion-searchbar/div/input");
    private By homeBtn = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-header/span/ion-grid/ion-row/ion-col[3]/div/div[1]");

    private By videoCallBtn = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-header/span/ion-grid/ion-row/ion-col[3]/div/div[2]/ion-icon");

    private By chatBtn = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-header/span/ion-grid/ion-row/ion-col[3]/div/div[3]");

    private By groupsBtn = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-header/span/ion-grid/ion-row/ion-col[3]/div/div[4]");

    private By notificationsBtn = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-header/span/ion-grid/ion-row/ion-col[3]/div/div[4]");

    private By settingsBtn = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-header/span/ion-grid/ion-row/ion-col[3]/div/div[6]/ion-icon");

    private By profileBtn = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-header/span/ion-grid/ion-row/ion-col[3]/div/div[7]/img");

    private By createPostBtn = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[2]/ion-grid/div/ion-row/ion-col/button/span");

    private By userPhoto = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[1]/ion-card/div/div[1]/img");

    private By endOfPostsLabel = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[2]/p");

    private By userName = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[1]/ion-card/div/div[2]/p");
    private By accountUserName = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[1]/ion-card/div/div[2]/p");


    public By getUserName() { return userName; }
    public By getVideoCallBtn() { return videoCallBtn; }
    public By getChatBtn() { return chatBtn; }
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
        log.info(readText(this.accountUserName) + " text is " + readText(this.accountUserName).equals("Dmitro Zagrebenyev"));
        return this;
    }

    public AccountPage checkElementsDisplayed() throws InterruptedException {
        List<By> byList = Arrays.asList(
                this.smallEmblem,
                this.searchField,
                this.homeBtn,
                this.videoCallBtn,
                this.chatBtn,
                this.groupsBtn,
                this.notificationsBtn,
                this.settingsBtn,
                this.profileBtn,
                this.createPostBtn,
                this.userPhoto
//                this.endOfPostsLabel
        );
        Thread.sleep(4000);
        assertElementsDisplayed(byList);

        if (getDriver() instanceof JavascriptExecutor) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        }
        return this;
    }

//    JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
//    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


}
