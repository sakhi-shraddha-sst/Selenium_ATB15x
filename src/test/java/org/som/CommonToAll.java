package org.som;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonToAll {

    public ChromeDriver driver;

    public static void openBrowser(WebDriver driver, String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static  void closeBrowser(WebDriver driver){
        driver.quit();
    }

    public static void clickElementFound(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

}
