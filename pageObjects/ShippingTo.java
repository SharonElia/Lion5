package SharonProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import test.java.utilities.Log;

/**
 * Created by SMaymonX054905 on 07/08/2017.
 */
public class ShippingTo {

    private static WebElement element;

    public ShippingTo() {
    }

    public static WebElement PopUpA(WebDriver driver) {
        Log.info("working on element: ShippingTo");
        element = driver.findElement(By.xpath("//*[@class=\'glClose\']"));
        return element;
    }
    public static WebElement PopUpB(WebDriver driver) {
        Log.info("working on element: ShippingTo");
        element = driver.findElement(By.xpath("//*[@id=\'t011-pop-up\']/div[1]"));
        return element;
    }
    public static WebElement Search(WebDriver driver) {
        Log.info("working on element: Search");
        element = driver.findElement(By.xpath("//*[@type='text']"));
        return element;
    }
    public static WebElement FindName(WebDriver driver) {
        Log.info("working on element: FindName: Sale");
        element = driver.findElement(By.xpath("//*[@class='text-uppercase text-center']"));
        return element;
    }

    public static void ChangeCountry(WebDriver driver) {
        Log.info("working on element: ShippingTo");
        Select a = new Select(driver.findElement(By.id("gle_selectedCountry")));
        a.selectByVisibleText("India");
         }
    public static void ChangeCurrency(WebDriver driver) {
        Log.info("working on element: ShippingTo");
        Select b = new Select(driver.findElement(By.id("gle_selectedCurrency")));
        b.selectByVisibleText("Euro");
    }
    public static WebElement Save(WebDriver driver) {
        Log.info("working on element: ShippingTo");
        element = driver.findElement(By.className("//*[@class='glDefaultBtn glCancelBtn']"));
        return element;
    }








}
