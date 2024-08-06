package org.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class base {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String[] name = {"Cucumber", "Brocolli"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < productNames.size(); i++) {
            String productName = productNames.get(i).getText().split("-")[0].trim();
            List items = Arrays.asList(name);
            int j = 0;
            if (items.contains(productName.trim())) {
                j++;
                driver.findElements(By.xpath("(//div[@class='product-action'])")).get(i).click();
                if (j > name.length - 1) {
                    break;
                }
            }
        }
        driver.findElement(By.xpath("//div[@class=\"cart\"]/a[@class=\"cart-icon\"]")).click();
        driver.findElement(By.xpath("//div[contains(@class,\"cart-preview\")]/div/button")).click();
        driver.findElement(By.xpath("//input[@class=\"promoCode\"]")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class=\"promoBtn\"]")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
        String successText=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[@class=\"promoInfo\"]")))).getText();
        Assert.assertEquals(successText,"Code applied ..!");
    }
}