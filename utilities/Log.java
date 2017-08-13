package SharonProject.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by SMaymonX054905 on 07/08/2017.
 */
public class Log {

    private static Logger Log = Logger.getLogger("AutoTest");

    public Log() {
    }

    public static void info(String message) {
        PropertyConfigurator.configure("C://SelTest/projectConfig/log4j.properties");
        Log.info(message);
    }

    public static void error(String message) {
        PropertyConfigurator.configure("C://SelTest/projectConfig/log4j.properties");
        Log.error(message);
    }

    public static void error(Exception e) {
        PropertyConfigurator.configure("C://SelTest/projectConfig/log4j.properties");
        Log.error(e);
    }

    public static void error(AssertionError e) {
        PropertyConfigurator.configure("C://SelTest/projectConfig/log4j.properties");
        Log.error(e);
    }

    public static void warn(String message) {
        PropertyConfigurator.configure("C://SelTest/projectConfig/log4j.properties");
        Log.warn(message);
    }

    public static void fatal(String message) {
        PropertyConfigurator.configure("C://SelTest/projectConfig/log4j.properties");
        Log.fatal(message);
    }

    public static void debug(String message) {
        PropertyConfigurator.configure("C://SelTest/projectConfig/log4j.properties");
        Log.debug(message);
    }

    public static void startTC(String testCaseName) {
        PropertyConfigurator.configure("./projectConfig/log4j.properties");
        Log.info("TestCase started: " + testCaseName);
    }

    public static void endTC(String testCaseName) {
        PropertyConfigurator.configure("./projectConfig/log4j.properties");
        Log.info("TestCase ended: " + testCaseName);
    }
}
