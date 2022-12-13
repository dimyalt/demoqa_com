package sitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQaCheckbox {
    private final WebDriver driver;
    private final By homeElementArrow = By.xpath(".//li[@class='rct-node rct-node-parent rct-node-collapsed']//button");
    private final By desktopElementArrow = By.xpath(".//span[text()='Desktop']//preceding::button[1]");
    private final By notesElement = By.xpath(".//span[text()='Notes']");
    private final By documentsElementArrow = By.xpath(".//span[text()='Documents']//preceding::button[1]");
    private final By workspaceElementArrow = By.xpath(".//span[text()='WorkSpace']//preceding::button[1]");
    private final By workspaceElement = By.xpath(".//span[text()='WorkSpace']");
    private final By downloadsElementArrow = By.xpath(".//span[text()='Downloads']//preceding::button[1]");
    private final By wordfileElement = By.xpath(".//span[text()='Word File.doc']");
    private final By excelfileElement = By.xpath(".//span[text()='Excel File.doc']");
    private final By result = By.id("result");

    public DemoQaCheckbox(WebDriver driver) {
        this.driver = driver;
    }

    public String setNotes(){
        driver.findElement(homeElementArrow).click();
        driver.findElement(desktopElementArrow).click();
        driver.findElement(notesElement).click();
        return driver.findElement(result).getText().replaceAll("(\\r|\\n)", "");

    }

    public String setWorkspace(){
        driver.findElement(homeElementArrow).click();
        driver.findElement(documentsElementArrow).click();
        driver.findElement(workspaceElementArrow).click();
        driver.findElement(workspaceElement).click();
        return driver.findElement(result).getText().replaceAll("(\\r|\\n)", "");
    }

    public String setWordExcelFiles(){
        driver.findElement(homeElementArrow).click();
        driver.findElement(downloadsElementArrow).click();
        driver.findElement(wordfileElement).click();
        driver.findElement(excelfileElement).click();
        return driver.findElement(result).getText().replaceAll("(\\r|\\n)", "");
    }

}
