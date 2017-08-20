package SharonProject.testScenario;

import SharonProject.pageObjects.Calc;
import SharonProject.testNG.TestNGFramework;
import SharonProject.utilities.Functions;
import SharonProject.utilities.Log;
import jdk.internal.org.xml.sax.SAXException;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;



/**
 * Created by SMaymonX054905 on 09/08/2017.
 */
public class CalcTest extends TestNGFramework{

    static SharonProject.utilities.Functions F;

        public CalcTest() {
        }

    @Test
    public void Test1() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
        try {

            Log.startTC("CalcTest");
            F.initReportTest("test1_Calc", "verify: CalcTest");
            driver.get("http://juliemr.github.io/protractor-demo/");

            Calc.Calc();

            Thread.sleep(6000);
            Log.endTC("CalcTest");
        } catch (Exception var8) {
            F.screenShot(driver, "CalcTest", Functions.timeStamp());
            Log.error(var8);
            Assert.fail("Error: " + var8);
        } catch (AssertionError var9) {
            F.screenShot(driver, "CalcTest", Functions.timeStamp());
            Log.error(var9);
            Assert.fail("Error: " + var9);
        } finally {
            driver.get("https://www.wooloverslondon.com/");
        }
    }

        }

