import org.testng.annotations.Test;
import pages.HomePage;

import static data.Data.LOGIN;
import static data.Data.PASSWORD;

public class PersonalInfoPageTest extends BaseTest {

    @Test
    public void validatePersonalInfoPage() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToPersonalInfoPageRightButton(LOGIN, PASSWORD)
                .validatePersonalInfoLabels();
    }

}
