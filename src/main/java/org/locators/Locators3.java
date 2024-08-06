package org.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {
    public static void main(String[] args) {
        WebDriver webDriver=new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(webDriver.findElement(By.xpath("//header/div/button//following-sibling::button[2]")).getText());
    }
}
