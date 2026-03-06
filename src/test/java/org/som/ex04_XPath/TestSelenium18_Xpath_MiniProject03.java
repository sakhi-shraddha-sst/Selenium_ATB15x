package org.som.ex04_XPath;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium18_Xpath_MiniProject03 {

    @Owner("Sakhi Mali")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login is working ")
    @Test
    public void test_orange_hrm_awesomeqa_login() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        Thread.sleep(3000);
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement btn_login = driver.findElement(By.xpath("//button"));

        username.sendKeys("admin");
        password.sendKeys("Hacker@4321");
        btn_login.click();



        Thread.sleep(3000);

        WebElement h6 = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']"));
        String h6_text = h6.getText();


        Assert.assertEquals(h6_text, "PIM", "Heading doesnt match expected value");





        driver.quit();
    }
    }
