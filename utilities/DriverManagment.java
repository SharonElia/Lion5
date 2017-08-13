package SharonProject.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by SMaymonX054905 on 07/08/2017.
 */
public class DriverManagment {

    public DriverManagment() {
    }

    public static WebDriver initBrowser(String browserType) throws ParserConfigurationException, SAXException, IOException {
        Object seleniumDriver = null;

        try {
            if(browserType.toLowerCase().equals("firefox")) {
                Log.info("going to initialize firefox driver");
                seleniumDriver = new FirefoxDriver();
                ((WebDriver)seleniumDriver).manage().window().maximize();
                ((WebDriver)seleniumDriver).manage().timeouts().implicitlyWait((long)Integer.parseInt(test.java.utilities.Functions.getData("implicitlyWaitTime")), TimeUnit.SECONDS);
                ((WebDriver)seleniumDriver).manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
            } else if(browserType.toLowerCase().equals("ie")) {
                Log.info("going to initialize ie driver");
                System.setProperty("webdriver.ie.driver", test.java.utilities.Functions.getData("IEDriverPath"));
                seleniumDriver = new InternetExplorerDriver();
                ((WebDriver)seleniumDriver).manage().window().maximize();
                ((WebDriver)seleniumDriver).manage().timeouts().implicitlyWait((long)Integer.parseInt(test.java.utilities.Functions.getData("implicitlyWaitTime")), TimeUnit.SECONDS);
                ((WebDriver)seleniumDriver).manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
            } else if(browserType.toLowerCase().equals("chrome")) {
                Log.info("going to initialize chrome driver");
                System.setProperty("webdriver.chrome.driver", test.java.utilities.Functions.getData("ChromeDriverPath"));
                Log.info("going to create chrome driver object");
                seleniumDriver = new ChromeDriver();
                ((WebDriver)seleniumDriver).manage().window().maximize();
                ((WebDriver)seleniumDriver).manage().timeouts().implicitlyWait((long)Integer.parseInt(test.java.utilities.Functions.getData("implicitlyWaitTime")), TimeUnit.SECONDS);
                ((WebDriver)seleniumDriver).manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
            }
        } catch (Exception var3) {
            Log.error(var3);
            Assert.fail("Error: " + var3);
        }

        Log.info("driver object created");
        return (WebDriver)seleniumDriver;
    }



    public static void terminateDriver(WebDriver driver) {
        try {
            Log.info("going to quit driver");
            driver.quit();
            Log.info("quit driver done");
        } catch (Exception var2) {
            Log.error("quit driver failed");
            Log.error(var2);
            Assert.fail("Error: " + var2);
        }

    }
}

