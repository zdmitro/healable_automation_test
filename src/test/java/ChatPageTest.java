import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static data.Data.LOGIN;
import static data.Data.PASSWORD;

public class ChatPageTest extends BaseTest {
    private static final Logger log = Logger.getLogger(ChatPageTest.class);

    /**
     * Opens Chat page and validates it.
     * Looks for "---- Start New Chat ----" label and "Start chat" button
     */
    @Test
    public void validateChatPage() throws InterruptedException {
        log.info("Run Autotest to validate Chat Page");
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToChatPage(LOGIN,PASSWORD)
                .validateStartNewChat();
    }
}
