package org.som;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class TestSelenium12_Navigation_Get_NavigateTo {

    @Test
   public void test_Selenium02() throws InterruptedException {
       WebDriver driver = new SafariDriver();
         driver.get("https://www.google.com"); // 95% of the time we use get() method to navigate to a URL

        // Use Navigation commands
        // driver.navigate().to("https://www.google.com");
        // This is an alternative to get() method, but it is less commonly used

        driver.navigate().to("https://www.google.com");
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().back();

        Thread.sleep(10000);
        driver.quit();


   }
}


