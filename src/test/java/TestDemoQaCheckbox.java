import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sitepages.DemoQaCheckbox;

import static org.hamcrest.CoreMatchers.containsString;

public class TestDemoQaCheckbox {
    WebDriver driver;
    private static final String PAGE_URL = "https://demoqa.com/checkbox";
    private static final String expectedResultNotes = "You have selected :notes";
    private static final String expectedResultWorkspace = "You have selected :workspacereactangularveu";
    private static final String expectedResultWordExcelFiles = "You have selected :downloadswordFileexcelFile";

    @Test
    @DisplayName("Проверка установки чекбокса Notes")
    public void testChekcboxNotes(){
        driver = new ChromeDriver(); //Драйвер для Chrome
        driver.get(PAGE_URL); //Переходим на главную страницу приложения
        DemoQaCheckbox objCheckboxPage = new DemoQaCheckbox(driver); //Создаем объект класса главной страницы
        String result = objCheckboxPage.setNotes(); // кликаем на чекбокс Notes
        MatcherAssert.assertThat(result, containsString(expectedResultNotes));
    }
    @Test
    @DisplayName("Проверка установки чекбокса WorkSpace")
    public void testChekcboxWorkspace(){
        driver = new ChromeDriver(); //Драйвер для Chrome
        driver.get(PAGE_URL); //Переходим на главную страницу приложения
        DemoQaCheckbox objCheckboxPage = new DemoQaCheckbox(driver); //Создаем объект класса главной страницы
        String result = objCheckboxPage.setWorkspace(); // кликаем чекбокс WorkSpace
        MatcherAssert.assertThat(result, containsString(expectedResultWorkspace));
    }
    @Test
    @DisplayName("Проверка установки чекбоксов Files")
    public void testChekcboxWordExcelFiles(){
        driver = new ChromeDriver(); //Драйвер для Chrome
        driver.get(PAGE_URL); //Переходим на главную страницу приложения
        DemoQaCheckbox objCheckboxPage = new DemoQaCheckbox(driver); //Создаем объект класса главной страницы
        String result = objCheckboxPage.setWordExcelFiles(); // кликаем чекбоксы Files
        MatcherAssert.assertThat(result, containsString(expectedResultWordExcelFiles));
    }
    @After
    public void tearsDown(){
        driver.quit();
    }

}
