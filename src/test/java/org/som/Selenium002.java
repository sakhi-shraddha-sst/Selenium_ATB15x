package org.som;

import org.openqa.selenium.safari.SafariDriver;

public class Selenium002 {
    public static void main(String[] args) {
        SafariDriver driver = new SafariDriver();
        driver.get("http://app.vwo.com");
        driver.quit();
    }
}
