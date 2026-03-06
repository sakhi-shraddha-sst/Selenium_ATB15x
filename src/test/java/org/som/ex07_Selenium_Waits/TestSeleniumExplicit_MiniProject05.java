package org.som.ex07_Selenium_Waits;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.som.CommonToAll;
import org.som.WaitHelpers;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.som.CommonToAll.closeBrowser;
import static org.som.CommonToAll.openBrowser;

public class TestSeleniumExplicit_MiniProject05 {

    @Owner("Sakhi Mali")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify makemytrip opens with modal")
    @Test
    public void test_makemytrip_closeModal() {

        WebDriver driver = new ChromeDriver();
       openBrowser(driver, "https://www.makemytrip.com/");


//        driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
        WebElement closeModel =  driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
//        closeModel.click();

        WaitHelpers.checkElementToBeClickable(driver, By.xpath("//span[@data-cy='closeModal']"), 5);
        closeModel.click();

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        WaitHelpers.waitJVM(10000);

        closeBrowser(driver);


    }

}
