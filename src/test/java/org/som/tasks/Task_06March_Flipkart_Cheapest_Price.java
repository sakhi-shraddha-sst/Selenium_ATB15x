package org.som.tasks;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.som.CommonToAll;
import org.som.WaitHelpers;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Task_06March_Flipkart_Cheapest_Price extends CommonToAll {

    @Owner("Sakhi Mali")
    @Description("Verify cheapest Mac Mini available on the first page.")
    @Test
    public void test_Flipkart_Search_Title_Price() {

        driver = new ChromeDriver();
        openBrowser(driver, "https://www.flipkart.com/search");

        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("macmini");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        svgElements.get(0).click();

        WaitHelpers.checkVisibilityOfElement(driver, By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"), 5);

        List<WebElement> titlesResult = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MU') or contains(@data-id,'MP')]/div/a[2]"));
        for (WebElement title : titlesResult) {
            System.out.println(title.getText());
        }

        HashSet<Integer> price_num = new HashSet<>();
        List<Integer> sorted_price_list = new ArrayList<>(price_num);

        Integer minPrice = Integer.MAX_VALUE;

        List<WebElement> pricesResult = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MU') or contains(@data-id,'MP')]/div/a[3]/div/div[1]"));
        for(WebElement price : pricesResult){
            String price_text = price.getText();

            if(!price_text.contains("Price: Not Available")){
                price_text = price_text.replace("₹", "").replace(",","");

                Integer price_value =  Integer.parseInt(price_text);
                System.out.println((price_value));

                if(price_value< minPrice){
                    minPrice = price_value;
                }

                price_num.add(price_value);
            }
        }
        if(price_num.size()>0){
            sorted_price_list = new ArrayList<>(price_num);
            Collections.sort(sorted_price_list);
        }

        System.out.println("=".repeat(40));
        System.out.println("Cheapest Price: " + minPrice);

//        System.out.println("Cheapest Price: " + sorted_price_list.get(0));
//        System.out.println("=".repeat(40));

//        closeBrowser(driver);

    }


}