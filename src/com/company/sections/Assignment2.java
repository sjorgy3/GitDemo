package com.company.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Assignment2 {
    public static void assignment2(WebDriver driver){
        //to select current date on websites
        driver.get("https://www.cleartrip.com/");
        driver.findElement(By.cssSelector("path[stroke='#FFF']")).click();
        driver.findElement(By.cssSelector(".DayPicker-Day--today")).click();

        driver.findElement(By.xpath("//button[text() = 'Search flights']")).click();

        String errormsg = driver.findElement(By.cssSelector("span.to-ellipsis.o-hidden.ws-nowrap.fs-3.c-white")).getText();

        System.out.println(errormsg);



    }
}
