package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static WebDriver driver;
    public static void main(String[] args) {
        chrome();
        firefox();
        safari();

    }
    public static void chrome() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        String title = driver.getTitle();
        String expectedTitle = "Google";
        System.out.println("Title is..." + title);
        BrowserUtils.wait(2);
        driver.get("http://etsy.com");
        driver.navigate().back();
        BrowserUtils.wait(2);
        verifyEquals(driver.getTitle(), "Google");
        driver.navigate().forward();
        verifyEquals(driver.getTitle(), "Google");
        BrowserUtils.wait(2);

        driver.quit();
    }
    public static void firefox() {
        driver = BrowserFactory.getDriver("firefox");
        driver.get("http://google.com");
        BrowserUtils.wait(2);
        BrowserUtils.wait(2);
        String title = driver.getTitle();
        String expectedTitle = "Google";
        System.out.println("Title is..." + title);
        BrowserUtils.wait(2);
        driver.get("http://etsy.com");
        driver.navigate().back();
        BrowserUtils.wait(2);
        verifyEquals(driver.getTitle(), "Google");
        driver.navigate().forward();
        verifyEquals(driver.getTitle(), "Google");
        BrowserUtils.wait(2);
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        BrowserUtils.wait(2);

        driver.quit();
    }
    public static void safari() {
        driver = BrowserFactory.getDriver("safari");
        driver.get("http://google.com");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        String title = driver.getTitle();
        String expectedTitle = "Google";
        System.out.println("Title is..." + title);
        BrowserUtils.wait(2);
        driver.get("http://etsy.com");
        driver.navigate().back();
        BrowserUtils.wait(2);
        verifyEquals(driver.getTitle(), "Google");
        driver.navigate().forward();
        verifyEquals(driver.getTitle(), "Google");
        BrowserUtils.wait(2);
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        BrowserUtils.wait(2);

        driver.quit();
        verifyEquals(expectedTitle, title);
    }
    public static void verifyEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }



}
