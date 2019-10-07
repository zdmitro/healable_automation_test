package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GroopsPage extends BasePage {

    public GroopsPage(WebDriver driver) { super(driver); }

    private By discoverBtn = By.id("discoverGroup");
    private By createBtn = By.id("newGroup");

    public GroopsPage validateDiscoverAndCreate() throws InterruptedException {

        Thread.sleep(2000);
        assertEquals(discoverBtn, "  Discover");
        assertEquals(createBtn, "Create");
        return this;
    }

}
