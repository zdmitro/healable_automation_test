import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {
    //Does not require constructor because it sees Test and understand that it relates to test

    @Test
    public void validHomePageTest_OpenPage() {
        HomePage homePage_object = new HomePage(getDriver());
        homePage_object.
                goToHomePage_method();
    }

    @Test
    public void validateHomePageTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToHomePage_method()
                .validateHomePage();
    }
}
