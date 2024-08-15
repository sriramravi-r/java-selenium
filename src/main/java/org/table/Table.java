package org.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Table {
    @Test
    public void Test_Table(){

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);

        WebDriver driver=new ChromeDriver(chromeOptions=chromeOptions);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum=0;
        for(int i=0;i<values.size();i++){
            sum+=Integer.parseInt(values.get(i).getText());
        }
        int totalValue=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(" ")[3]);
        Assert.assertEquals(totalValue,sum);
    }

}
