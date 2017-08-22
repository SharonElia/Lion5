package SharonProject.pageObjects;

import SharonProject.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by SMaymonX054905 on 22/08/2017.
 */
public class FillForms {

    private static WebElement element;


    public FillForms() {

    }

    public static WebElement Name(WebDriver driver) {
        Log.info("working on element: Name");
        element = driver.findElement(By.xpath("//*[@name='your-name']"));
        return element;
    }

    public static WebElement Email(WebDriver driver) {
        Log.info("working on element: Email");
        element = driver.findElement(By.xpath("//*[@name='your-email']"));
        return element;
    }
    public static WebElement Mobile(WebDriver driver) {
        Log.info("working on element: Mobile");
        element = driver.findElement(By.xpath("//*[@name='your-mobile']"));
        return element;
    }
    public static WebElement Country(WebDriver driver) {
        Log.info("working on element: Country");
        element = driver.findElement(By.xpath("//*[@name='your-country']"));
        return element;
    }
    public static WebElement YourMessage(WebDriver driver) {
        Log.info("working on element: YourMessage");
        element = driver.findElement(By.xpath("//*[@name='your-message']"));
        return element;
    }
}
