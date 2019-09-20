import org.testng.annotations.Test;
import pages.HomePage;

import static data.Data.LOGIN;
import static data.Data.PASSWORD;

public class AccountPageTest extends BaseTest {

    @Test
    public void validAccountPage() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToAccountPage(LOGIN, PASSWORD)
                .validateAccountPage();

    }

    public void goToVideoCall() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .login(LOGIN,PASSWORD);



    }
}
