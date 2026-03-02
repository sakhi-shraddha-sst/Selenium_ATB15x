package org.som.tasks;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_27Feb_Selenium_TTA_Bank {

    @Owner("Sakhi Mali")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the user can transfer money and comeback to the dashboard page.")
    @Test
    public void test_tta_bank() throws InterruptedException {

        // https://tta-bank-digital-973242068062.us-west1.run.app/
        // Transfer - 5000, Comeback to dashboard - $45,000.00

        // Step1 - Go - https://tta-bank-digital-973242068062.us-west1.run.app/

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");

        // Step2 - Sign UP
        WebElement btn_sign_up = driver.findElement(By.xpath("//button[normalize-space() = 'Sign Up']"));
        //button[text() = 'Sign Up']
        btn_sign_up.click();

        // Step3 - Enter Full Name
        //div/label[text() ='Full Name']/parent::div/child::div/child::input
        //input[@type='text']
        WebElement txt_full_name = driver.findElement(By.xpath("//input[@type='text']"));
        txt_full_name.sendKeys("Maya");

        // Step4 - Enter Email
        //div/label[text() ='Full Name']/parent::div/following-sibling::div[1]/child::div/child::input
        //input[@type='email']
        WebElement txt_Email = driver.findElement(By.xpath("//input[@type='email']"));
        txt_Email.sendKeys("abc@abc.com");

        // Step5 - Enter Password
        //div/label[text() ='Full Name']/parent::div/following-sibling::div[2]/child::div/child::input
        WebElement txt_Password = driver.findElement(By.xpath("//input[@type='password']"));
        txt_Password.sendKeys("12345");

        // Step6 - Enter Create Account
        //button[text() = 'Create Account']
        WebElement btn_create_acc = driver.findElement(By.xpath("//button[normalize-space() = 'Create Account']"));
        btn_create_acc.click();

        Thread.sleep(3000);

        WebElement dashboard_header1 = driver.findElement(By.xpath("//h1"));
        String dashboard_header_text1 = dashboard_header1.getText();

        WebElement total_balance_before = driver.findElement(By.xpath("//div/p[normalize-space() ='Total Balance']/parent::div/child::h3"));
        String total_balance_before_text = total_balance_before.getText();

        double total_balance = Double.parseDouble((total_balance_before_text.replace("$", "").replace(",","")));
        System.out.println("Total Balance before transfer: " + total_balance);

        // Step7 - Enter Transfer funds
        //button[text() = 'Transfer Funds']
        WebElement btn_Transfer_Funds = driver.findElement(By.xpath("*//button[normalize-space() = 'Transfer Funds']"));
        btn_Transfer_Funds.click();
        Thread.sleep(2000);

        // Step8 - Enter amount - 5000
        //div/label[text() ='Amount']/parent::div/child::div/child::div/following-sibling::input
        //input[@type='number']
        WebElement txt_amount = driver.findElement(By.xpath("//input[@type='number']"));
        Double amount = 5000.00;
        txt_amount.sendKeys(amount.toString());;
        System.out.println("Amount to be transfer: " + amount);

        // Step9 - Click on Continue
        //button[text() = 'Continue']
        WebElement btn_Continue = driver.findElement(By.xpath("//button[normalize-space()= 'Continue']"));
        btn_Continue.click();
        Thread.sleep(2000);

        // Step10 - Click on Confirm Transfer
        //button[text() = 'Confirm Transfer']
        WebElement btn_Confirm_Transfer = driver.findElement(By.xpath("//button[normalize-space()= 'Confirm Transfer']"));
        btn_Confirm_Transfer.click();
        Thread.sleep(2000);

        // Step11 - Click on Dashboard
        //button[text() = 'Dashboard']
        WebElement btn_Dashboard = driver.findElement(By.xpath("//button[normalize-space() = 'Dashboard']"));
        btn_Dashboard.click();
        Thread.sleep(2000);

        WebElement dashboard_header2 = driver.findElement(By.xpath("//h1"));
        String dashboard_header_text2 = dashboard_header2.getText();

        WebElement total_balance_after = driver.findElement(By.xpath("//div/p[normalize-space() ='Total Balance']/parent::div/child::h3"));
        String total_balance_after_text = total_balance_after.getText();
        Double total_balance_after_num = Double.parseDouble(total_balance_after_text.replace("$", "").replace(",",""));
        System.out.println("Total Balance after transfer: " + total_balance_after_num);

        Double expected_balance_amount = total_balance - amount;

        // Assertions
        Assert.assertEquals(dashboard_header_text1, dashboard_header_text2 );

        Assert.assertEquals(total_balance_after_num, expected_balance_amount);

        driver.quit();


    }
}

