package org.som;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestSelenium07_Selenium_Commands {
    public static void main(String[] args) {

        WebDriver driver = new SafariDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        driver.quit();
    }
}
