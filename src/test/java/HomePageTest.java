import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {
    //Does not require constructor because it sees Test and understand that it relates to test
    private static final Logger log = Logger.getLogger(SettingsPageTest.class);

    /**
     * Opens Homepage
     *
     */

    @Test
    public void validHomePageTest_OpenPage() {
        HomePage homePage_object = new HomePage(getDriver());
        log.info("RUN AUTOTEST TO VALIDATE HOMEPAGE PAGE");
        homePage_object.
                goToHomePage_method();
    }

    /**
     * Opens Homepage
     * Validates Settings Page by verifying Account and General headers
     */

    @Test
    public void validateHomePageTest() {
        HomePage homePage = new HomePage(getDriver());
        log.info("RUN AUTOTEST TO VALIDATE HOMEPAGE");
        homePage
                .goToHomePage_method()
                .validateHomePage();
    }
}
