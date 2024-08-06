package org.window;

import io.opentelemetry.api.internal.ApiUsageLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class windowsHandles {
    @Test
    public void windowHandles() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        String parent_driver=driver.getWindowHandle();
        driver.findElement(By.className("blinkingText")).click();
        Set<String> listofwindow=driver.getWindowHandles();
        Iterator<String> it=listofwindow.iterator();
        String parentID= it.next();
        String childID=it.next();
        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.xpath("//a[contains(@href,'mailto')]")).getText().split("@")[0]);
    }
}
