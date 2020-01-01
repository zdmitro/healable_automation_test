import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.GroopsPage;
import pages.HomePage;

import static data.Data.LOGIN;
import static data.Data.PASSWORD;

public class VideoCallPageTest extends BaseTest {
    private static final Logger log = Logger.getLogger(GroopsPage.class);

    @Test
    public void validateVideoCallPage() throws InterruptedException {
        log.info("RUN AUTOTEST TO VALIDATE VIDEO CALL PAGE");
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToVideoCall(LOGIN,PASSWORD)
                .validateBookAppointment();
    }
}
