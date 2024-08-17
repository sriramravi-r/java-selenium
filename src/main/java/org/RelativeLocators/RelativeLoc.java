package org.RelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLoc {
    @Test
    public void aboveLoc(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement element=driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(element)).getText());
    }

    @Test
    public void belowLoc(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement element=driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(element)).click();
    }

    @Test
    public void leftLoc(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement element=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(element)).click();
    }

    @Test
    public void rightLoc(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement element=driver.findElement(By.id("inlineRadio2"));
        driver.findElement(with(By.tagName("label")).toRightOf(element)).click();
    }
}
