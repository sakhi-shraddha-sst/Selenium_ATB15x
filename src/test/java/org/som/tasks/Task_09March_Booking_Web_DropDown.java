package org.som.tasks;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.som.CommonToAll;
import org.som.WaitHelpers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Task_09March_Booking_Web_DropDown extends CommonToAll {

    @Owner("Sakhi Mali")
    @Description("Verify that user is able to type and select from dropdown and search for the results.")
    @Test
    public void test_Booking_DropDown_Search_Automation() {

//        Go to booking.com , click on the destination button. In the destination,
//        you need to type DELHI daily and then hit the tab option first,
//        and then click the enter button. It will automatically select daily.
//        Then you need to click on the explore or search button afterwards.


        driver = new ChromeDriver();
        openBrowser(driver, "https://www.booking.com");

        WaitHelpers.checkElementToBeClickable(driver, By.xpath("//div[@role='dialog']//child::button"), 10);
        WebElement mainPopup = driver.findElement(By.xpath("//div[@role='dialog']//child::button"));
        mainPopup.click();

//        WebElement flightsMenu = driver.findElement(By.id("flights"));
//          flightsMenu.click();

        WebElement flightHotelMenu = driver.findElement(By.id("packages"));
        flightHotelMenu.click();

        WebElement acceptCookies = driver.findElement(By.xpath("//div[@class='iubenda-cs-opt-group-consent']//button[2]"));
        acceptCookies.click();

        WaitHelpers.waitJVM(3);

//        WebElement input_location_to = driver.findElement(By.xpath("//button[@data-ui-name='input_location_to_segment_0']"));
//        input_location_to.click();

//        WebElement input_location_to_city = driver.findElement(By.xpath("//button[@data-ui-name='input_text_autocomplete']"));
//        input_location_to_city.sendKeys("Delhi");

        //input[@aria-autocomplete='list' and @id=':r3:']
        String destination_input_xpath = "//input[@aria-autocomplete='list' and @id=':r3:']";
        WaitHelpers.checkVisibilityOfElement(driver, By.xpath(destination_input_xpath), 5);
        WebElement input_destination = driver.findElement(By.xpath(destination_input_xpath));
        input_destination.click();
        WaitHelpers.waitJVM(4);

        input_destination.clear();
        input_destination.sendKeys("Delhi");
        WaitHelpers.waitJVM(4);


        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB);

        actions.build().perform();

//        WebElement btn_explore = driver.findElement(By.xpath("//button[@data-ui-name='button_search_submit']"));

        WebElement btn_find = driver.findElement(By.xpath("//button[@aria-label='Find']"));

        //button[@aria-label='Find']
        btn_find.click();

        WaitHelpers.waitForTitle(driver, 5, "Delhi");

        String title = driver.getTitle();
        System.out.println(title);

        Assert.assertTrue(title.contains("Delhi"));
        closeBrowser(driver);

    }


}