package SharonProject.utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import test.java.utilities.Log;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by SMaymonX054905 on 07/08/2017.
 */
public class Functions {
    public static ExtentReports extent;
    public static ExtentTest test;
    public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
    public Functions() {
    }

    public static String timeStamp() {
        Log.info("Functions.timeStamp: start:");
        String timeStamp = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")).format(new Date());
        return timeStamp;
    }

    public static String getData(String nodeName) throws ParserConfigurationException, SAXException, IOException {
        Log.info("going to read from config.xml file");
        File fXmlFile = new File(".\\projectConfig\\config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        Log.info("read from config.xml file done");
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void screenShot(WebDriver driver, String testName, String testTimestamp) throws IOException {
        try {
            Log.info("going to take screenShot");
            File e = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(e, new File("C:\\SelTest\\" + testTimestamp + testName + ".jpg"));
            Log.info("screenShot taken: " + testTimestamp + "_" + testName + ".jpg");
        } catch (Exception var4) {
            Log.error("take screenshot failed");
            Log.error(var4);
        }}
/**
    public static void InstanceReport() throws ParserConfigurationException, SAXException, IOException
    {
       extent = new ExtentReports(getData("ReportFilePath") + getData("ReportFileName") + timeStamp + ".html", true);
   }

   public static void initReportTest(String testName, String testDescription)
    {
        test = extent.startTest(testName, testDescription);
   }

   // public static void finalizeReportTest()
   // {
    //   extent.endTest(test);
 //  }

    public static void finalizeExtentReport()
    {
       extent.flush();
        driver.close();
    }
  */

    }

