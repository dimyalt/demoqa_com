import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sitepages.DemoQaWebtables;

import static org.junit.Assert.assertTrue;

public class TestDemoQaWebtablesEditRecord {
    WebDriver driver;
    private static final String PAGE_URL = "https://demoqa.com/webtables";
    String name = "Макар";
    String lastname = "Булкин";
    String email = "makar53@ya.ru";
    String age = "61";
    String salary = "87000";
    String department = "Отдел котоглажки";
    String newSalary = "95000";
    String newDepartment = "Управление распеделения";

    @Test
    @DisplayName("Редактрование строки вебтаблицы (поле Salary)")
    public void setNewSalaryData() {
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        DemoQaWebtables objDemoAqWebtables = new DemoQaWebtables(driver);
        assertTrue(objDemoAqWebtables.editSalaryField(name, lastname, email, age, salary, department, newSalary));
    }
    @Test
    @DisplayName("Редактрование строки вебтаблицы (поле Department)")
    public void setNewDepartmentData() {
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        DemoQaWebtables objDemoAqWebtables = new DemoQaWebtables(driver);
        assertTrue(objDemoAqWebtables.editDepartmentField(name, lastname, email, age, salary, department, newDepartment));
    }
    @Test
    @DisplayName("Редактрование строки вебтаблицы (поля Salary и Department)")
    public void setNewData(){
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        DemoQaWebtables objDemoAqWebtables = new DemoQaWebtables(driver);
        assertTrue(objDemoAqWebtables.editSalaryAndDepartmentField(name, lastname, email, age, salary, department,
                newDepartment, newSalary));

    }
    @After
    public void tearsDown(){
        driver.quit();
    }
}
