import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sitepages.DemoQaBooks;
import sitepages.DemoQaBooksTextboxEmailField;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;

public class TestQaBooksEmailFieldNegative {
    WebDriver driver;
    private static final String PAGE_URL = "https://demoqa.com/text-box";
    private static final String EMAIL_DATA = "testemailcom";


    @Test
    @DisplayName("Заполнение поля email невалидным значением")
    public void TestTextboxEmailField(){
        driver = new ChromeDriver(); //Драйвер для Chrome
        driver.get(PAGE_URL); //Переходим на главную страницу приложения
        DemoQaBooksTextboxEmailField objTextboxPage = new DemoQaBooksTextboxEmailField(driver); //Создаем объект гласса главной страницы
        boolean result = objTextboxPage.fillEmailField(EMAIL_DATA); // заполняем поле email
        assertTrue(result);
    }
    @After
    public void tearsDown(){
        driver.quit();
    }
}
