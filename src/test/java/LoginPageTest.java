import org.testng.annotations.Test;
import pages.HomePage;

import static data.Data.*;

public class LoginPageTest extends BaseTest {

    @Test
    public void validLoginPage() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage();
    }

    @Test(priority = 1)
    public void validateLoginPageElements() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage()
                .checkForElementsDisplayed_LoginPage();
    }

    @Test(priority = 2)
    public void goBackToHomePage() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage()
                .clickOnBackToHomePage()
                .validateHomePage();
    }

    @Test(priority = 3)
    public void goToForgotPasswordPage() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage()
                .clickOnForgotPassowrd()
                .validateForgotPasswordPage();
    }

    @Test(priority = 4)
    public void loginCorrectCredentials() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage()
                .login(LOGIN,PASSWORD);
    }

    @Test(priority = 5)
    public void loginNegTestBothFieldsBlank() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage()
                .login("","")
                .validateLoginError();
    }

    @Test(priority = 6)
    public void loginNegTest_IncorrectLoginPasswordBlank() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage()
                .login("aaaaa12345","")
                .validateLoginError();
    }

    @Test(priority = 7)
    public void loginNegTest_BlankLoginIncorrectPassword() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage()
                .login("","aaaaa12345$")
                .validateLoginError();
    }

    @Test(priority = 8)
    public void loginNegTest_CorrectLoginIncorrectPassword() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage()
                .login(LOGIN,"aaaaa12345$")
                .validateLoginError();
    }

    @Test(priority = 9)
    public void loginNegTest_IncorrectLoginCorrectPassword() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage()
                .login("aaaaa12345",PASSWORD)
                .validateLoginError();
    }

}