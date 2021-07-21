package com.company.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;


public class Section12 {
    public static void lesson89(WebDriver driver){
        //limiting the scope of the driver to access elements on certain parts of the webpage.
        //create an alternate driver to find the elements on a specific part of the page

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait w = new WebDriverWait(driver, 5);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Integer linkSize = driver.findElements(By.tagName("a")).size();
        System.out.println(linkSize);

        //creating a smaller minidriver for the selected scope
        WebElement altDriver = driver.findElement(By.id("gf-BIG"));

        Integer link2 = altDriver.findElements(By.tagName("a")).size();
        System.out.println(link2);


        //creating a scope for the subsection
        //to go into a subsection inside of another subsection, you must use another driver for that scope etc.

        WebElement miniColumn =  altDriver.findElement(By.xpath("//body/div[@id='gf-BIG']/table[@class='gf-t']/tbody/tr/td[1]"));

       Integer collinks= miniColumn.findElements(By.tagName("a")).size();

       System.out.println(collinks);


       // iterating through the number of links using a for loop
       for (int i = 1; i < miniColumn.findElements(By.tagName("a")).size(); i++ ){
            miniColumn.findElements(By.tagName("a")).get(i).click();
       }










    }
    public static void lesson91 (WebDriver driver) throws InterruptedException {
        //limiting the scope of the driver to access elements on certain parts of the webpage.
        //create an alternate driver to find the elements on a specific part of the page

        WebDriverWait w = new WebDriverWait(driver, 5);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Integer linkSize = driver.findElements(By.tagName("a")).size();
        System.out.println(linkSize);

        //creating a smaller minidriver for the selected scope
        WebElement altDriver = driver.findElement(By.id("gf-BIG"));

        Integer link2 = altDriver.findElements(By.tagName("a")).size();
        System.out.println(link2);


        //creating a scope for the subsection
        //to go into a subsection inside of another subsection, you must use another driver for that scope etc.

        WebElement miniColumn =  altDriver.findElement(By.xpath("//body/div[@id='gf-BIG']/table[@class='gf-t']/tbody/tr/td[1]"));

        Integer collinks= miniColumn.findElements(By.tagName("a")).size();

        System.out.println(collinks);

        int numlinks = miniColumn.findElements(By.tagName("a")).size();
        // iterating through the number of links using a for loop
        for (int i = 1; i < numlinks; i++ ){

           String tabClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
            miniColumn.findElements(By.tagName("a")).get(i).sendKeys(tabClick);
            Thread.sleep(5000);
        }

        Set<String> windows = driver.getWindowHandles(); //[parentid, childid]
        Iterator<String> it = windows.iterator();

        String firsthandle = driver.getWindowHandle();

        while (it.hasNext()) {

            driver.switchTo().window(it.next());

            System.out.println(driver.getTitle());


        }
        driver.switchTo().window(firsthandle);

    }
    public static void lesson94(WebDriver driver){
        //Calendar navigation.
        //to handle dropdowns you need to create a separate selector.
        driver.get("https://www.path2usa.com/travel-companions");

        driver.findElement(By.id("travel_date")).click();

        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April")){
            driver.findElement(By.cssSelector("[class= 'datepicker-days'] [class= 'next']")).click();
        }


        List<WebElement> dates = driver.findElements(By.className("day"));
        Integer numDays = dates.size();

        for(int i = 0; i < numDays; i++){
            String textstuff = driver.findElements(By.className("day")).get(i).getText();
            if (textstuff.contains("16")){
                driver.findElements(By.className("day")).get(i).click();
                System.out.println("swag");
                break;




            }

            }



    }
}
