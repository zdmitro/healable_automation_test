package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

import static data.Data.LOGIN;
import static data.Data.PASSWORD;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {super(driver);}

    private By span = By.tagName("span");
    private By buttonTag = By.tagName("button");
    private By p = By.tagName("p");


    private By topBar = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-header");
    private By logo = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-row[1]/ion-col/img");
    private By loginField = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[1]/div[1]/div/ion-input/input");
    private By passwordField = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[2]/div[1]/div/ion-input/input");
    private By passwordFieldEye = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[2]/div[1]/button/span/ion-icon");
    private By forgotPasswordLink = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-row[2]/a");
//    private By loginButton = By.xpath("//*[@id='login']/span");
    private By loginButton = By.xpath("//*[@id='login']");

    private By backToHomePageButton = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-header/ion-navbar/div[2]/ion-grid/ion-row/ion-col[1]/ion-buttons/button");
    private By loginErrorMessage = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[1]");
    //private By userName = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[1]/ion-card/div/div[2]/p");
    private By userName = By.xpath("//*[@id='tabpanel-t0-0']/page-home/ion-content/div[2]/div/ion-grid/ion-row/ion-col[1]/ion-card/div/div[2]");

    public By getLoginField() {
        return loginField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public LoginPage validateLoginPage() {
        List<WebElement> elements = getDriver().findElements(span);
        Assert.assertEquals(elements.get(5).getText(),"Login");
        return this;
    }

    public LoginPage checkForElementsDisplayed_LoginPage() {
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
        getDriver();
        click(this.backToHomePageButton);
        return new LoginPage(getDriver());
    }

    public LoginPage clickOnForgotPassowrd() throws InterruptedException {
        getDriver();
        click(this.forgotPasswordLink);
        return new LoginPage(getDriver());
    }

    public LoginPage validateHomePage() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(isElementDisplayed(homePage.getSignUpButton()) && isElementDisplayed(homePage.getLoginButton()));
        return this;
    }

    public LoginPage login(String login, String password) throws InterruptedException {
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

//    public LoginPage validateLoginError() {
//        List<WebElement> elements = getDriver().findElements(p);
//        Assert.assertEquals(elements.get(0).getText()," Invalid login. Please try again. ");
//        return this;
//    }

    public LoginPage validateLoginError() throws InterruptedException {
        Thread.sleep(1000);
        assertEquals(this.loginErrorMessage, " Invalid login. Please try again. ".trim());
        return this;
    }

    public LoginPage validateForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
        Assert.assertTrue(isElementDisplayed(forgotPasswordPage.getNewLoginField()) && isElementDisplayed(forgotPasswordPage.getForgotPasswordBtn()));
        return this;
    }

//    public LoginPage validateLoginToUserAccount(String user) throws InterruptedException {
//        WebElement webElement = getDriver().findElement(userName);
//        String userNameText = webElement.getText();
//        Assert.assertEquals(userNameText, user);
//        return this;
//    }

//    public LoginPage validateAccountPage() {
//        List<WebElement> elements = getDriver().findElements(span);
//        Assert.assertEquals(elements.get(9).getText(),"Dmitro Zagrebenyev");
//        return this;
//    }


}

