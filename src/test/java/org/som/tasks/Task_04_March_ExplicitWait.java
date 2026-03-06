package org.som.tasks;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task_04_March_ExplicitWait {


    // Locators - Find the Web elements
    // Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
    //Find the Email id** and enter the email as admin@admin.com
    //Find the pass inputbox** and enter passwrod as admin.

    //Find and Click on the submit button

    //Verify that the error message is shown "Your email, password, IP address or location did not match"

    @Owner("Sakhi Mali")
    @Description("Verify that the error message is shown for invalid credentials")
    @Test
    public void test_app_vwo_login_explicit_wait() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)

        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Find the Email id** and enter the email as admin@admin.com

        WebElement txt_email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='hocewoqisi']")));
        txt_email.sendKeys("admin@admin.com");

        //Find the pass inputbox** and enter passwrod as admin.

        WebElement txt_password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-password']")));
        txt_password.sendKeys("admin@admin.com");

        //Find and Click on the submit button
        WebElement btn_SignIN = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='js-login-btn']")));
        btn_SignIN.click();



        WebElement error_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-qa='rixawilomi']")));
//        WebElement error_message = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));
        String actual_error = error_message.getText();
        System.out.println(actual_error);

        String expected_error = "Your email, password, IP address or location did not match";
        Assert.assertEquals(actual_error, expected_error);


        driver.quit();


    }
    }
