import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import sitepages.DemoQaButtons;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;

public class TestDemoQaButtons {
    WebDriver driver;
    private static final String PAGE_URL = "https://demoqa.com/buttons";


    @Test
    @DisplayName("Клик по копке")
    public void clickButtonPositive(){
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        DemoQaButtons objDemoQaButtons = new DemoQaButtons(driver);
        String result = objDemoQaButtons.getClickButton();
        String clickResult = "You have done a dynamic click";
        MatcherAssert.assertThat(result, containsString(clickResult));
    }
    @Test
    @DisplayName("Двойной клик по кнопке")
    public void doubleClickButtonPositive(){
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        //Вот тут я не совсем уверен в правильности и изящности своих действий
        Actions actions = new Actions(driver); // Создали действие
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn")); // Нашли кнопку на которую надо кликнуть дважды
        actions.doubleClick(doubleClickButton).perform(); // Выполнили двойной клик
        // Ищем появившуюся надпись и записываем ее в переменную
        String result = driver.findElement(By.xpath(".//p[text()='You have done a double click']")).getText();
        String doubleClickResult = "You have done a double click";
        MatcherAssert.assertThat(result, containsString(doubleClickResult)); // Сравниваем переменную с ожидаемым текстом
    }
    @Test
    @DisplayName("Клик правой кнопкой")
    public void rightClickButtonPositive(){
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        //Вот тут я не совсем уверен в правильности и изящности своих действий
        Actions actions = new Actions(driver); // Создали действие
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn")); // Нашли кнопку на которую надо кликнуть ПКМ
        actions.contextClick(rightClickButton).perform(); // Выполнили двойной клик
        // Ищем появившуюся надпись и записываем ее в переменную
        String result = driver.findElement(By.xpath(".//p[text()='You have done a right click']")).getText();
        String rightClickResult = "You have done a right click";
        MatcherAssert.assertThat(result, containsString(rightClickResult)); // Сравниваем переменную с ожидаемым текстом
    }
    @Test
    @DisplayName("Двойной клик по кнопке для клика правой кнопкой")
    public void clickButtonNegative(){
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        boolean result; // переменная для сравнения
        //Вот тут я не совсем уверен в правильности и изящности своих действий
        Actions actions = new Actions(driver); // Создали действие
        WebElement rightClickButton = driver.findElement(By.xpath(".//button[text()='Click Me']")); // Нашли кнопку на которую надо кликнуть ПКМ
        actions.contextClick(rightClickButton).perform(); // Выполнили двойной клик
        try {
            driver.findElement(By.xpath(".//p[text()='You have done a dynamic click']")).getText();
            result = false;
        } catch (
                NoSuchElementException e) {
            result = true;
        }
        assertTrue(result);
    }
    @Test
    @DisplayName("Клик правой кнопкой мышки по кнопке для одного нажатия")
    public void rightClickButtonNegative(){
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        DemoQaButtons objDemoQaButtons = new DemoQaButtons(driver);
        assertTrue(objDemoQaButtons.getRightClickButtonNegative());

    }
    @Test
    @DisplayName("Один клик кнопкой по кнопке для двойного нажатия")
    public void doubleClickButtonNegative(){
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        DemoQaButtons objDemoQaButtons = new DemoQaButtons(driver);
        assertTrue(objDemoQaButtons.getDoubleClickButtonNegative());
    }

    @After
    public void tearsDown(){
        driver.quit();
    }




}
