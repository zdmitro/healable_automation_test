package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ForgotPasswordPage extends BasePage {
    public ForgotPasswordPage(WebDriver driver) { super(driver); }

    private By newLoginField = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-forgot-password/ion-content/div[2]/div/ion-row/ion-col[2]/div/ion-grid/form/ion-row[1]/ion-item/div[1]/div/ion-input");
    public By getNewLoginField() { return newLoginField; }

    private By forgotPasswordBtn = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-forgot-password/ion-content/div[2]/div/ion-row/ion-col[2]/div/ion-grid/form/ion-row[2]/button");
    public By getForgotPasswordBtn() { return forgotPasswordBtn; }



}
