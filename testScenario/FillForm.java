package SharonProject.testScenario;
import SharonProject.testNG.TestNGFramework;
import SharonProject.utilities.Constant;
import SharonProject.utilities.ExcelReport;
import SharonProject.utilities.Functions;
import SharonProject.utilities.Log;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by SMaymonX054905 on 22/08/2017.
 */
public class FillForm extends TestNGFramework {


    static SharonProject.pageObjects.FillForms F;
    static SharonProject.utilities.Functions E;
    static SharonProject.utilities.ExcelReport Ex;
    public FillForm() {
    }

    @ Test
    public  void A_downloadPageNavigation() throws Exception{ {
        try {

            Log.startTC("Fill Form");
            driver.get(Constant.URL);
            Thread.sleep(4000);
            E.initReportTest("test2_ShippingTo", "verify: Shipping Report");
            ExcelReport.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
            ExcelReport.FillForm();
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


}}}