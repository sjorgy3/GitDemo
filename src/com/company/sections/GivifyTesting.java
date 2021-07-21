package com.company.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GivifyTesting {
    public static void practice1(WebDriver driver) throws InterruptedException {
        //testing page hotel search boxes and tabs.
        WebDriverWait w = new WebDriverWait(driver, 5);


        driver.get("https://secure.patronaccess.cloud/cpal/cp-pal-CP-PAL-SE-17788E06875-E230237_2021_1_1_106/RunConsoleApp.do?go=R");


        driver.manage().window().maximize();

        //Login
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("spencercjorgensen@gmail.com");

        driver.findElement(By.id("password")).sendKeys("Brycecannon1");

        driver.findElement(By.id("sendBtn")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("places-input")));


        //Hotels-Destination autosuggestive dropdown testing.

        //*sending keys
        driver.findElement(By.id("places-input")).sendKeys("Belem ");

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='cr-datalist-option'] span")));

        //*Creating list of items from dropdown and iterating through to find desired text.
        List<WebElement> elements =  driver.findElements(By.cssSelector("li[class='cr-datalist-option'] span"));
        for (WebElement element: elements) {

            if(element.getText().equalsIgnoreCase("Belém, State of Pará, Brazil")){
                element.click();
                break;
            }
            
        }


        //Select current day on left calendar. 7/16/2021
        ;
        driver.findElement(By.xpath("//div[@id='hotelsCheckInDate']")).click();
        List<WebElement>dates2 = driver.findElements(By.cssSelector(".cr-datepicker-day"));
            for (WebElement date:dates2) {
            if(date.getAttribute("class").equals("cr-datepicker-day today selected first last")){
                date.click();
                break;
            }

        }



        driver.findElement(By.xpath("//div[@id='hotelsCheckOutDate']")).click();

        List<WebElement> dates = driver.findElements(By.cssSelector(".cr-datepicker-day"));

        for (WebElement date:dates) {
            if(date.getText().equalsIgnoreCase("20")){
                date.click();
                break;
            }

        }
        WebElement dropdown = driver.findElement(By.id("rooms"));
        Select s = new Select(dropdown);
        s.selectByVisibleText("5");


        WebElement dropdown2 = driver.findElement(By.id("adults"));
        Select s2 = new Select(dropdown2);

        s2.selectByVisibleText("30");

        Actions a = new Actions(driver);

        a.moveToElement(driver.findElement(By.cssSelector("a[class='btn btn-primary t-btn-primary w-100']"))).contextClick().build().perform();





    }
}
