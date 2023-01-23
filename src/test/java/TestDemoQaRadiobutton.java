import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sitepages.DemoQaRadiobutton;
import static org.junit.Assert.assertTrue;

public class TestDemoQaRadiobutton {
    WebDriver driver;
    private static final String PAGE_URL = "https://demoqa.com/radio-button";

    @Test
    @DisplayName("Проверка установки радиокнопки Yes")
    public void testRadiobuttonYes(){
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        DemoQaRadiobutton objRadiobuttonPage = new DemoQaRadiobutton(driver);
        assertTrue(objRadiobuttonPage.getRadiobuttonYes());
    }
    @Test
    @DisplayName("Проверка установки радиокнопки Impressive")
    public void testRadiobuttonImpressive(){
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        DemoQaRadiobutton objRadiobuttonPage = new DemoQaRadiobutton(driver);
        assertTrue(objRadiobuttonPage.getRadiobuttonImpressive());
    }
    @After
    public void tearsDown(){
        driver.quit();
    }

}
