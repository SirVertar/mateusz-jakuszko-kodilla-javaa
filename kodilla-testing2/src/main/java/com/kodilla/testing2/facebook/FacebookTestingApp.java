package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String FACEBOOK_URL = "https://www.facebook.com/";
    public static final String DAY_OF_BIRTH = "//div[contains(@class, \"5k_5\")]/span/span/select[@id = \"day\"]";
    public static final String MONTH_OF_BIRTH = "//div[contains(@class, \"5k_5\")]/span/span/select[@id = \"month\"]";
    public static final String YEAR_OF_BIRTH = "//div[contains(@class, \"5k_5\")]/span/span/select[@id = \"year\"]";


    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get(FACEBOOK_URL);

        WebElement dayOfBirth = webDriver.findElement(By.xpath(DAY_OF_BIRTH));
        Select selectDay = new Select(dayOfBirth);
        selectDay.selectByValue("2");

        WebElement monthOfBirth = webDriver.findElement(By.xpath(MONTH_OF_BIRTH));
        Select selectMonth = new Select(monthOfBirth);
        selectMonth.selectByValue("2");

        WebElement yearOfBirth = webDriver.findElement(By.xpath(YEAR_OF_BIRTH));
        Select selectYear = new Select(yearOfBirth);
        selectYear.selectByValue("2006");
    }
}
