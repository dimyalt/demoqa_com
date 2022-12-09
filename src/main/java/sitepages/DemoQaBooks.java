package sitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQaBooks {
    private final WebDriver driver;
    private final By loginButton = By.id("login"); // локатор кнопки "Login"
    private final By loginButtonMenu = By.xpath("//span[text()='Login']"); // локатор кнопки "Login" в меню
    private final By loginOk = By.xpath("//div[text()='Login']"); //Локатор проверки перехода на страницу логин
    public DemoQaBooks(WebDriver driver) {
        this.driver = driver;
    }
    public String clickLoginButton(){
        driver.findElement(loginButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(1)); // Даем время прогрузиться
        return getLoginPage();
    }

    public String clickLoginButtonMenu(){
        driver.findElement(loginButtonMenu).click();
        new WebDriverWait(driver, Duration.ofSeconds(1)); // Даем время прогрузиться
        return getLoginPage();
    }
    public String getLoginPage() {
        return driver.findElement(loginOk).getText();
    }

}
