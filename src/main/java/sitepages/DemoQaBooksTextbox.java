package sitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQaBooksTextbox {
    private final WebDriver driver;
    private final By fullNameField = By.xpath("//input[contains(@placeholder,'Full Name')]"); //локатор поля Full Name
    private final By emailField = By.id("userEmail"); //локатор поля Email
    private final By currentAdressField = By.id("currentAddress"); //локатор поля Current Adress
    private final By permanentAddressField = By.id("permanentAddress"); //локатор поля Permanent Adress
    private final By submitButton = By.id("submit"); //локатор кнопки Submit
    private final By submitInfo = By.id("output"); //локатор введеной информации в поля



    public DemoQaBooksTextbox(WebDriver driver) {
        this.driver = driver;
    }

    public void setfullNameField(String setName){
        driver.findElement(fullNameField).isEnabled();
        driver.findElement(fullNameField).clear();
        driver.findElement(fullNameField).sendKeys(setName);
    }
    public void setEmailField(String setEmail){
        driver.findElement(emailField).isEnabled();
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(setEmail);
    }
    public void setCurrentAdressField(String setCurrentAdress){
        driver.findElement(currentAdressField).isEnabled();
        driver.findElement(currentAdressField).clear();
        driver.findElement(currentAdressField).sendKeys(setCurrentAdress);
    }
    public void setPermanentAddressField(String setPermanentAddress){
        driver.findElement(permanentAddressField).isEnabled();
        driver.findElement(permanentAddressField).clear();
        driver.findElement(permanentAddressField).sendKeys(setPermanentAddress);
    }
    public void clickSubmitButton(){
        //driver.findElement(submitButton).click();
        WebElement buttonSubmit = driver.findElement(submitButton); // Нашли кнопку Submit
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", buttonSubmit); // Прокручиваем страницу до кнопки Submit
        buttonSubmit.click();
    }


    public boolean fillAllFields(String setName, String setEmail, String setCurrentAdress, String setPermanentAddress){
        boolean flag = false;
        setfullNameField(setName);
        setEmailField(setEmail);
        setCurrentAdressField(setCurrentAdress);
        setPermanentAddressField(setPermanentAddress);
        clickSubmitButton();
        new WebDriverWait(driver, Duration.ofSeconds(1));
        if (driver.findElement(submitInfo).isDisplayed()){
            flag = true;
        }
        return flag;
    }
}
