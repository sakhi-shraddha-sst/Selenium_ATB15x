package org.som.tasks;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class Task_25Feb_Selenium_Katalon {

    @Owner("Sakhi Mali")
    @Description("Verify that the user can login to the Katalon demo page and navigate to the appointment page.")
    @Test
    public void test_katalon_page() throws InterruptedException {

//      Step1 - Go - https://katalon-demo-cura.herokuapp.com/
//      Step2 - Click on the Make appointment button,
//      Step3 - Enter the username , password given
//      Step4 - Click on the Login button.
//      Step5 - Verify current URL should contain "appointment"
//      Step6 - Verify that the appointment page is displayed with the text "Make Appointment" on the top of the page.


        //      Step1 - Go - https://katalon-demo-cura.herokuapp.com/

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        //      Step2 - Click on the Make appointment button,

        WebElement button_make_appointment = driver.findElement(By.id("btn-make-appointment"));
        button_make_appointment.click();

        Thread.sleep(2000);

        //      Step3 - Enter the username , password given

        WebElement txt_username = driver.findElement(By.id("txt-username"));
        txt_username.sendKeys("John Doe");

        WebElement txt_password = driver.findElement(By.id("txt-password"));
        txt_password.sendKeys("ThisIsNotAPassword");

        //      Step4 - Click on the Login button.
        WebElement button_login = driver.findElement(By.id("btn-login"));
        button_login.click();

        Thread.sleep(5000);

        //      Step5 - Verify current URL should contain "appointment"
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"), "URL doesnt contain appoinment");

        //      Step6 - Verify that the appointment page is displayed with the text "Make Appointment" on the top of the page.

        WebElement heading_make_appointment = driver.findElement(By.tagName("h2"));
        String heading_text = heading_make_appointment.getText().toLowerCase();
        System.out.println(heading_make_appointment.getText());

        Assert.assertTrue(heading_text.contains("appointment"), "Heading doesnt contain text - appointment");

        Thread.sleep(3000);

        driver.quit();


    }
}

