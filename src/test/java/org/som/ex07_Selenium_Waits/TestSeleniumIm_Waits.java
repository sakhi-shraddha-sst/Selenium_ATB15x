package org.som.ex07_Selenium_Waits;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSeleniumIm_Waits {
    @Owner("Sakhi Mali")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Ebay Print the prices (iMac)")
    @Test
    public void test_verify_print_imac_price() {

        SafariDriver driver = new SafariDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.ebay.com/");

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("password@321");


        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();


    }
    }
