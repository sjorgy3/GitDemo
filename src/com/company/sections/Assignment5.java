package com.company.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Assignment5 {
    public static void assignment5(WebDriver driver){

        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //driver.switchTo().frame(driver.findElement(By.cssSelector("frameset[frameborder*='1']")));
        driver.switchTo().frame(driver.findElement(By.name("frame-top")));

        driver.switchTo().frame(driver.findElement(By.name("frame-middle")));


        String text = driver.findElement(By.id("content")).getText();

        System.out.println(text);
    }
}
