package org.som.ex02_Selenium_Basics;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium09_Assertion_TestNG {

    @Test
    public void test_selenium01(){

        WebDriver driver = new SafariDriver();
        driver.get("https://www.google.com/");

        driver.manage().window().maximize();
//        TestNG
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");


        Assert.assertEquals(driver.getTitle(), "Google");

        // AssertJ

        assertThat(driver.getTitle())
                .isNotEmpty()
                .isNotNull()
                .isEqualTo("Google");

        driver.quit();
    }
}


// "" - empty string
// null - no value assigned
// " " - blank