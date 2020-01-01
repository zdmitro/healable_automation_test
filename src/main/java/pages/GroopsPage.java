package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GroopsPage extends BasePage {
    private static final Logger log = Logger.getLogger(GroopsPage.class);

    public GroopsPage(WebDriver driver) { super(driver); }

    private By discoverBtn = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-groups/ion-content/div[2]/div/ion-row/ion-col[2]/div/ion-grid/ion-row[1]/ion-col[2]/button");
    private By createBtn = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-groups/ion-content/div[2]/div/ion-row/ion-col[3]/div");

    public GroopsPage validateDiscoverAndCreate() throws InterruptedException {
        Thread.sleep(2000);
        log.info("validateDiscoverAndCreate");
        assertEquals(discoverBtn, "Discover groups");
        log.info(readText(this.discoverBtn) + " ## TEXT is " + readText(this.discoverBtn).equals("Discover groups"));
        assertEquals(createBtn, "Create group");
        log.info(readText(this.createBtn) + " ## TEXT is " + readText(this.createBtn).equals("Create group"));

        return this;
    }

}
