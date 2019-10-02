package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyNetworkPage extends BasePage {
    public MyNetworkPage(WebDriver driver) { super(driver); }

    //private By startChat = By.xpath("//*[@id='tabpanel-t0-0']/page-healablechat/ion-content/div[2]/div/ion-row/div/span");
    private By connections = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-network/ion-content/div[2]/div/ion-row/ion-col[2]/div/ion-grid/ion-row/ion-col[2]/button/span/b");

    public MyNetworkPage validateConnections() throws InterruptedException {

        Thread.sleep(2000);
        assertEquals(this.connections, "Connections");
        return this;

    }

}
