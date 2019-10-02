import org.testng.annotations.Test;
import pages.HomePage;

import static data.Data.LOGIN;
import static data.Data.PASSWORD;

public class MyNetworkPageTest extends BaseTest {

    @Test
    public void validateMyNetworkPage() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToMyNetworkPage(LOGIN,PASSWORD)
                .validateConnections();
    }

}
