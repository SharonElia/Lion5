package SharonProject.testScenario;

import SharonProject.pageObjects.ShippingTo;
import SharonProject.testNG.TestNGFramework;
import SharonProject.utilities.Functions;
import SharonProject.utilities.Log;
import org.testng.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
/**
 * Created by SMaymonX054905 on 07/08/2017.
 */
public class ShippingToCase extends TestNGFramework {

    public   ShippingToCase() {
    }

    @ Test
    public  void A_downloadPageNavigation() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
        try {

           Log.startTC("Shipping To");
            driver.get("https://www.wooloverslondon.com/");
            Thread.sleep(4000);
        //    initReportTest("test1_ShippingTo", "verify: SharonTest");
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
            Functions.screenShot(driver, "Shipping To", Functions.timeStamp());
            Log.error(var8);
        //    Assert.fail("Error: " + var8);
        } catch (AssertionError var9) {
            Functions.screenShot(driver, "Shipping To", Functions.timeStamp());
            Log.error(var9);
         //   Assert.fail("Error: " + var9);
        } finally {
           driver.get("https://www.wooloverslondon.com/");
        }








    }
}
