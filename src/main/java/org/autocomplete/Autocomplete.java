package org.autocomplete;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Autocomplete {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        List<WebElement> autocompletlist=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option:autocompletlist){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                System.out.println("done");
                driver.quit();
                break;
            }
        }
    }
}
