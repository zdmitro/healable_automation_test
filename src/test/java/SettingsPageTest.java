import javafx.scene.layout.Priority;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static data.Data.LOGIN;
import static data.Data.PASSWORD;

public class SettingsPageTest extends BaseTest{
    private static final Logger log = Logger.getLogger(SettingsPageTest.class);

    /**
     * Opens Settings Page
     * Validates Settings Page by verifying Account and General headers
     */

    @Test
    public void validateSettingsPage() throws InterruptedException {
        log.info("RUN AUTOTEST TO VALIDATE SETTINGS PAGE");
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToSettingsPage(LOGIN, PASSWORD)
                .validateAccountAndGeneral();
    }

    /**
     * Opens Settings Page
     * Verifies the the following headers and links are present
     *
     * My Posts
     * Invite Users
     * Book Appointment
     * Notification Settings
     * Privacy Settings
     * Connection Requests
     * Change Password
     * Edit Profile
     * Version 1
     * Logout
     */

    @Test(priority = 1)
    public void SettingsPageCheckForElements() throws InterruptedException {
        log.info("RUN AUTOTEST TO VERIFY THAT THE ELEMENTS ARE PRESENT ON THE PAGE");
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToSettingsPage(LOGIN, PASSWORD)
                .validateFields();

    }
}
