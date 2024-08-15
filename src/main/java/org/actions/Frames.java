package org.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Frames {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        driver.findElement(By.id("draggable")).isDisplayed();
        Actions actions=new Actions(driver);
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));
        actions
                .dragAndDrop(source,target).build().perform();
        driver.quit();

    }
}
