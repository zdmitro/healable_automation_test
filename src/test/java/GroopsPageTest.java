import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.ChatPage;
import pages.HomePage;

import static data.Data.LOGIN;
import static data.Data.PASSWORD;

public class GroopsPageTest extends BaseTest {
    private static final Logger log = Logger.getLogger(GroopsPageTest.class);
    /**
     * Opens Groops page and validates it.
     *
     */
    @Test
    public void validateGroopsPage() throws InterruptedException {
        log.info("RUN AUTOTEST TO VALIDATE GROOPS PAGE");
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToGroopsPage(LOGIN, PASSWORD)
                .validateDiscoverAndCreate();
    }
}
