package com.company.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class Section11 {
    public static void lesson82(WebDriver driver){
        //automated actions with mouse and keyboard actions.


        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);

        a.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
    }
    public static void lesson83(WebDriver driver){
        //more with mouse usage

        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);

        a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
        a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).contextClick().build().perform();
    }
    public static void lesson84(WebDriver driver){
        //windows parent and child windows. to switch from window to window.
        Actions a = new Actions(driver);
        driver.get("https://www.rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();

        //switching tabs
        //first create set of windows and add the window handles
        Set<String> windows = driver.getWindowHandles(); //[parentid, childid]
        //then create an iterator that will iterate through the windows. starting at index 0 which would be the first tab.
        Iterator<String>it = windows.iterator();
        String parentID = it.next();
        String childID = it.next();
        driver.switchTo().window(childID);

        System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());

    }
    public static void lesson85(WebDriver driver){
        //windows parent and child windows. to switch from window to window.
        Actions a = new Actions(driver);
        driver.get("https://www.rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();

        //switching tabs
        //first create set of windows and add the window handles
        Set<String> windows = driver.getWindowHandles(); //[parentid, childid]
        //then create an iterator that will iterate through the windows. starting at index 0 which would be the first tab.
        Iterator<String>it = windows.iterator();
        String parentID = it.next();
        String childID = it.next();
        driver.switchTo().window(childID);

        String email = (driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0]);

        driver.switchTo().window(parentID);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
    }
    public static void lesson88(WebDriver driver){
        //using frames and actions, drags the square onto its target.
        Actions a = new Actions(driver);
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

        a.dragAndDrop((driver.findElement(By.xpath("//div[@id='draggable']"))), driver.findElement(By.xpath("//div[@id='droppable']"))).build().perform();

        driver.switchTo().defaultContent();
    }
}
