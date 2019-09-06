import org.testng.annotations.Test;
import pages.HomePage;

public class LoginPageTest extends BaseTest {

    @Test
    public void validLoginPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage();
    }

    @Test(priority = 1)
    public void validateLoginPageElements() {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage()
                .checkForElementsDisplayed_LoginPage();
    }

}