package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger log = Logger.getLogger(LoginPage.class);

    private By span = By.tagName("span");
    private By buttonTag = By.tagName("button");
    private By p = By.tagName("p");


    private By topBar = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-header");
    private By logo = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-row[1]/ion-col/img");
    private By loginField = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[1]/div[1]/div/ion-input/input");
    private By passwordField = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[2]/div[1]/div/ion-input/input");
    private By passwordFieldEye = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[2]/div[1]/button/span/ion-icon");
    //private By forgotPasswordLink = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-row[2]/a");
    private By forgotPasswordLink = By.linkText("Forgot Password");
    //    private By loginButton = By.xpath("//*[@id='login']/span");
    private By loginButton = By.xpath("//*[@id='login']");

    private By backToHomePageButton = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-header/ion-navbar/div[2]/ion-grid/ion-row/ion-col[1]/ion-buttons/button");
    private By loginErrorMessage = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[1]");
    //private By userName = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[1]/ion-card/div/div[2]/p");
    private By userName = By.xpath("//*[@id='tabpanel-t0-0']/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[1]/ion-card/div/div[2]");

    private By loginHomepageButton = By.id("login");
    private By signUpHomepageButton = By.id("signup");

    public By getLoginField() {
        return loginField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public LoginPage validateLoginPage() {
        log.info("Validate Login Page");
        List<WebElement> elements = getDriver().findElements(span);
        Assert.assertEquals(elements.get(5).getText(), "Login");
        log.info(elements.get(5).getText() + " text is " + elements.get(5).getText().equals("Login"));
        Assert.assertEquals(readText(this.forgotPasswordLink), "Forgot Password");
        log.info(readText(this.forgotPasswordLink) + " text is " + readText(this.forgotPasswordLink).equals("Forgot Password"));
        return this;
    }

    public LoginPage checkForElementsDisplayed_LoginPage() {
        log.info("checkForElementsDisplayed_LoginPage");
        List<By> byList = Arrays.asList(
                this.topBar,
                this.logo,
                this.loginField,
                this.passwordField,
                this.passwordFieldEye,
                this.forgotPasswordLink,
                this.loginButton
        );
        assertElementsDisplayed(byList);
        return this;
    }

    public LoginPage clickOnBackToHomePage() throws InterruptedException {
        log.info("clickOnBackToHomePage");
        getDriver();
        click(this.backToHomePageButton);
        return new LoginPage(getDriver());
    }

    public LoginPage clickOnForgotPassowrd() throws InterruptedException {
        log.info("clickOnForgotPassowrd");
        getDriver();
        click(this.forgotPasswordLink);
        return new LoginPage(getDriver());
    }

//    public LoginPage validateHomePage() throws InterruptedException {
//        HomePage homePage = new HomePage(getDriver());
//        Thread.sleep(2000);
//        Assert.assertTrue(isElementDisplayed(homePage.getSignUpButton()) && isElementDisplayed(homePage.getLoginButton()));
//        return this;
//    }

//    public LoginPage validateHomePage() throws InterruptedException {
//        HomePage homePage = new HomePage(getDriver());
//        log.info("Validate Home Page");
//        Thread.sleep(4000);
//        assertEquals(homePage.getLoginButton(), "Login");
//        assertEquals(homePage.getSignUpButton(), "Sign Up");
//        return this;
//    }

    public LoginPage validateHomePage() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        log.info("Validate Home Page");
        Thread.sleep(4000);
        assertEquals(homePage.getLoginButtonReturnPage(), "Login");
        assertEquals(homePage.getSignUpButtonReturnPage(), "Sign Up");
        log.info(readText(homePage.getSignUpButtonReturnPage()) + " text is " + readText(homePage.getSignUpButtonReturnPage()).equals("Sign Up"));
        log.info(readText(homePage.getLoginButtonReturnPage()) + " text is " + readText(homePage.getLoginButtonReturnPage()).equals("Login"));
        return this;
    }

    public LoginPage login(String login, String password) throws InterruptedException {
        log.info("Log In");
        Thread.sleep(1000);
        writeText(this.loginField, login);
        Thread.sleep(1000);
        writeText(this.passwordField, password);
        Thread.sleep(1000);
        clickLogin();
        return this;
    }

    public LoginPage clickLogin() {
        List<WebElement> elements = getDriver().findElements(buttonTag);
        elements.get(5).click();
        return this;
    }

    public LoginPage validateLoginError() throws InterruptedException {
        Thread.sleep(1000);
        assertEquals(this.loginErrorMessage, "Invalid login. Please try again.");
        log.info(readText(this.loginErrorMessage) + " text is " + readText(this.loginErrorMessage).equals("Invalid login. Please try again."));
        return this;
    }

    public LoginPage validateForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
        Assert.assertTrue(isElementDisplayed(forgotPasswordPage.getNewLoginField()) && isElementDisplayed(forgotPasswordPage.getForgotPasswordBtn()));
        log.info(readText(forgotPasswordPage.getForgotPasswordBtn()) + " text is " + readText(forgotPasswordPage.getForgotPasswordBtn()).equals("Forgot Password"));
        return this;
    }

    public void validateLoopLoginError(String loginPassword) {
        String[] s = loginPassword.split(" ");
        String login = getStringDataValue(s[0]);
        String password = getStringDataValue(s[1]);
        clearField(this.loginField);
        writeText(this.loginField, login);
        clearField(this.passwordField);
        writeText(this.passwordField, password);
        clickLogin();
        waitVisibility(this.loginErrorMessage);
        Assert.assertTrue(isElementDisplayed(this.loginErrorMessage));
        getDriver().quit();
    }

    private String getStringDataValue(String testData) {

        if (testData.equals("\"\"")) {
            testData = "";
        } else if (testData.equals("null")) {
            testData = null;
        } else if (testData.equals("space")) {
            testData = " ";
        }
        return testData;
    }



}

