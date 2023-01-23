import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sitepages.DemoQaWebtables;

import static org.junit.Assert.assertEquals;


public class TestDemoQaWebtablesAllNegative {
    WebDriver driver;
    String name = "Макар";
    String lastname = "Булкин";
    String email = "makar53ya.ru";
    String age = "10";
    String salary = "-";
    String department = "Отдел котоглажки";

    String expectedResult = "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")";

    private static final String PAGE_URL = "https://demoqa.com/webtables";

    @Test
    @DisplayName("Заполнение строки вебтаблицы с негативным значением поля Mail")
    public void setMailFieldNegative(){
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        DemoQaWebtables objDemoAqWebtables = new DemoQaWebtables(driver);
        assertEquals(expectedResult, objDemoAqWebtables.setMailFieldNegative(name, lastname, email, age, salary, department));
    }
    @Test
    @DisplayName("Заполнение строки вебтаблицы с негативным значением поля Salary")
    public void setSalaryFieldNegative(){
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        DemoQaWebtables objDemoAqWebtables = new DemoQaWebtables(driver);
        assertEquals(expectedResult, objDemoAqWebtables.setSalaryFieldNegative(name, lastname, email, age, salary, department));
    }
    @After
    public void tearsDown(){
        driver.quit();
    }
}
