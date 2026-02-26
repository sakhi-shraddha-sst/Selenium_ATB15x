package org.som.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSelenium10_TestNG_Example {

    @Test
    public void test_selenium_app_vwo(){

        WebDriver driver = new SafariDriver();
        driver.get("https://app.vwo.com/");

        driver.manage().window().maximize();

        Assert.assertEquals(driver.getTitle(), "Login - VWO");


            driver.quit();
    }
}


// "" - empty string
// null - no value assigned
// " " - blank