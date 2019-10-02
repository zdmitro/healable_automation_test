import org.testng.annotations.Test;
import pages.HomePage;

import static data.Data.LOGIN;
import static data.Data.PASSWORD;

public class ChatPageTest extends BaseTest {

    @Test
    public void validateVideoCallPage() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToChatPage(LOGIN,PASSWORD)
                .validateStartNewChat();
    }
}
