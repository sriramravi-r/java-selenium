package org.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Dynamicdropdown {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("(//a[@value='BHO'])[1]")).click();
        driver.findElement(By.xpath("(//a[@value='CJB'])[2]")).click();
    }
}
