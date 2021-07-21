        package com.company.sections;

        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.ui.Select;

        import java.nio.channels.Selector;

        public class Assignment8 {
            public static  void assignment8(WebDriver driver){
            //autosuggestive dropdown
                driver.get("https://rahulshettyacademy.com/AutomationPractice/");

                driver.findElement(By.id("autocomplete")).sendKeys("uni");
                //enter 3 char


                driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
                driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
                driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
                driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
                driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
                driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
                driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

                System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));


                //verify that option is in edit box.




            }
        }
