package org.som;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitHelpers {

    public static void waitJVM(int time){
        try {
            time = time * 1000;
//            long seconds = time * 1000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitImplicitWait(WebDriver driver, int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public static void checkVisibilityOfElement(WebDriver driver, By locator, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void checkElementToBeClickable(WebDriver driver, By locator, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void checkPresenceOfElementLocated(WebDriver driver, By locator, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void checkVisibilityOfAndTextToBePresentInElement(WebDriver driver, WebElement element, int time, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }
    public static void waitForAlert(WebDriver driver, int timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForTitle(WebDriver driver, int timeInSeconds, String title){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static WebElement checkVisibilityByFluentWait(WebDriver driver, By locator){

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

        WebElement error_message = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return error_message;
    }

}
