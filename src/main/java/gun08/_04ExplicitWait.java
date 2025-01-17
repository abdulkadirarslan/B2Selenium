package gun08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;

public class _04ExplicitWait {

    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void dialogProcess(){

        driver = Utils.getChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/modal-dialogs");

        //driver.findElement(By.id("showSmallModal")).click();
        click(By.id("showSmallModal"));

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("closeSmallModal"))).click();
        click(driver, 5, By.id("closeSmallModal"));
        //click(By.id("closeSmallModal"));

        // wait = new WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("closeSmallModal")));


        driver.quit();


    }

    void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    void click(WebDriver driver, By locator){
        click(driver, 10, locator);
    }

    void click(WebDriver driver, int seconds, By locator){
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


}
