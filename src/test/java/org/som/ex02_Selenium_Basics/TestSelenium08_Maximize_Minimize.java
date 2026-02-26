package org.som.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestSelenium08_Maximize_Minimize {
    public static void main(String[] args) {

        WebDriver driver = new SafariDriver();

        driver.manage().window().maximize();

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        driver.manage().window().minimize();
        driver.manage().window().maximize();

        driver.quit();
    }
}
