package org.calender;

import com.sun.security.jgss.GSSUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Calender {
    @Test
    public void testCalender(){
        String monthnumber="6";
        String date="15";
        String year="2027";
        String[] expectedarray={monthnumber,date,year};
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.className("react-date-picker__inputGroup")).click();
        driver.findElement(By.xpath("//span[contains(@class,'react-calendar__navigation')]")).click();
        driver.findElement(By.xpath("//span[contains(@class,'react-calendar__navigation')]")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElement(By.cssSelector(".react-calendar__year-view__months button:nth-child("+monthnumber+")")).click();
        driver.findElement(By.xpath("//abbr[text()="+date+"]")).click();
        //System.out.println(driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText());
        List<WebElement> actualList=driver.findElements(By.cssSelector(".react-date-picker__inputGroup .react-date-picker__inputGroup__input"));
        for(int i=0;i<actualList.size();i++){
            String value=actualList.get(i).getAttribute("value");
            //System.out.println(value);
            Assert.assertEquals(value,expectedarray[i]);
        }
        driver.close();
    }
}
