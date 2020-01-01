package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.PropertiesReader;

import java.util.List;

public class HomePage extends BasePage {

    private PropertiesReader propertiesReader = new PropertiesReader();
    private static final Logger log = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By loginButton = By.id("login");
    private By signUpButton = By.id("signup");

    private By loginButtonReturnPage = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-welcome[2]/ion-content/div[2]/div/ion-grid/ion-row[2]/div/ion-col[2]/button");

    private By signUpButtonReturnPage = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-welcome[2]/ion-content/div[2]/div/ion-grid/ion-row[2]/div/ion-col[1]/button");

    public By getLoginButtonReturnPage() {
        return loginButtonReturnPage;
    }

    public By getSignUpButtonReturnPage() {
        return signUpButtonReturnPage;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getSignUpButton() {
        return signUpButton;
    }

    public HomePage goToHomePage_method() {
        log.info("goToHomePage_method");
        getDriver().get(propertiesReader.getUrl());
        return this;
    }

    public LoginPage goToLoginPage() throws InterruptedException {
        log.info("goToLoginPage");
        getDriver().get(propertiesReader.getUrl());
        Thread.sleep(1000);
        click(this.loginButton);
        return new LoginPage(getDriver());
    }

//    public HomePage validateHomePage() {
//        Assert.assertTrue(isElementDisplayed(this.signUpButton) && isElementDisplayed(this.loginButton));
//        return this;
//    }

    public HomePage validateHomePage() {
        log.info("Validate Home Page");
        assertEquals(this.loginButton, "Login");
        log.info(readText(this.loginButton) + " ## TEXT is " + readText(this.loginButton).equals("Login"));
        assertEquals(this.signUpButton, "Sign Up");
        log.info(readText(this.signUpButton) + " ## TEXT is " + readText(this.signUpButton).equals("Sign Up"));

        return this;
    }

    public AccountPage goToAccountPage(String login, String password) throws InterruptedException {
        log.info("goToAccountPage");
        getDriver().get(propertiesReader.getUrl());
        click(this.loginButton);
        LoginPage loginPage = new LoginPage(getDriver());
        Thread.sleep(1000);
        writeText(loginPage.getLoginField(), login);
        Thread.sleep(1000);
        writeText(loginPage.getPasswordField(), password);
        Thread.sleep(1000);
        loginPage.clickLogin();

        return new AccountPage(getDriver());
    }

    public VideoCallPage goToVideoCall(String login, String password) throws InterruptedException {
        log.info("goToVideoCall");

        getDriver().get(propertiesReader.getUrl());
        click(this.loginButton);
        LoginPage loginPage = new LoginPage(getDriver());
        Thread.sleep(1000);
        writeText(loginPage.getLoginField(), login);
        Thread.sleep(1000);
        writeText(loginPage.getPasswordField(), password);
        Thread.sleep(1000);
        loginPage.clickLogin();

        VideoCallPage videoCallPage = new VideoCallPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());
        Thread.sleep(2000);
        click(accountPage.getVideoCallBtn());
        return new VideoCallPage(getDriver());
    }

    public ChatPage goToChatPage(String login, String password) throws InterruptedException {
        log.info("goToChatPage");
        getDriver().get(propertiesReader.getUrl());
        click(this.loginButton);
        LoginPage loginPage = new LoginPage(getDriver());
        Thread.sleep(1000);
        writeText(loginPage.getLoginField(), login);
        Thread.sleep(1000);
        writeText(loginPage.getPasswordField(), password);
        Thread.sleep(1000);
        loginPage.clickLogin();

        ChatPage chatPage = new ChatPage(getDriver());

        AccountPage accountPage = new AccountPage(getDriver());
        Thread.sleep(2000);
        click(accountPage.getChatBtn());
        return new ChatPage(getDriver());
    }


    public GroopsPage goToGroopsPage(String login, String password) throws InterruptedException {
        log.info("goToGroopsPage");
        getDriver().get(propertiesReader.getUrl());
        click(this.loginButton);
        LoginPage loginPage = new LoginPage(getDriver());
        Thread.sleep(1000);
        writeText(loginPage.getLoginField(), login);
        Thread.sleep(1000);
        writeText(loginPage.getPasswordField(), password);
        Thread.sleep(1000);
        loginPage.clickLogin();

        AccountPage accountPage = new AccountPage(getDriver());
        Thread.sleep(2000);
        click(accountPage.getGroupsBtn());
        return new GroopsPage(getDriver());
    }

    public SettingsPage goToSettingsPage(String login, String password) throws InterruptedException {
        log.info("goToSettingsPage");

        getDriver().get(propertiesReader.getUrl());
        Thread.sleep(1000);
        click(this.loginButton);
        LoginPage loginPage = new LoginPage(getDriver());
        Thread.sleep(1000);
        writeText(loginPage.getLoginField(), login);
        Thread.sleep(1000);
        writeText(loginPage.getPasswordField(), password);
        Thread.sleep(1000);
        loginPage.clickLogin();

        AccountPage accountPage = new AccountPage(getDriver());
        Thread.sleep(3000);
        click(accountPage.getSettingsBtn());
        return new SettingsPage(getDriver());
    }

    public PersonalInfoPage goToPersonalInfoPageRightButton(String login, String password) throws InterruptedException {
        log.info("goToPersonalInfoPageRightButton");
        getDriver().get(propertiesReader.getUrl());
        click(this.loginButton);
        LoginPage loginPage = new LoginPage(getDriver());
        Thread.sleep(1000);
        writeText(loginPage.getLoginField(), login);
        Thread.sleep(1000);
        writeText(loginPage.getPasswordField(), password);
        Thread.sleep(1000);
        loginPage.clickLogin();

        AccountPage accountPage = new AccountPage(getDriver());
        Thread.sleep(2000);
        click(accountPage.getProfileBtn());
        return new PersonalInfoPage(getDriver());
    }
}