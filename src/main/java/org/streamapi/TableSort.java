package org.streamapi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TableSort {
    @Test
    public void streamTable(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> fruitName=driver.findElements(By.xpath("//tr/td[1]"));
        List<String> fruName=fruitName
                .stream()
                .map(s->s.getText())
                .collect(Collectors.toList());
        List<String> sortFruname=fruName
                .stream()
                .sorted()
                .collect(Collectors.toList());
        Assert.assertTrue(fruName.equals(sortFruname));
        //pagination
        List<String> price;
        do {
            price = fruitName
                    .stream()
                    .filter(s->s.getText().contains("Beans"))
                    .map(s->getPriceViggee(s))
                    .collect(Collectors.toList());
            price.forEach(System.out::println);
            if(price.size()<1){
                driver.findElement(By.xpath(".pagination li:nth-last-child(2)")).click();
            }
        }while(price.size()<1);
    }

    private static String getPriceViggee(WebElement s) {
        String price=s.findElement(By.xpath(".//following-sibling::td[1]")).getText();
        return price;
    }

    @Test
    public void filterTable(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String fName="Banana";
        driver.findElement(By.id("search-field")).sendKeys(fName);
        List<WebElement> fruitName=driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> funame=fruitName
                .stream()
                .filter(s->s.getText().contains(fName))
                .collect(Collectors.toList());
        Assert.assertEquals(fruitName.size(),funame.size());
    }
}
