package org.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class actionDemo {
    @Test
    public void action_demo(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=9826962855803425182&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9182246&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
        System.out.println(driver.getTitle());
        Actions action=new Actions(driver);
        WebElement accountlist=driver.findElement(By.xpath("//span[contains(@id,'nav-link-accountList')]"));
        WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
        action
                .moveToElement(search)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("hello")
                .doubleClick()
                .build().perform();
        action
                .contextClick(accountlist)
                .build()
                .perform();
    }
}
