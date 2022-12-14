package sitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQaRadiobutton {
    private final WebDriver driver;
    private final By radiobuttonYes = By.xpath(".//label[text()='Yes']");
    private final By radiobuttonImpressive = By.xpath(".//label[text()='Impressive']");
    private final By spanTextYes = By.xpath(".//span[text()='Yes']");
    private final By spanTextImpressive = By.xpath(".//span[text()='Impressive']");

    public DemoQaRadiobutton(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getRadiobuttonYes(){
        driver.findElement(radiobuttonYes).click();
        return driver.findElement(spanTextYes).isDisplayed();
    }
    public boolean getRadiobuttonImpressive(){
        driver.findElement(radiobuttonImpressive).click();
        return driver.findElement(spanTextImpressive).isDisplayed();
    }
}
