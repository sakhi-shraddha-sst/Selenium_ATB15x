package org.som.ex04_XPath;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium19_Xpath_MiniProject02 {
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

       List<WebElement> alt_images = driver.findElements(By.xpath("//img[starts-with(@alt,'Image')]"));
       System.out.println(alt_images.size());

//       alt_images.get(0).click();


       Thread.sleep(2000);
        driver.quit();
    }
}
