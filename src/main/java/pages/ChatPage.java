package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatPage extends BasePage {
    public ChatPage(WebDriver driver) { super(driver); }

    //private By startChat = By.xpath("//*[@id='tabpanel-t0-0']/page-healablechat/ion-content/div[2]/div/ion-row/div/span");
    private By startChat = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-healablechat/ion-content/div[2]/div/p");

    public ChatPage validateStartNewChat() throws InterruptedException {

        Thread.sleep(2000);
        assertEquals(this.startChat, "---- Start New Chat ----");
        return this;

    }

}
