package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {

    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(urls.get(0));
        String title = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.startsWith("http://practice.cybertekschool.com")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        driver.get(urls.get(1));
        String titleB = driver.getTitle();
        String currentUrl1 = driver.getCurrentUrl();
        if (currentUrl1.startsWith("http://practice.cybertekschool.com")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        driver.get(urls.get(2));
        String titleC = driver.getTitle();
        String currentUrl2 = driver.getCurrentUrl();
        if (currentUrl2.startsWith("http://practice.cybertekschool.com")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        StringUtility.verifyEquals(title, titleB);
        StringUtility.verifyEquals(titleB, titleC);
        StringUtility.verifyEquals(title, titleC);
        driver.quit();
    }

}
