package org.som.ex05_XPath_Axes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestSelenium20_Xpath_Axes {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='Mammal']/preceding-siblings::div"));
        elements.get(0).click();

    }
}
