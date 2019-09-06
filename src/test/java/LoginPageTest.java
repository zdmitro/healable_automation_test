import org.testng.annotations.Test;
import pages.HomePage;

public class LoginPageTest extends BaseTest {

    @Test
    public void validLoginPage() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver()); //
        homePage
                .goToLoginPage()
                .validateLoginPage();
    }

    @Test(priority = 1)
    public void validateLoginPageElements () throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage()
                .checkForElementsDisplayed_LoginPage();
    }



}
