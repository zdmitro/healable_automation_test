package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class PersonalInfoPage extends BasePage {
    private static final Logger log = Logger.getLogger(LoginPage.class);
    public PersonalInfoPage(WebDriver driver) { super(driver); }

    private By personalInfoHeader = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/page-userprofile/ion-content/div[2]/div/ion-grid/ion-row/ion-col[2]/ion-card/div/div[1]/h6");
    private By myStoryHeader = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/page-userprofile/ion-content/div[2]/div/ion-grid/ion-row/ion-col[2]/ion-card/div/div[2]/h6");

    public PersonalInfoPage validatePersonalInfoPage() throws InterruptedException {
        log.info("checkElementsDisplayed");
        List<By> byList = Arrays.asList(
                this.personalInfoHeader,
                this.myStoryHeader
        );
        Thread.sleep(4000);
        assertElementsDisplayed(byList);

        if (getDriver() instanceof JavascriptExecutor) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        }
        return this;
    }

    /**
    public PersonalInfoPage validatePersonalInfoLabels() throws InterruptedException {

        Thread.sleep(2000);
        List<WebElement> elements = getDriver().findElements(By.tagName("ion-label"));

        for (int i = 0; i <= 1; i++) {
            System.out.println(elements.get(i).getText());
            switch (i) {
                case 0:
                    Assert.assertEquals(elements.get(0).getText(), "Account");
                    break;
                case 1:
                    Assert.assertEquals(elements.get(1).getText(), "General");
                    break;
            }
        }
        return this;
    }
*/


}
