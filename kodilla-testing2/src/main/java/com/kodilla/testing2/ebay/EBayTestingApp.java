package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    public static final String SEARCH_FIELD_ID = "gh-ac";

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://www.ebay.com/");

        WebElement ebaySearchField = webDriver.findElement(By.id(SEARCH_FIELD_ID));
        ebaySearchField.sendKeys("Laptop");
        ebaySearchField.submit();
    }
}
