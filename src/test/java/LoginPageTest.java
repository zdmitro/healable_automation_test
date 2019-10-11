import org.testng.annotations.Test;
import utils.FileReader;
import pages.HomePage;

import java.util.List;

import static data.Data.*;

public class LoginPageTest extends BaseTest {

    private final FileReader fileReader = new FileReader("src/main/resources/testDataFiles/login_data.txt");
    private final List<String> dataList = fileReader.getDataList();

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