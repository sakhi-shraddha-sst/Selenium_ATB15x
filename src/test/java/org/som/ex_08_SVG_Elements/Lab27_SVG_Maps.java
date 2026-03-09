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

public class Lab27_SVG_Maps extends CommonToAll {
    @Owner("Sakhi Mali")
    @Description("Verify that States In SVG visible.")
    @Test
    public void verifyStatesInSVG() {

        ChromeDriver driver = new ChromeDriver();
        String URL = "https://www.amcharts.com/svg-maps/?map=india";

        openBrowser(driver, URL);
        WaitHelpers.waitJVM(3000);

        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));

        for(WebElement state : states){
            System.out.println(state.getDomAttribute("aria-label"));

            if(state.getDomAttribute("aria-label").equalsIgnoreCase("Maharashtra")){
                state.click();
                WaitHelpers.waitJVM(3000);
            }
        }




        closeBrowser(driver);

    }
    }
