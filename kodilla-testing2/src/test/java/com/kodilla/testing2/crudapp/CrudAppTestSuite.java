package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://sirvertar.github.io/";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        driver.quit();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
    }

    private boolean checkTaskExistsIntTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("mateusz.jakuszko@gmail.com");
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(5000);

        driverTrello.findElement(By.id("password")).sendKeys("15Azkill12!");
        driverTrello.findElement(By.id("login-submit")).submit();

        Thread.sleep(5000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(WebElement::click);

        Thread.sleep(2000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size() > 0;

        driverTrello.close();

        return result;
    }

    private boolean checkTaskHasBeenDeleted(String taskName) throws InterruptedException {
        boolean isDeleted = false;
        WebDriver driver2 = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver2.get(BASE_URL);

        while (!driver2.findElement(By.xpath("//form[@class=\"datatable__row\"]")).isDisplayed()) ;

        driver2.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(webElement -> webElement.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(webElement -> webElement.
                        findElement(By.xpath(".//div[contains(@class, \"section-wrapper\")]/" +
                                "fieldset[contains(@class, \"button-section\")]/button[@data-task-delete-button]"))
                        .click());

        Thread.sleep(2000);

        if (driver2.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .noneMatch(webElement ->
                        webElement.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))) {
            isDeleted = true;
        }
        driver2.close();
        return isDeleted;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsIntTrello(taskName));
        assertTrue(checkTaskHasBeenDeleted(taskName));
    }


}
