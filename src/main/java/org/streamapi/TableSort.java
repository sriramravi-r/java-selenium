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
    }
}
