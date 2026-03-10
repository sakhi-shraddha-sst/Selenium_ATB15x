package org.som.ex_10_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.som.WaitHelpers;
import org.testng.annotations.Test;

public class Lab_SpiceJet_ActionClass_Select_Destination {
    @Test
    public void test_select() {
        WebDriver driver = new ChromeDriver();
        String URL = "https://www.spicejet.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement origin = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));
        WebElement destination = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/div/div/input"));

        Actions actions = new Actions(driver);

        actions.moveToElement(origin)
                .click().sendKeys("BLR")
                .moveToElement(destination)
                .click().sendKeys("DEL")
                .build().perform();

        WaitHelpers.waitJVM(4);

        driver.quit();
    }
    }
