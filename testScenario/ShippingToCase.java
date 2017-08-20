package SharonProject.testScenario;
import jdk.internal.org.xml.sax.SAXException;
import SharonProject.pageObjects.ShippingTo;
import SharonProject.testNG.TestNGFramework;
import SharonProject.utilities.Functions;
import SharonProject.utilities.Log;
import org.junit.Test;
import org.testng.Assert;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by SMaymonX054905 on 07/08/2017.
 */
public class ShippingToCase extends TestNGFramework {
    static SharonProject.utilities.Functions E;
    public   ShippingToCase() {
    }

    @ Test
    public  void A_downloadPageNavigation() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
        try {

           Log.startTC("Shipping To");
            driver.get("https://www.wooloverslondon.com/");
            Thread.sleep(4000);
           E.initReportTest("test2_ShippingTo", "verify: Shipping Report");
            ShippingTo.PopUpA(driver).click();
            Thread.sleep(4000);
            ShippingTo.PopUpB(driver).click();
            Thread.sleep(4000);
            ShippingTo.Search(driver).sendKeys("Sharon");
            Thread.sleep(6000);
            Assert.assertTrue(ShippingTo.FindName(driver).isDisplayed());
            Thread.sleep(6000);
            ShippingTo.Search(driver).clear();
            Thread.sleep(6000);
            ShippingTo.Search(driver).sendKeys("women");
            Thread.sleep(6000);
            Assert.assertEquals("WoolOvers", driver.getTitle());
            Thread.sleep(6000);
            Log.endTC("Shipping To");
        } catch (Exception var8) {
            E.screenShot(driver, "Shipping To", Functions.timeStamp());
            Log.error(var8);
            Assert.fail("Error: " + var8);
        } catch (AssertionError var9) {
            E.screenShot(driver, "Shipping To", Functions.timeStamp());
            Log.error(var9);
            Assert.fail("Error: " + var9);
        } finally {
           driver.get("https://www.wooloverslondon.com/");
        }








    }
}
