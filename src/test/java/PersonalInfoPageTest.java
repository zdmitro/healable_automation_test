import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;

import static data.Data.LOGIN;
import static data.Data.PASSWORD;

public class PersonalInfoPageTest extends BaseTest {
    private static final Logger log = Logger.getLogger(LoginPageTest.class);

    /**
     * Opens page with personal information details (clicks on the picture icon on the top bar (right corner)
     * Validates personal information page
     */

    @Test
    public void validatePersonalInfoPage() throws InterruptedException {
        log.info("RUN AUTOTEST TO VALIDATE PERSONAL DETAILS AND INFORMATION PAGE");
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToPersonalInfoPageRightButton(LOGIN, PASSWORD)
                .validatePersonalInfoPage();
    }

    /**
     * Opens page with personal information details (clicks on the picture icon on the top bar (right corner)
     * Validates personal information page
     */
    @Test
    public void verifyHeaders() throws InterruptedException {
        log.info("RUN AUTOTEST TO VERIFY HEADERS ON PERSONAL INFO PAGE");
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToPersonalInfoPageRightButton(LOGIN, PASSWORD)
                .verifyHeaders();
    }

}
