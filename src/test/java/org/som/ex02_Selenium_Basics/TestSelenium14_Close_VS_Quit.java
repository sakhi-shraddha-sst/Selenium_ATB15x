package org.som.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium14_Close_VS_Quit {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com");

        Thread.sleep(10000);


        driver.close();
        // close will close the current window, not the session(not all the tabs/windows
        // session is != null
        //
         driver.quit();
        // It will close all the tabs - session id = null
    }
}


