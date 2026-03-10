package org.som.tasks;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.som.CommonToAll;
import org.som.WaitHelpers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task_09March_Booking_Web_DropDown1 extends CommonToAll {

    @Owner("Sakhi Mali")
    @Description("Verify that user is able to type and select from dropdown and search for the results.")
    @Test
    public void test_Booking_DropDown_Search_Automation() throws InterruptedException {

//        Go to booking.com , click on the destination button. In the destination,
//        you need to type DELHI daily and then hit the tab option first,
//        and then click the enter button. It will automatically select daily.
//        Then you need to click on the explore or search button afterwards.

        WebDriver driver = new ChromeDriver();
        String URL = "https://www.booking.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        String close_modal = "//button[@aria-label='Dismiss sign in information.']//*[local-name()='svg']";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        WebElement mainPopup = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(close_modal)));

        mainPopup.click();

        WebElement flightsMenu = driver.findElement(By.id("flights"));
        flightsMenu.click();

        WaitHelpers.waitJVM(3);

        WebElement input_location_to = driver.findElement(By.xpath("//button[@data-ui-name='input_location_to_segment_0']"));
        input_location_to.click();


        WebElement input_location_to_city = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-ui-name='input_text_autocomplete']")));

        //        input_location_to_city.sendKeys("Delhi");

        WaitHelpers.waitJVM(4);

        String destination_text = "Delhi";
        actions
                .moveToElement(input_location_to_city).click()
                .sendKeys(destination_text)
                .sendKeys(Keys.TAB)
                .build().perform();



        WebElement btn_explore = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//button[@data-ui-name='button_search_submit']")));

        btn_explore.click();


        WaitHelpers.waitForTitle(driver, 10, destination_text);

        String title = driver.getTitle();
        System.out.println(title);

        Assert.assertTrue(title.contains(destination_text));

        closeBrowser(driver);

    }


}