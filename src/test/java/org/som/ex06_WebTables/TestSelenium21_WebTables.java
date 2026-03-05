package org.som.ex06_WebTables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium21_WebTables {

    @Test
    @Description("Test Case > https://awesomeqa.com/webtable.html")
    public void test_web_table_login() throws Exception {


        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

        //table/tbody/tr[5]/td[2]
        // tr[i] => 1,2,3,4,5
        // td[j] => 1,2,3

        String first_part = "  //table[@id='customers']/tbody/tr[";
        // i
        String second_part = "]/td[";
        // j
        String third_part = "]";

        Integer row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        Integer column = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

        for(int i = 2; i<=row; i++){
            for(int j = 1; j <=column; j++){
                String dynamic_xpath = first_part + i + second_part + j + third_part;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();

//                System.out.println(dynamic_xpath + " => " + data);
//                System.out.println(data);

                if(data.contains("Helen")){
                    String country_path = dynamic_xpath + "/following-sibling::td";
                    String country_path_text = driver.findElement(By.xpath(country_path)).getText();

                    String company = dynamic_xpath +"/preceding-sibling::td";
                    String company_text = driver.findElement(By.xpath(company)).getText();

                    System.out.println("-".repeat(20));
                    System.out.println("Helen Bennett is from " + country_path_text + " and works at "
                            + company_text);


                }
            }
        }



        driver.quit();

    }
}
