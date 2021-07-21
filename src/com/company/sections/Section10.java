package com.company.sections;

import com.sun.xml.internal.stream.util.ThreadLocalBufferAllocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class Section10
    //Synchronization wait etc.
    //Trying to get websites to load at the same time
    {

    public static void lesson73(WebDriver driver) throws InterruptedException {
    //implicit wait: Wait for n number of seconds before throwing exception.
        //ex: driver.manage().timetouts().implicitwait(5, TimeUnit.Seconds)

        //explicit wait: specific to location of one single element etc.
        //WebDriverWait w = new WebDriverWait(driver, 5)
        //w.until(ExpectedConditions.visibilityOfElement) ex wait till it is accessible


        WebDriverWait w = new WebDriverWait(driver, 5);

        String[] itemsneeded = {"Cucumber", "Brocolli"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        addItems(driver, itemsneeded);

        driver.findElement(By.xpath("//a[@class='cart-icon']//img[contains(@class,'')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[text()='Apply']")).click();
        String coupon = driver.findElement(By.cssSelector("span.promoInfo")).getText();





    }
        public static void addItems(WebDriver driver,String[] itemsneeded) throws InterruptedException {
            int j = 0;

            List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

            for(int i = 0; i < products.size();i++){

                String[] name = products.get(i).getText().split("-");
                String formattedname = name[0].trim();


                List itemsneededList = Arrays.asList(itemsneeded);


                if (itemsneededList.contains(formattedname)){
                    driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

                    j++;
                    if (j == itemsneeded.length){

                        break;
                    }
                }
            }

        }
    }
