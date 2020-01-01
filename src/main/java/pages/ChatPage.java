package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatPage extends BasePage {
    /*********Constructor**********/
    public ChatPage(WebDriver driver) { super(driver); }

    /*************PAGE INSTANTIATIONS*************/
    private static final Logger log = Logger.getLogger(ChatPage.class);

    /*********Web Elements*********/
    private By startNewChat = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-healablechat/ion-content/div[2]/div/p");
    private By startChat = By.xpath("/html/body/ion-app/ng-component/ion-nav/page-wall/ion-tabs/ion-tab[1]/page-healablechat/ion-content/div[2]/div/ion-row/div");

    /************* Methods ************/
    public ChatPage validateStartNewChat() throws InterruptedException {

        Thread.sleep(2000);
        assertEquals(this.startNewChat, "---- Start New Chat ----");
        log.info(readText(this.startNewChat) + " ## TEXT is " + readText(this.startNewChat).equals("---- Start New Chat ----"));

        assertEquals(this.startChat, "Start chat");
        log.info(readText(this.startChat) + " ## TEXT is " + readText(this.startChat).equals("Start chat"));

        System.out.println(readText(startNewChat));
        System.out.println(readText(startChat));
        log.info("validateStartNewChat");

        return this;
    }

}
