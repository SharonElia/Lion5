package SharonProject.testNG;

import SharonProject.utilities.DriverManagment;
import SharonProject.utilities.Functions;
import SharonProject.utilities.Log;
import org.openqa.selenium.WebDriver;


//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.xml.sax.SAXException;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by SMaymonX054905 on 07/08/2017.
 */
public class TestNGFramework  {

    public static WebDriver driver;
    public static String testTimestamp;
  //  public static Functions report;
    public TestNGFramework() {
    }

    @Before
    public  void beforeTest() {
        Log.info("-------------------------------------");
        Log.info("-    Test execution: start          -");
        Log.info("-------------------------------------");

    }

    @After
    public  void afterTest() {
        Log.info("-----Test execution: end ------------");
       // report.finalizeReportTest();
    }

    @BeforeClass
    public static void startSession() throws ParserConfigurationException, SAXException, IOException {

   //   report.InstanceReport();
        Log.info("BeforeClass execution: start");
        driver = DriverManagment.initBrowser(Functions.getData("browser"));
    }

    @AfterClass
    public static void closeSession() {
      // report.finalizeExtentReport();
        DriverManagment.terminateDriver(driver);
        Log.info("AfterClass execution: end");
    }
}
