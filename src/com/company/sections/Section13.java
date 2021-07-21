package com.company.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Section13 {
    public static void lesson98(WebDriver driver){
        //Scrolling within a page etc.
        //use the console to discover the correct javascript selectors as well as queries etc.

        //create a javascript executer
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,500)");

        //call a query selector
        //document.querySelector(".tableFixHead").scrolltop etc.
        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
    }
    public static void lesson99(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,500)");
        Thread.sleep(3000);
        //call a query selector
        //document.querySelector(".tableFixHead").scrolltop etc.
        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
        Thread.sleep(3000);
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        Integer sum = 0;
        for (int i =0; i<values.size();i++){
            //convert string to integer using Integer.parse
          // Integer newval = Integer.parseInt(values.get(i).getText());
           sum = sum + Integer.parseInt(values.get(i).getText());;

        }
        System.out.println(sum);

        Integer totalamount = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());





    }
}
