package org.new_instance_window_tab;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindowTab {
    @Test
    public void NewWindow() throws IOException {
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
        WebElement name1=driver.findElement(By.name("name"));
        name1.sendKeys(name);
        System.out.println(name1.getRect().getDimension().getHeight());
        System.out.println(name1.getRect().getDimension().getWidth());
        String uname=driver.findElement(By.name("name")).getAttribute("value");
        File src=name1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\LENOVO\\Downloads\\Automation notes\\Selenium\\selenium\\src\\main\\java\\org\\new_instance_window_tab\\textbox.png"));

        Assert.assertEquals(uname,name);
        driver.quit();
    }
}
