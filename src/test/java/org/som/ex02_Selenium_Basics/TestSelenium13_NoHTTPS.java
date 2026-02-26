package org.som.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestSelenium13_NoHTTPS {

    public static void main(String[] args) {

        WebDriver driver = new SafariDriver();
        driver.get("bing.com"); // Https is important if you forget to add https,
        // it will not work, it will throw an error, because it will try to navigate to
        // http://bing.com which is not valid, so always remember to add https:// before the URL

        driver.get("https://www.bing.com"); // Https is important

    }
}


