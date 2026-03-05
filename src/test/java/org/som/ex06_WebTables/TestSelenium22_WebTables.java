package org.som.ex06_WebTables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium22_WebTables {


    @Test
    @Description("Test Case >  https://awesomeqa.com/webtable1.html")
    public void test_web_table_login() throws Exception {


        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();

        WebElement table_head = driver.findElement(By.xpath("//table[@summary='Sample Table']/thead"));
        WebElement table_footer =  driver.findElement(By.xpath("//table[@summary='Sample Table']/tfoot"));
        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        List<WebElement> row_table = table.findElements(By.tagName("tr"));

        for(int i = 0; i < row_table.size(); i++){
            List<WebElement> column_table = row_table.get(i).findElements(By.tagName("td"));

            for(WebElement w : column_table){
                System.out.println(w.getText());
            }
        }

        driver.quit();

    }
}
