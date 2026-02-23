package org.som;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium11_TestNG_Example {

    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();
        driver = new ChromeDriver();

        // Interview question:
        // Can we change the browser driver in between the test execution?
        // Yes, we can change the browser driver in between the test execution by creating a new instance of the desired browser driver
        // and assigning it to the existing WebDriver variable.
        // However, it is important to note that this will not affect any existing browser sessions
        // that were created with the previous driver instance.
        // Each driver instance will manage its own browser session,
        // so if you switch to a new driver, you will need to start a new browser session with that driver.
        // Additionally, it is important to properly close any existing browser sessions
        // before switching to a new driver to avoid resource leaks and
        // ensure that the test environment remains clean.
    }
}


