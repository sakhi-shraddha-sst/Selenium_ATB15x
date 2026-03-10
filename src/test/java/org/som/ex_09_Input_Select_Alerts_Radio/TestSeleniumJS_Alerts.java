package org.som.ex_09_Input_Select_Alerts_Radio;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.som.CommonToAll;
import org.som.WaitHelpers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSeleniumJS_Alerts extends CommonToAll {
    @Test
    public void test_Alerts() {
        WebDriver driver = new ChromeDriver();
        String URL = "https://the-internet.herokuapp.com/javascript_alerts";
        driver.get(URL);
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());

        WebElement elementAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        WebElement confirmAlert = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        WebElement promptAlert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));

        WaitHelpers.waitJVM(2);

        elementAlert.click();
//            confirmAlert.click();
//          promptAlert.click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        System.out.println("Alert Text => " + alertText);
//        alert.sendKeys("SAKHI");

        alert.accept();

        String resultText = driver.findElement(By.id("result")).getText();
        System.out.println("Result Text => " + resultText);

        Assert.assertEquals(resultText, "You successfully clicked an alert");
//        Assert.assertEquals(resultText, "You clicked: Ok");
//        Assert.assertEquals(resultText, "You entered: SAKHI");


        WaitHelpers.waitJVM(5);

        closeBrowser(driver);

    }
}
