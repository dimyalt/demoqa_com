import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sitepages.DemoQaWebtables;

import static org.junit.Assert.assertTrue;

public class TestDemoQaWebtablesAllPositive {
    WebDriver driver;
    String name = "Макар";
    String lastname = "Булкин";
    String email = "makar53@ya.ru";
    String age = "61";
    String salary = "87000";
    String department = "Отдел котоглажки";

    private static final String PAGE_URL = "https://demoqa.com/webtables";

    @Test
    @DisplayName("Заполнение строки вебтаблицы с позитивными значениями")
    public void testAddNewString(){
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        DemoQaWebtables objDemoAqWebtables = new DemoQaWebtables(driver);
        assertTrue(objDemoAqWebtables.setAllFields(name, lastname, email, age, salary, department));
    }
    @After
    public void tearsDown(){
        driver.quit();
    }
}
