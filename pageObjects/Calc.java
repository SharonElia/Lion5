package SharonProject.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static SharonProject.testNG.TestNGFramework.driver;

/**
 * Created by SMaymonX054905 on 09/08/2017.
 */
public class Calc {

    private static WebElement element;
    public static void Calc() throws InterruptedException {
        for(int x = 1; x < 5; ++x) {
            switch (x) {
                case 1:
                    Select i = new Select(driver.findElement(By.xpath("/html/body/div/div/form/select")));
                    i.selectByVisibleText("*");
                    break;
                case 2:
                    Select j = new Select(driver.findElement(By.xpath("/html/body/div/div/form/select")));
                    j.selectByVisibleText("+");
                    break;
                case 3:
                    Select c = new Select(driver.findElement(By.xpath("/html/body/div/div/form/select")));
                    c.selectByVisibleText("-");
                    break;
                case 4:
                    Select d = new Select(driver.findElement(By.xpath("/html/body/div/div/form/select")));
                    d.selectByVisibleText("/");
            }

            for (int var6 = 1; var6 <= 2; ++var6) {
                for (int var7 = 1; var7 <= 2; ++var7) {
                    driver.findElement(By.xpath("/html/body/div/div/form/input[1]")).sendKeys(new CharSequence[]{"" + var6});
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys(new CharSequence[]{"" + var7});
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//*[@id=\'gobutton\']")).click();
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("/html/body/div/div/form/input[1]")).clear();
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("/html/body/div/div/form/input[1]")).clear();
                    Thread.sleep(1000);
                }
            }
        }}}




