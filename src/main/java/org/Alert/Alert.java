package org.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("sriram");
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        alert.dismiss();
//        if (alert.getText().contains("sriramss")) {
//            Assert.assertTrue(true,"name present");
//        } else {
//            Assert.assertFalse(false,"no name present");
//        }
    }
}