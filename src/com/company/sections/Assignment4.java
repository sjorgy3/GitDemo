package com.company.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class Assignment4 {
    public static void assignment4(WebDriver driver){

        WebDriverWait w = new WebDriverWait(driver, 5);
    driver.get("https://the-internet.herokuapp.com/windows");
    driver.findElement(By.xpath("//a[text()='Click Here']")).click();
    Set<String>windows = driver.getWindowHandles();
    Iterator<String>its = windows.iterator();

    String parentid = its.next();
    String childid = its.next();

    driver.switchTo().window(childid);
    w.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/windows/new"));

    String pagetxt = driver.findElement(By.cssSelector("div.example")).getText();

    System.out.println(pagetxt);


    driver.switchTo().window(parentid);

    String page1 = driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText();

    System.out.println(page1);





    }
}
