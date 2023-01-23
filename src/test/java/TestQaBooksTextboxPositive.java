import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sitepages.DemoQaBooksTextbox;


import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestQaBooksTextboxPositive {
    WebDriver driver;
    private static final String PAGE_URL = "https://demoqa.com/text-box";
    private final String setName;
    private final String setEmail;
    private final String setCurrentAdress;
    private final String setPermanentAddress;

    public TestQaBooksTextboxPositive(String setName, String setEmail, String setCurrentAdress, String setPermanentAddress) {
        this.setName = setName;
        this.setEmail = setEmail;
        this.setCurrentAdress = setCurrentAdress;
        this.setPermanentAddress = setPermanentAddress;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Шлиппенрубель Аристарх Иванович", "test@example.com",
                        "237221, Мурманская область, город Наро-Фоминск, наб. Чехова, 63",
                        "400807, Астраханская область, город Можайск, ул. Славы, 44"
                },
        };
    }

    @Test
    @DisplayName("Заполнение формы валидным значением")
    public void testTextbox(){
        driver = new ChromeDriver(); //Драйвер для Chrome
        driver.get(PAGE_URL); //Переходим на главную страницу приложения
        DemoQaBooksTextbox objHomePage = new DemoQaBooksTextbox(driver); //Создаем объект класса страницы с веб-формой
        boolean result = objHomePage.fillAllFields(setName, setEmail, setCurrentAdress, setPermanentAddress);
        assertTrue(result);
    }
    @After
    public void tearsDown(){
        driver.quit();
    }
}
