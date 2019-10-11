package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.PropertiesReader;

public class HomePage extends BasePage {

    private PropertiesReader propertiesReader = new PropertiesReader();

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By loginButton = By.id("login");
    private By signUpButton = By.id("signup");

    public By getLoginButton() {
        return loginButton;
    }

    public By getSignUpButton() {
        return signUpButton;
    }

    public HomePage goToHomePage_method() {
        getDriver().get(propertiesReader.getUrl());
        return this;
    }

    public LoginPage goToLoginPage() throws InterruptedException {
        getDriver().get(propertiesReader.getUrl());
        click(this.loginButton);
        return new LoginPage(getDriver());
    }

    public HomePage validateHomePage() {
        Assert.assertTrue(isElementDisplayed(this.signUpButton) && isElementDisplayed(this.loginButton));
        return this;
    }

    public AccountPage goToAccountPage(String login, String password) throws InterruptedException {
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

    public MyNetworkPage goToMyNetworkPage(String login, String password) throws InterruptedException {

        getDriver().get(propertiesReader.getUrl());
        click(this.loginButton);
        LoginPage loginPage = new LoginPage(getDriver());
        Thread.sleep(1000);
        writeText(loginPage.getLoginField(), login);
        Thread.sleep(1000);
        writeText(loginPage.getPasswordField(), password);
        Thread.sleep(1000);
        loginPage.clickLogin();

        //MyNetworkPage myNetworkPage = new MyNetworkPage(getDriver());

        AccountPage accountPage = new AccountPage(getDriver());
        Thread.sleep(2000);
        click(accountPage.getMyNetworkBtn());
        return new MyNetworkPage(getDriver());
    }

    public GroopsPage goToGroopsPage(String login, String password) throws InterruptedException {

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
        Thread.sleep(3000);
        click(accountPage.getSettingsBtn());
        return new SettingsPage(getDriver());
    }

    public PersonalInfoPage goToPersonalInfoPageRightButton(String login, String password) throws InterruptedException {

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