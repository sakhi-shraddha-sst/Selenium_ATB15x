package org.som.ex_09_Input_Select_Alerts_Radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.som.CommonToAll;
import org.som.WaitHelpers;
import org.testng.annotations.Test;

public class TestSelenium_Input_Select_DropDown extends CommonToAll {


    @Test
    public void test_select() {
        WebDriver driver = new ChromeDriver();
        String URL = "https://the-internet.herokuapp.com/dropdown";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.id("dropdown"));
        Select select = new Select(element);
        select.selectByIndex(2);
        WaitHelpers.waitJVM(3);

        select.selectByVisibleText("Option 1");
        WaitHelpers.waitJVM(2);

        driver.quit();
    }
}
