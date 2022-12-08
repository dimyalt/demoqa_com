import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sitepages.DemoQaBooks;

import static org.hamcrest.CoreMatchers.containsString;

public class TestDemoQaBooksLoginButton {
    WebDriver driver;

    private static final String PAGE_URL = "https://demoqa.com/books";
    private static final String expectedResult = "Login";

    @Test
    public void testLoginButton() {
        driver = new ChromeDriver(); //Драйвер для Chrome
        driver.get(PAGE_URL); //Переходим на главную страницу приложения
        DemoQaBooks objHomePage = new DemoQaBooks(driver); //Создаем объект гласса главной страницы
        String result = objHomePage.clickLoginButton(); // кликаем на кнопку логин
        MatcherAssert.assertThat(result, containsString(expectedResult));
    }
    @Test
    public void testLoginButtonMenu() {
        driver = new ChromeDriver(); //Драйвер для Chrome
        driver.get(PAGE_URL); //Переходим на главную страницу приложения
        DemoQaBooks objHomePage = new DemoQaBooks(driver); //Создаем объект гласса главной страницы
        String result = objHomePage.clickLoginButtonMenu(); // кликаем на кнопку логин
        MatcherAssert.assertThat(result, containsString(expectedResult)); // проверяем, что появилось слово Login - мы на странице логин
    }
    @After
    public void tearsDown(){
        driver.quit();
    }
}
