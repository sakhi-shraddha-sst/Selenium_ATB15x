package org.som.tasks;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task_02March_Selenium_Table_DemoQA {
    /*
    https://demoqa.com/webtables
//        Add five employees. Make sure the third one is legal department.
//        Click on the Add, if you find the first legal department,
//        delete that item.
     */

    @Owner("Sakhi Mali")
    @Description("Find the first Legal Dept Employee and click on the Delete")
    @Test
    public void test_demo_qa_table() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();

        Faker faker = new Faker();
        Thread.sleep(3000);

        //tbody/tr/td[6]
        // Get department column adta and add in arraylist
        List<WebElement> department_list =driver.findElements(By.xpath("//tbody/tr/td[6]"));
       for(WebElement dept : department_list){
           System.out.println(dept.getText());
       }

        for(int i =0; i<5;i++){
            WebElement btn_Add = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
            btn_Add.click();

            WebElement txt_first_name = driver.findElement(By.xpath("//input[@id='firstName']"));
            String first_name = faker.name().firstName();
            txt_first_name.sendKeys(first_name);

            WebElement txt_last_name = driver.findElement(By.xpath("//input[@id='lastName']"));
            String last_name = faker.name().lastName();
            txt_last_name.sendKeys(last_name);

            WebElement txt_Email = driver.findElement(By.xpath("//input[@id='userEmail']"));
            txt_Email.sendKeys(first_name.toLowerCase() + "." +last_name.toLowerCase() + "@example.com");

            WebElement txt_Age = driver.findElement(By.xpath("//input[@id='age']"));
            Integer age = faker.number().numberBetween(19,60);
            txt_Age.sendKeys(age.toString());

            WebElement txt_Salary = driver.findElement(By.xpath("//input[@id='salary']"));
            Integer salary = faker.number().numberBetween(10000,99999);
            txt_Salary.sendKeys(salary.toString());

            WebElement txt_department = driver.findElement(By.xpath("//input[@id='department']"));

                if(i==2){
                    txt_department.sendKeys(department_list.get(2).getText());
                }else{
                    txt_department.sendKeys(department_list.get(faker.random().nextInt(0,2)).getText());

                }


            Thread.sleep(2000);
            WebElement btn_Submit = driver.findElement(By.xpath("//button[@id='submit']"));
            btn_Submit.click();
            Thread.sleep(2000);

        }

        Thread.sleep(5000);


        String legel_dept_row = "//tbody/tr[.//td[text()='Legal']]";

        String legal_delete = "//tbody/tr[.//td[text()='Legal']]/td/div/span[@title='Delete']";


        List<WebElement> legal_dept_list = driver.findElements(By.xpath(legel_dept_row));

        for(WebElement legal_rows : legal_dept_list){
            String legal_emp_name = legal_rows.findElement(By.xpath(".//td[1]")).getText();
            System.out.println(legal_emp_name + " is from legal department");
        }

        System.out.println("=".repeat(30));

        WebElement first_legal_dept = legal_dept_list.get(0);
        String deletion_legal_emp_name = first_legal_dept.findElement(By.xpath(".//td[1]")).getText();
        System.out.println("Deleting " + deletion_legal_emp_name + " from legal department");

        WebElement btn_delete = first_legal_dept.findElement(By.xpath(legal_delete));
        btn_delete.click();

        System.out.println();

        Thread.sleep(5000);
//        driver.quit();
    }
}
