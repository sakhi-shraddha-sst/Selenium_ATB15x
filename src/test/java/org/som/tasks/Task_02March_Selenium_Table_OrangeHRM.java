package org.som.tasks;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task_02March_Selenium_Table_OrangeHRM {
    /*
    https://awesomeqa.com/hr/web/index.php
2. Login, Find the first Terminated Employye and click on the Delete
3. DOn’t Delete just open the popup and stop the scritp.
     */

    @Owner("Sakhi Mali")
    @Description("Find the first Terminated Employee and click on the Delete")
    @Test
    public void test_orange_hrm_table() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php");
        driver.manage().window().maximize();

        Thread.sleep(3000);
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement btn_login = driver.findElement(By.xpath("//button"));

        username.sendKeys("admin");
        password.sendKeys("Hacker@4321");
        btn_login.click();

        Thread.sleep(3000);

        String terminated_emp = "//div[@role='row'][.//div[text()= 'Terminated']]";
        List<WebElement> terminated_emp_list = driver.findElements(By.xpath(terminated_emp));

        Integer totalRows = terminated_emp_list.size();

        for(WebElement row: terminated_emp_list){
            String emp_name = row.findElement(By.xpath(".//div[3]")).getText();
            System.out.println(emp_name);
        }

        // click on the first terminated employee delete button
        WebElement first_terminated_emp = terminated_emp_list.get(0);
        WebElement delete_icon = first_terminated_emp.findElement(By.xpath(".//div[9]/div/button[1]"));
        delete_icon.click();

        Thread.sleep(2000);

        WebElement popup = driver.findElement(By.xpath("//div[@class=\"orangehrm-modal-header\"]/p"));
        String popup_text = popup.getText();

        Assert.assertEquals(popup_text, "Are you Sure?");


        driver.quit();
    }
}
