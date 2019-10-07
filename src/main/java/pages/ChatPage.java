package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatPage extends BasePage {
    public ChatPage(WebDriver driver) { super(driver); }

    private By startNewChat = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-healablechat/ion-content/div[2]/div/p");
    private By startChat = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-healablechat/ion-content/div[2]/div/ion-row/div");

    public ChatPage validateStartNewChat() throws InterruptedException {

        Thread.sleep(2000);
        assertEquals(this.startNewChat, "---- Start New Chat ----");
        assertEquals(this.startChat, "START CHAT");

        System.out.println(readText(startNewChat));
        System.out.println(readText(startChat));
        return this;
    }

}
