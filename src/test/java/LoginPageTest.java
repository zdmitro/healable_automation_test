import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.AccountPage;
import utils.FileReader;
import pages.HomePage;

import java.util.List;

import static data.Data.*;

public class LoginPageTest extends BaseTest {

    private final FileReader fileReader = new FileReader("src/main/resources/testDataFiles/login_data.txt");
    private final List<String> dataList = fileReader.getDataList();
    private static final Logger log = Logger.getLogger(LoginPageTest.class);

    /**
     * Opens login page and validates it.
     * It looks for "Login" button text and "Forgot Password" link text to validate the text
     */

    @Test
    public void validLoginPage() throws InterruptedException {
        log.info("Run Autotest to validate LoginPage");
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoginPage();
    }

    /**
     * Opens login page and verifies that all the elements are present.
     *
     * topBar,
     * logo,
     * loginField,
     * passwordField,
     * passwordFieldEye,
     * forgotPasswordLink,
     * loginButton
     */

    @Test(priority = 1)
    public void validateLoginPageElements() throws InterruptedException {
        log.info("Run Autotest to check if all elements are present on the page");
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .checkForElementsDisplayed_LoginPage();
    }

    /**
     * Opens login page, then clicks on Go Back button provided by the app,
     * goes back to Home page and validates homepage, by verifying
     * text on Login and Sign Up button
     */

    @Test(priority = 2)
    public void goBackToHomePage() throws InterruptedException {
        log.info("Run Autotest to verify Reverse button provided by the app on Login Page");
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .clickOnBackToHomePage()
                .validateHomePage();
    }

    /**
     * Opens login page, then clicks on Forgot Password link and validates
     * Forgot Password page by validating Login field and Forgot Password button
     */

    @Test(priority = 3)
    public void goToForgotPasswordPage() throws InterruptedException {
        log.info("Run Autotest to verify Forgot Password link");
        HomePage homePage = new HomePage(getDriver());

        homePage
                .goToLoginPage()
                .clickOnForgotPassowrd()
                .validateForgotPasswordPage();
    }

    /**
     * Positive Login Autotest: verifies successful login.
     */

    @Test(priority = 4)
    public void loginCorrectCredentials() throws InterruptedException {
        log.info("Login Autotest: positive. Successful login");
        HomePage homePage = new HomePage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());

        homePage
                .goToLoginPage()
                .login(LOGIN,PASSWORD);

        accountPage
                .validateAccountPage(USERNAME);
    }

    /**
     * Positive Login Autotest: verifies successful login.
     */

    @Test(priority = 5)
    public void loginNegTestBothFieldsBlank() throws InterruptedException {
        log.info("Login Autotest: negative. Both Login and Password are blank");

        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .login("","")
                .validateLoginError();
    }

    @Test(priority = 6)
    public void loginNegTest_IncorrectLoginPasswordBlank() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .login("aaaaa12345","")
                .validateLoginError();
    }

    @Test(priority = 7)
    public void loginNegTest_BlankLoginIncorrectPassword() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .login("","aaaaa12345$")
                .validateLoginError();
    }

    @Test(priority = 8)
    public void loginNegTest_CorrectLoginIncorrectPassword() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .login(LOGIN,"aaaaa12345$")
                .validateLoginError();
    }

    @Test(priority = 9)
    public void loginNegTest_IncorrectLoginCorrectPassword() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .login("aaaaa12345",PASSWORD)
                .validateLoginError();
    }

    @Test(priority = 10)
    public void negativeLoginTestsLoop_0() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoopLoginError(dataList.get(0));
    }

    @Test(priority = 11)
    public void negativeLoginTestsLoop_1() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoopLoginError(dataList.get(1));
    }

    @Test(priority = 12)
    public void negativeLoginTestsLoop_2() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoopLoginError(dataList.get(2));
    }

    @Test(priority = 13)
    public void negativeLoginTestsLoop_3() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoopLoginError(dataList.get(3));
    }

    @Test(priority = 14)
    public void negativeLoginTestsLoop_4() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToLoginPage()
                .validateLoopLoginError(dataList.get(4));
    }

}