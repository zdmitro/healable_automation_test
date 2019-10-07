import org.testng.annotations.Test;
import pages.HomePage;

import static data.Data.*;

public class AccountPageTest extends BaseTest {

    @Test
    public void validAccountPage() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToAccountPage(LOGIN, PASSWORD)
                .validateAccountPage(USERNAME);

    }

    @Test(priority = 1)
    public void validateDisplayedElements() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToAccountPage(LOGIN,PASSWORD)
                .checkElementsDisplayed();
    }





}
