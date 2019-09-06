package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {super(driver);}

    private By span = By.tagName("span");
    private By topBar = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-header");
    private By logo = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-row[1]/ion-col/img");
    private By loginField = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[1]/div[1]/div/ion-input/input");
    private By passwordField = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[2]/div[1]/div/ion-input/input");
    private By passwordFieldEye = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-item[2]/div[1]/button/span/ion-icon");
    private By forgotPasswordLink = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-row[2]/a");
    private By loginButton = By.xpath("//*[@id='login']/span");

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


}
