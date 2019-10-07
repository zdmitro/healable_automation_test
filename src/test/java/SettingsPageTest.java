import javafx.scene.layout.Priority;
import org.testng.annotations.Test;
import pages.HomePage;

import static data.Data.LOGIN;
import static data.Data.PASSWORD;

public class SettingsPageTest extends BaseTest{

    @Test
    public void validateSettingsPage() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToSettingsPage(LOGIN, PASSWORD)
                .validateAccountAndGeneral();
    }

    @Test(priority = 1)
    public void SettingsPageCheckForElements() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage
                .goToSettingsPage(LOGIN, PASSWORD)
                .validateFields1();

    }
}
