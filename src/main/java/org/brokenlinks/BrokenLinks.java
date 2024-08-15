package org.brokenlinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {
    @Test
    public void Test_BrokenLinks() throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.cssSelector("li[class=\"gf-li\"] a"));
        SoftAssert sf=new SoftAssert();
        for(WebElement link:links){
            String url = link.getAttribute("href");
            HttpURLConnection urlConnection= (HttpURLConnection) new URL(url).openConnection();
            int respcode=urlConnection.getResponseCode();
            sf.assertTrue(respcode<400,"this "+link.getText()+"is broken");
        }
        sf.assertAll();
        driver.quit();
    }
}
