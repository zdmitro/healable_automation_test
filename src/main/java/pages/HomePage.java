package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

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
}