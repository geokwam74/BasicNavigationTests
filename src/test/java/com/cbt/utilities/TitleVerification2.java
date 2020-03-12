package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://luluandgeorgia.com", "http://wayfair.com", "http://walmart.com",
                "http://westelm.com");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        for (String url : urls) {
            driver.get(url);
            String title = driver.getTitle().replace(" ", "").toLowerCase();
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains(title)) {
                System.out.println("PASS: " + driver.getCurrentUrl() + " the url contains " + title);
            } else {
                System.out.println("FAIL: " + driver.getCurrentUrl() + " the url does not contains " + title);
            }
        }
        driver.quit();

    }
}
