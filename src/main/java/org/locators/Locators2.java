package org.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver=new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String userPassword=getPassword(webDriver);
        webDriver.get("https://rahulshettyacademy.com/locatorspractice/");
        webDriver.findElement(By.cssSelector("input[id*='inputUser']")).sendKeys("rahul");
        webDriver.findElement(By.xpath("//input[contains(@name,'inputPass')]")).sendKeys(userPassword);
        webDriver.findElement(By.cssSelector("input[id='chkboxOne']")).click();
        webDriver.findElement(By.cssSelector("input[id='chkboxTwo']")).click();
        webDriver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        String successLogedIn=webDriver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(successLogedIn,"You are successfully logged in.");
        webDriver.findElement(By.xpath("//button[text()='Log Out']")).click();
        webDriver.quit();
    }
    public static String getPassword(WebDriver webDriver) throws InterruptedException {
        webDriver.get("https://rahulshettyacademy.com/locatorspractice/");
        webDriver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
        String infoMsg=webDriver.findElement(By.cssSelector("form p.infoMsg")).getText();
        System.out.println(infoMsg);
        String[] infoList=infoMsg.split("'");
        System.out.println(Arrays.toString(infoList));
        return infoList[1].trim();
    }
}
