package sitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQaBooksTextboxEmailField {
    private final WebDriver driver;
    private final By emailField = By.id("userEmail"); //локатор поля Email
    private final By submitButton = By.id("submit"); //локатор кнопки Submit
    private final By emailFieldError = By.xpath(".//input[@class='mr-sm-2 field-error form-control']"); // локатор поля с индикацией ошибки заполнения



    public DemoQaBooksTextboxEmailField(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailField(String setEmail){
        driver.findElement(emailField).isEnabled();
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(setEmail);
    }
    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public boolean fillEmailField(String setEmail){
        boolean flag = false;
        setEmailField(setEmail);
        clickSubmitButton();
        new WebDriverWait(driver, Duration.ofSeconds(1));

        if (driver.findElement(emailFieldError).isDisplayed()){
            flag = true;
        }
        return flag;
    }
}


