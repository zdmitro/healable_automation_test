import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertiesReader;

public abstract class BaseTest {

    private WebDriver driver; // initiated webdriver

    @BeforeMethod
    public void setUp() {
        /*
        Every Testing scenario should be executed on some specific testing environment. The testing environment can be a web browser, Mobile device, mobile emulator, mobile simulator, etc.

        The Desired Capabilities Class helps us to tell the webdriver, which environment we are going to use in our test script.
         */
        PropertiesReader propertiesReader = new PropertiesReader();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true); //We allow execution of javaScript
        System.setProperty("webdriver.chrome.driver", propertiesReader.getChromeDriver());
        this.driver = new ChromeDriver();
        this.driver.manage().deleteAllCookies();
        this.driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (this.driver != null) {
            this.driver.manage().deleteAllCookies();
            //this.driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}