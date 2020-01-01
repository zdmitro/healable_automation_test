import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.HomePage;

import static data.Data.*;

public class AccountPageTest extends BaseTest {

    private static final Logger log = Logger.getLogger(LoginPageTest.class);

    /**
     * Opens account page.
     * Validates Account Page using the user name
     */

    @Test
    public void validAccountPage() throws InterruptedException {
        log.info("Run Autotest to validate Account Home Page");
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToAccountPage(LOGIN, PASSWORD)
                .validateAccountPage(USERNAME);
    }

    /**
     * Opens login page and verifies that all the elements are present.
     *
     *  smallEmblem,
     *  searchField,
     *  homeBtn,
     *  videoCallBtn,
     *  chatBtn,
     *  groupsBtn,
     *  notificationsBtn,
     *  settingsBtn,
     *  profileBtn,
     *  createPostBtn,
     *  userPhoto
     */

    @Test(priority = 1)
    public void validateDisplayedElements() throws InterruptedException {
        log.info("Run Autotest to validate Account Home Page");
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToAccountPage(LOGIN,PASSWORD)
                .checkElementsDisplayed();
    }





}
