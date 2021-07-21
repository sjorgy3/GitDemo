package com.company.sections;

import org.omg.PortableInterceptor.ORBIdHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Section15 {
    public static void lesson112(WebDriver driver){
        //streams are a way to get rid of adding things to a list by using for loops etc.
        //use optimized code!!
        //to change arrays into lists use the Arrays.asList method
        ArrayList<String> names = new ArrayList<String >();
        names.add("Abby");
        names.add("Don");
        names.add("Spencer");

        names.add("Adam");

        Long count = names.stream().filter(s ->s.startsWith("A")).count();
        System.out.println(count);

        Long c = Stream.of("spencer", "tavin", "Andrew").filter(s ->s.startsWith("A")).count();
        System.out.println(c);

        names.stream().filter(s -> s.length()>3).limit(1).forEach(s -> System.out.println(s));



    }
    public static void streamMap(WebDriver driver){
        //use of streams to create lists and to determine if something is valid or not etc.
        Stream.of("spencer", "tavin", "Andrewr").filter(s -> s.endsWith("r")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));


        List<String> names = Arrays.asList("wspencer", "sdon", "wowsie");
        List<String > names2 = Arrays.asList("Tomas", "david", "Andrew", "REagan");
        names.stream().filter(s ->s.startsWith("w")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        Stream<String> newStream= Stream.concat(names.stream(), names2.stream() );

        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("tomas"));

        Assert.assertFalse(flag);

    }
    public static void streamCollect(WebDriver driver){
        //convert list to stream then back to list.

        //list
       List<String> nl= Stream.of("spencer", "tavin", "Andrewr").filter(s -> s.endsWith("r")).map(s -> s.toUpperCase()).collect(Collectors.toList());
       //Convert back to list to print and access as list
       System.out.println(nl.get(0));
        //newlist
        List<Integer>nums = Arrays.asList(3,2,1,2,4,5,6,6,7,5,4,6,4);

        nums.stream().distinct().forEach(s -> System.out.println(s));
        //newlist
        List<Integer>li = nums.stream().distinct().sorted().collect(Collectors.toList());

        System.out.println(li.get(2));


    }
    public static void lesson113(WebDriver driver){
        //sorting list and comparing the sorted lists.
        //click on column
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr/th[1]")).click();
        //capture all elements into list.
        List<WebElement> firstcol = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> origList = firstcol.stream().map(s -> s.getText()).collect(Collectors.toList());


        List<String> sortedList =  origList.stream().sorted().collect(Collectors.toList());

        Assert.assertTrue(origList.equals(sortedList));
        //create new list with text
        //sort the text on orignial list and compare to the sorted list
        //compare original code.
    }
    public static void lesson114(WebDriver driver) {
        //pagination through pages to search for objects with streams
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        List<WebElement> firstcol = driver.findElements(By.xpath("//tr/td[1]"));
        List<String>price;
        firstcol.stream().filter(s->s.getText().contains("Beans")).
                map(s-> getPriceVeggie(s)).collect(Collectors.toList());


        do {
            List<WebElement> row = driver.findElements(By.xpath("//tr/td[1]"));
            price = row.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
            price.forEach(a->System.out.println(a));
            if(price.size() < 1 ){
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while(price.size()<1);





    }

    private static String getPriceVeggie(WebElement s) {

        String price =  s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
    }
    public static void lesson115(WebDriver driver){
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));

        List<WebElement> filteredList = veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());

        Assert.assertEquals(veggies.size(),filteredList.size());


    }












}
