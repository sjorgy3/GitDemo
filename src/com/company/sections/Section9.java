package com.company.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.WatchEvent;
import java.util.Arrays;
import java.util.List;

public class Section9
    //Dynamic Shopping cart.
    {
    public static void lesson66(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("aus");


        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for(WebElement option:options){
            if (option.getText().equalsIgnoreCase("Austria")){
                option.click();
                break;
            }
        }

    }
    public static void  lesson67(WebDriver driver) throws InterruptedException {
        String[] itemsneeded = {"Cucumber", "Brocolli"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        addItems(driver, itemsneeded);


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
