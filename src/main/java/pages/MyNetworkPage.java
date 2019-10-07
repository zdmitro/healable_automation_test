package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyNetworkPage extends BasePage {
    public MyNetworkPage(WebDriver driver) { super(driver); }

    private By connections = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-network/ion-content/div[2]/div/ion-row/ion-col[2]/div/ion-grid/ion-row/ion-col[2]/button/span/b");
    private By search = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-network/ion-content/div[2]/div/ion-row/ion-col[2]/div/ion-grid/ion-row/ion-col[1]/button");
    private By requests = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-network/ion-content/div[2]/div/ion-row/ion-col[2]/div/ion-grid/ion-row/ion-col[3]/button");

    public MyNetworkPage validateMyNetworkTabs() throws InterruptedException {

        Thread.sleep(2000);
        assertEquals(this.connections, "Connections");
        assertEquals(this.search, "Search");
        assertEquals(this.requests, "Requests  ");

        System.out.println(readText(connections));
        System.out.println(readText(search));
        System.out.println(readText(requests));

        return this;

    }

}
