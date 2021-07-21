package com.company.sections;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {
    public static void assignment3(WebDriver driver){


        WebDriverWait w = new WebDriverWait(driver, 5);


        driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");

        driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();

        w.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("results"))));

        String results = driver.findElement(By.id("results")).getText();

        System.out.println(results);



    }
}
