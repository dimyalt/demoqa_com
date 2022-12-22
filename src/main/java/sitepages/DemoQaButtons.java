package sitepages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQaButtons {
    WebDriver driver;
    private final By doubleClickButton = By.id("doubleClickBtn");
    private final By doubleClickButtonResult = By.xpath(".//p[text()='You have done a double click']");
    private final By rightClickButton = By.id("rightClickBtn");
    private final By rightClickButtonResult = By.xpath(".//p[text()='You have done a right click']");
    private final By clickButton = By.xpath(".//button[text()='Click Me']");
    private final By clickButtonResult = By.xpath(".//p[text()='You have done a dynamic click']");

    public DemoQaButtons(WebDriver driver){
        this.driver = driver;
    }

    public String getClickButton(){
        driver.findElement(clickButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(1)); // Даем время прогрузиться
        return driver.findElement(clickButtonResult).getText();
    }

    public boolean getRightClickButtonNegative(){
        //actions.contextClick(elementLocator).perform();
        driver.findElement(rightClickButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(1)); // Даем время прогрузиться
        boolean result;
        try {
            driver.findElement(rightClickButtonResult).getText();
            result = false;
        } catch (NoSuchElementException e) {
            result = true;
        }
        return result;

    }    public boolean getDoubleClickButtonNegative(){
        driver.findElement(doubleClickButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(1)); // Даем время прогрузиться
        boolean result;
        try {
            driver.findElement(doubleClickButtonResult).getText();
            result = false;
        } catch (NoSuchElementException e) {
            result = true;
        }
        return result;
    }
}
