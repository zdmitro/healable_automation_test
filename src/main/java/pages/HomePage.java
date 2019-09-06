package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By loginButton = By.id("login");
    private By span = By.tagName("span");
   //private By loginButton = By.xpath("//*[@id='btnWrapper']/ion-col[2]");
    //private By loginButton = By.xpath("//*[@id='login']");


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
        List<WebElement> elements = getDriver().findElements(span);
        Assert.assertEquals(elements.get(17).getText(),"Login");
        //Assert.assertEquals(elements.get(16).getText(),"Sign Up");
        return this;
    }




}
