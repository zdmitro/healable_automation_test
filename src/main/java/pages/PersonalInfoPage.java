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

    public PersonalInfoPage verifyHeaders() throws InterruptedException {
        log.info("verifyHeaders");
        Thread.sleep(1000);
        List<WebElement> fields = getDriver().findElements(By.tagName("h6"));

        for (int i = 0; i <= 7; i++) {
            System.out.println(fields.get(i).getText());

            switch (i) {
//                case 0:
//                    break;
//                case 1:
//                    break;
//                case 2:
//                    break;
                case 3:
                    Assert.assertEquals(fields.get(3).getText(), "Personal Info");
                    log.info(fields.get(3).getText() + " ## TEXT is " + fields.get(3).getText().equals("Personal Info"));
                    break;
                case 4:
                    Assert.assertEquals(fields.get(4).getText(), "My Story");
                    log.info(fields.get(4).getText() + " ## TEXT is " + fields.get(4).getText().equals("My Story"));
                    break;
                case 5:
                    Assert.assertEquals(fields.get(5).getText(), "Health Interests:");
                    log.info(fields.get(5).getText() + " ## TEXT is " + fields.get(5).getText().equals("Health Interests:"));
                    break;
                case 6:
                    Assert.assertEquals(fields.get(6).getText(), "View Connections");
                    log.info(fields.get(6).getText() + " ## TEXT is " + fields.get(6).getText().equals("View Connections"));
                    break;
                case 7:
                    Assert.assertEquals(fields.get(7).getText(), "View Groups");
                    log.info(fields.get(7).getText() + " ## TEXT is " + fields.get(7).getText().equals("View Groups"));
                    break;
            }
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

