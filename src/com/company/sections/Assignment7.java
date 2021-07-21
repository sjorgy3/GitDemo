package com.company.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Assignment7 {
    public static void assignment7(WebDriver driver){
        //print number of rows (11) and the number of columns(3) both in
        //print 2nd row content.


        //call page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        //scroll to table
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,600)");

        //create list of rows
        List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));

        System.out.println(rows.size());
        //create list of columns
        List<WebElement> colmns = driver.findElements(By.cssSelector("table.table-display th"));
        System.out.println(colmns.size());
        //access first index of rows and print text.
        String secondrow = rows.get(2).getText();
        System.out.println(secondrow);
    }
}
