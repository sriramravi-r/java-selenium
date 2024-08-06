package org.windowactivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class example {
    public static void main(String[] args) {
        WebDriver webDriver=new ChromeDriver();
        webDriver.manage().window().maximize();
        // wait until all the components are fully loaded
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // if basic element is loaded it will start execution
        webDriver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");

    }
}
