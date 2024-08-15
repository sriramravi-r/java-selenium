package org.screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    @Test
    public void Test_Screenshots() throws IOException {
        ChromeOptions chromeOptions=new ChromeOptions();
//        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        File src=((TakesScreenshot)driver)  //casting driver object to take screenshot method
                .getScreenshotAs(OutputType.FILE); //convert screenshot to file
        // add common.io dependency to copy the screenshot to our local system
        // FileUtils class help to copy the screenshot to local machine
        FileUtils.copyFile(src,new File("C:\\Users\\LENOVO\\Downloads\\Automation notes\\Selenium\\selenium\\src\\main\\java\\org\\screenshots\\screenshot.png"));
        driver.quit();
    }
}
