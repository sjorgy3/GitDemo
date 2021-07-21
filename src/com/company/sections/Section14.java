package com.company.sections;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import javax.net.ssl.HttpsURLConnection;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.List;

public class Section14 {
    public static void lesson102(WebDriver driver){
        //handling pop up stuff.
        DesiredCapabilities ch = DesiredCapabilities.firefox();
        ch.acceptInsecureCerts();

        FirefoxOptions f = new FirefoxOptions();

        f.merge(ch);


    }
    public static void lesson103(WebDriver driver) throws IOException {
        //Managing screen and cookies and taking and saving screenshots.
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.google.com");

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(src,new File("C:\\Users\\Public\\Pictures\\screenshot.png"));
    }
    public static void lesson106(WebDriver driver) throws IOException {
        //broken URL
        //get URLS linked to the links
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        //String url = driver.findElement(By.xpath("//a[href*='brokenlink']")).getAttribute("href");
        //there are java methods that will get you the status.
        //System.out.println(url);
        //creates a method to access the response code of the url
        List<WebElement> links = driver.findElements(By.cssSelector("li.gf-li a"));
        for (int i = 0; i > links.size(); i++ ){
            String url = driver.findElements(By.cssSelector("li.gf-li a")).get(i).getAttribute("href");
            HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respcode = conn.getResponseCode();
            System.out.println(respcode);

            if (respcode < 400){
                System.out.println("There is a link that is broken!" + driver.findElements(By.cssSelector("li.gf-li a")).get(i).getText() + respcode);
            }
        }

    }
    public static void examplecode(WebDriver driver){

    }
}
