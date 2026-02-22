package org.som;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium03 {
    public static void main(String[] args) {
        //Selenium 3 -
        //System.getProperty("webdriver.gecko.driver","/path/geckdriver");

        ChromeDriver driver = new ChromeDriver();
        // new FirefoxDriver(); - This START of the Selenium Session
        // Sesion - Fresh copy of browser is started!.
        // POST request to the Server - Firefox Driver.

        driver.get("https://sdet.live");
        // Commmand number 2 - POST request to give to the driver to navigate to a URL

    }
}
