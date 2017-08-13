package SharonProject.testScenario;

import SharonProject.utilities.Log;
import jdk.internal.org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by SMaymonX054905 on 12/08/2017.
 */
public class FilesTest {
    static SharonProject.pageObjects.WorkingWithFiles F;
    @org.testng.annotations.Test
    public void Sharon() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
        try {

          Log.startTC("Excel");
          F.WriteExcel("/test/SharonT/SharonT.xls");
            // initReportTest("test2_Calc", "verify: CalcTest");
            Thread.sleep(3000);
           F.ReadExcel("/test/SharonT/SharonT.xls");
            Thread.sleep(3000);
           F.xmlReader("/test/XMLTest.xml");
            Thread.sleep(3000);
           F.TxtReader("/test/SharonTest.txt");
           F.JsonReader("/test/SharonTest.Json");
            Thread.sleep(6000);
            Log.endTC("ExcelTest");
        } catch (Exception var8) {
            Log.error(var8);
            //    Assert.fail("Error: " + var8);

        } finally {
          System.out.print("Great Excel");
        }

    }}


