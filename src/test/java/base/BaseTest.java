package base;

import com.companyName.Report.AllureManager;
import com.companyName.Utils.PropertiesFile;
import com.companyName.Utils.TestListener;
import com.companyName.driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners({TestListener.class})
public class BaseTest {
    public static WebDriver driver;

    @Parameters({"browser", "env"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, @Optional("dev") String env) {
        PropertiesFile.setPropertiesFile();
        if (browser.contains("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();

            // set driver run on Default profile
//            String userName = System.getProperty("user.name");
//            String userProfile = "C:/Users/" + userName + "/AppData/Local/Google/Chrome/User Data";
//            chromeOptions.addArguments("--user-data-dir=" + userProfile);
//            chromeOptions.addArguments("profile-directory=Default");
            WebDriverManager.chromedriver().setup();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.setHeadless(true);
            driver = new ChromeDriver(chromeOptions);

        } else if (browser.contains("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            // WebDriverManager.firefoxdriver().setup();
            WebDriverManager.firefoxdriver().avoidBrowserDetection().setup();
            firefoxOptions.setHeadless(true);
            driver = new FirefoxDriver(firefoxOptions);

        } else if (browser.contains("safari")) {
            SafariOptions safariOptions = new SafariOptions();
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver(safariOptions);
        }
        String url = null;
        if (env.contains("dev")) {
            url = PropertiesFile.getPropValue("url_dev");
            driver.get(url);
        } else if (env.contains("test")) {
            url = PropertiesFile.getPropValue("url_test");
            driver.get(url);
        } else if (env.contains("prod")) {
            url = PropertiesFile.getPropValue("url_prod");
            driver.get(url);
        }
        AllureManager.setAllureEnvironmentInformation(url, browser, env);

        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
