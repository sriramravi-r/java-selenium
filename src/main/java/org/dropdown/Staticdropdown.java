package org.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Staticdropdown{
    public static void main(String[] args) {
        String static_dropdown_xpath="//select[@id='ctl00_mainContent_DropDownListCurrency']";
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //drop with select tag
        WebElement staticDropdown= driver.findElement(By.xpath(static_dropdown_xpath));
        Select select=new Select(staticDropdown);
        select.selectByIndex(3);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("AED");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("INR");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByIndex(0);
        List<WebElement> staticElementList=select.getOptions();
        for(WebElement s:staticElementList){
            System.out.println(s.getText());
        }

    }
}
