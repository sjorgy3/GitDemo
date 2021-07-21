package com.company.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {
    public static void assignment6(WebDriver driver){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("checkBoxOption2")).click();


        String selectedbox = driver.findElement(By.xpath("//label[@for='benz']")).getText();

        //must create a selector and new webelement

        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select s = new Select(dropdown);

        s.selectByVisibleText(selectedbox);

        driver.findElement(By.id("name")).sendKeys(selectedbox);

        driver.findElement(By.id("alertbtn")).click();

        String alerttext = driver.switchTo().alert().getText();

        if (alerttext.contains(selectedbox)){
            System.out.println("Success");
        }


    }
}
