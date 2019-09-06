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

    public LoginPage goToLoginPage() {
        getDriver().get(propertiesReader.getUrl());
        click(this.loginButton);
        return new LoginPage(getDriver());
    }

    public HomePage validateHomePage() {
        Assert.assertTrue(isElementDisplayed(this.signUpButton) && isElementDisplayed(this.loginButton));
        return this;
    }

}