import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertiesReader;

import java.util.concurrent.TimeUnit;

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

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-popup-blocking", "true");
        chromeOptions.addArguments("--headless");
        this.driver = new ChromeDriver(chromeOptions);

//        WebDriverManager.firefoxdriver().setup();
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//
//        WebDriverManager.operadriver().setup();
//        OperaOptions operaOptions = new OperaOptions();
//
//        WebDriverManager.phantomjs().setup();
//
//        WebDriverManager.edgedriver().setup();
//        WebDriverManager.iedriver().setup();
        this.driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        this.driver.manage().deleteAllCookies();
        this.driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (this.driver != null) {
            this.driver.manage().deleteAllCookies();
            this.driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}