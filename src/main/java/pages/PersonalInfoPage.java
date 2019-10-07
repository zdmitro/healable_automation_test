package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class PersonalInfoPage extends BasePage {

    public PersonalInfoPage(WebDriver driver) { super(driver); }

    public PersonalInfoPage validatePersonalInfoLabels() throws InterruptedException {

        Thread.sleep(2000);
        List<WebElement> elements = getDriver().findElements(By.tagName("h6"));

        for (int i = 0; i <= 5; i++) {
            System.out.println(elements.get(i).getText());
            switch (i) {
                case 0:
                    Assert.assertEquals(elements.get(0).getText(), "Replace");
                    break;
                case 1:
                    Assert.assertEquals(elements.get(1).getText(), "Personal Info");
                    break;
                case 2:
                    Assert.assertEquals(elements.get(2).getText(), "My Story");
                    break;
                case 3:
                    Assert.assertEquals(elements.get(3).getText(), "Health Interests:");
                    break;
                case 4:
                    Assert.assertEquals(elements.get(4).getText(), "View Connections");
                    break;
                case 5:
                    Assert.assertEquals(elements.get(5).getText(), "View Groups");
                    break;
            }
        }
        return this;
    }

}
