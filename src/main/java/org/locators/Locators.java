package org.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        String userName="sriram",email="sri@yopmail.com",phoneNumber="1234567890";
        WebDriver webDriver=new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://rahulshettyacademy.com/locatorspractice/");
        webDriver.findElement(By.id("inputUsername")).sendKeys("rahul");
        webDriver.findElement(By.name("inputPassword")).sendKeys("pass");
        webDriver.findElement(By.className("signInBtn")).click();
        String errorMessage=webDriver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(errorMessage);
        webDriver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(userName);
        webDriver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
        webDriver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys(phoneNumber);
        webDriver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
        String infoMsg=webDriver.findElement(By.cssSelector("form p.infoMsg")).getText();
        System.out.println(infoMsg);
        webDriver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("input[id*='inputUser']")).sendKeys("rahul");
        webDriver.findElement(By.xpath("//input[contains(@name,'inputPass')]")).sendKeys("rahulshettyacademy");
        webDriver.findElement(By.cssSelector("input[id='chkboxOne']")).click();
        webDriver.findElement(By.cssSelector("input[id='chkboxTwo']")).click();
        webDriver.findElement(By.className("signInBtn")).click();
//        webDriver.quit();
    }
}
