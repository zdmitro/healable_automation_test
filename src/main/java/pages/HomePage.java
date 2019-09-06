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

    public HomePage goToHomePage_method() {
        getDriver().get(propertiesReader.getUrl());
        return this;
    }

    public LoginPage goToLoginPage() throws InterruptedException {
        getDriver().get(propertiesReader.getUrl());
        click(this.loginButton);
        return new LoginPage(getDriver());
    }

    public HomePage validateHomePage() throws InterruptedException {
        Thread.sleep(1000);
        boolean isSignUpButtonDisplayed = getDriver().findElement(this.signUpButton).isDisplayed();
        boolean isLoginButton = getDriver().findElement(this.loginButton).isDisplayed();
        Assert.assertTrue(isSignUpButtonDisplayed && isLoginButton);
        return this;
    }

}