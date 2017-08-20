package SharonProject.testScenario;

import SharonProject.testNG.TestNGFramework;
import SharonProject.utilities.Log;
import jdk.internal.org.xml.sax.SAXException;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by SMaymonX054905 on 12/08/2017.
 */
public class FilesTest extends TestNGFramework {
    static SharonProject.pageObjects.WorkingWithFiles F;
    static SharonProject.utilities.Functions D;
    static SharonProject.pageObjects.DB C;

    @Test
    public void Sharon() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
        try {
          Log.startTC("Excel");
          C.DB();
         //   Assert.assertEquals("Failed", "Hili",C.DB());
/**
          F.WriteExcel("/test/SharonT/SharonT.xls");
           D.initReportTest("test3_Excel", "verify: ExcelTest");
           Thread.sleep(3000);
         //  F.ReadExcel("/test/SharonT/SharonT.xls");
            Thread.sleep(3000);
            F.xmlReader("/test/XMLTest.xml");
            Thread.sleep(3000);
            F.TxtReader("/test/SharonTest.txt");
            F.JsonReader("/test/SharonTest.Json");
           Thread.sleep(6000);
 */
         //   Assert.assertEquals("Roni", C.DB());
            Log.endTC("ExcelTest");
        } catch (Exception var8) {
            Log.error(var8);
              Assert.fail("Error: " + var8);

        } finally {
          System.out.print("Great Excel");
        }

    }}


