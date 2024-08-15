package org.scope;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class scope {
    @Test
    public void testScope(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        int size_a=driver.findElements(By.tagName("a")).size();
        //System.out.println(size_a);
        WebElement footerdriver=driver.findElement(By.cssSelector("div[id='gf-BIG']")); //limit webelement scope
        //System.out.println(footerdriver.findElements(By.tagName("a")).size());
        int footer_first_column=footerdriver.findElements(By.cssSelector(".gf-t td:nth-child(1) ul li")).size();
        for(int i=1;i<footer_first_column;i++){
            String clickonlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
            footerdriver.findElements(By.cssSelector(".gf-t td:nth-child(1) ul li a")).get(i).sendKeys(clickonlink);
        }
        Set<String> childwindow=driver.getWindowHandles();
        Iterator<String> iterator=childwindow.iterator();
        String parentwindow=iterator.next();
        while(iterator.hasNext()){
            String chilewindow=iterator.next();
            if(parentwindow!=chilewindow){
                driver.switchTo().window(chilewindow);
                System.out.println(driver.getTitle());
            }
        }
        driver.switchTo().window(parentwindow);
    }
}
