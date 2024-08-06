package org.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Updateddropdown {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        //thread.sleep(2000);
        int i=0;
        while(i<5){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}
