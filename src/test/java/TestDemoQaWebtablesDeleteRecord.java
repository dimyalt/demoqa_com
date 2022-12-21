import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sitepages.DemoQaWebtables;

import static org.junit.Assert.assertTrue;

public class TestDemoQaWebtablesDeleteRecord {
    WebDriver driver;
    private static final String PAGE_URL = "https://demoqa.com/webtables";
    String name = "Макар";
    String lastname = "Булкин";
    String email = "makar53@ya.ru";
    String age = "61";
    String salary = "87000";
    String department = "Отдел котоглажки";
    @Test
    public void deleteRecord() throws Exception {
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        DemoQaWebtables objDemoAqWebtables = new DemoQaWebtables(driver);
        assertTrue(objDemoAqWebtables.clickDeleteButton(name, lastname, email, age, salary, department));
    }
    @After
    public void tearsDown(){
        driver.quit();
    }
}
