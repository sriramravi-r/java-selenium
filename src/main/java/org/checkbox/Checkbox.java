package org.checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Checkbox {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.cssSelector("input[name*='chk_friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[name*='chk_friendsandfamily']")).isSelected());
        System.out.println(driver.findElements(By.cssSelector("*[type='checkbox']")).size());
    }
}
