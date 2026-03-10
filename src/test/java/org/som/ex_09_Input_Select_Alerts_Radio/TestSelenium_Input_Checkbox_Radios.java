package org.som.ex_09_Input_Select_Alerts_Radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.som.WaitHelpers;
import org.testng.annotations.Test;

public class TestSelenium_Input_Checkbox_Radios {
    @Test
    public void test_select() {
        WebDriver driver = new ChromeDriver();
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();

        // Radio Button
        WebElement radio2 = driver.findElement(By.xpath("//input[@id='sex-1']"));
        radio2.click();

        WaitHelpers.waitJVM(3);

        // Checkbox
        WebElement chkAuto = driver.findElement(By.xpath("//input[@id='profession-1']"));
        chkAuto.click();

        WaitHelpers.waitJVM(3);

        driver.quit();
    }

    }
