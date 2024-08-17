package org.new_instance_window_tab;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class NewWindowTab {
    @Test
    public void NewWindow(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://rahulshettyacademy.com/");
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> iterator=windows.iterator();
        String parentWindow=iterator.next();
        String childWindow=iterator.next();
        driver.switchTo().window(childWindow);
        String name=driver.findElements(By.cssSelector(".lower-content h2 a")).get(0).getText();
        driver.switchTo().window(parentWindow);
        driver.findElement(By.name("name")).sendKeys(name);
        String uname=driver.findElement(By.name("name")).getAttribute("value");
        Assert.assertEquals(uname,name);
        driver.quit();
    }
}
