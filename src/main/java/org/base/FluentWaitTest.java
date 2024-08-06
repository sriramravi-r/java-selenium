package org.base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class FluentWaitTest {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();
        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
        WebElement ele=wait.until(new Function<WebDriver,WebElement>(){
            @Override
            public WebElement apply(WebDriver webDriver) {
                if(webDriver.findElement(By.cssSelector("#finish h4")).isDisplayed()){
                    return webDriver.findElement(By.cssSelector("#finish h4"));
                }else{
                    return null;
                }
            }
        });
        System.out.println(ele.getText());
    }
}
