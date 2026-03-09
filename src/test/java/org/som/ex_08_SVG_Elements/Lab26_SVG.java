package org.som.ex_08_SVG_Elements;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.som.CommonToAll;
import org.som.WaitHelpers;
import org.testng.annotations.Test;

import java.util.List;

public class Lab26_SVG extends CommonToAll {

    @Owner("Sakhi Mali")
    @Description("Verify that the on search with svg icon results are visible.")
    @Test
    public void test_Flipkart_Search_SVG_Icon() {

        driver =new ChromeDriver();
        openBrowser(driver, "https://www.flipkart.com/search");

        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("macmini");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        svgElements.get(0).click();

        WaitHelpers.checkVisibilityOfElement(driver, By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"),5);

        List<WebElement> titlesResult = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MU') or contains(@data-id,'MP')]/div/a[2]"));
        for(WebElement title : titlesResult){
            System.out.println(title.getText());
        }

        WaitHelpers.waitJVM(5000);
        closeBrowser(driver);
    }
    }
