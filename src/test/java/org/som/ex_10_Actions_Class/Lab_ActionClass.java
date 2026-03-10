package org.som.ex_10_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.som.CommonToAll;
import org.testng.annotations.Test;

public class Lab_ActionClass extends CommonToAll {
    @Test
    public void test_select() {
        WebDriver driver = new ChromeDriver();
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);

        actions.keyDown(Keys.SHIFT).sendKeys(firstName, "automation testing")
                .keyUp(Keys.SHIFT)
                .build().perform();

        driver.quit();

    }
    }
