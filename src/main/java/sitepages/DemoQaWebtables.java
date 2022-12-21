package sitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQaWebtables {
    private final WebDriver driver;
    private final By addButton = By.id("addNewRecordButton");
    private final By firstnameField = By.id("firstName");
    private final By lastnameField = By.id("lastName");
    private final By emailField = By.id("userEmail");
    private final By ageField = By.id("age");
    private final By salaryField = By.id("salary");
    private final By departmentField = By.id("department");
    private final By submitButton = By.id("submit");

    public DemoQaWebtables(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddButton(){
        driver.findElement(addButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(1)); // Даем время прогрузиться
    }
    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(1)); // Даем время прогрузиться
    }

    public boolean setAllFields(String setFirstname, String setLastname, String setUserEmail,
                             String setAge, String setSalary, String setDepartment){
        createRecord(setFirstname, setLastname, setUserEmail, setAge, setSalary, setDepartment);
        driver.findElement(By.xpath(".//div[text()='"+ setFirstname +"']"));
        return true;
    }

    public String setMailFieldNegative(String setFirstname, String setLastname, String setUserEmail,
                                String setAge, String setSalary, String setDepartment){
        createRecord(setFirstname, setLastname, setUserEmail, setAge, setSalary, setDepartment);
        return driver.findElement(emailField).getCssValue("background-image");
    }

    public String setSalaryFieldNegative(String setFirstname, String setLastname, String setUserEmail,
                                       String setAge, String setSalary, String setDepartment){
        createRecord(setFirstname, setLastname, setUserEmail, setAge, setSalary, setDepartment);
        return driver.findElement(salaryField).getCssValue("background-image");
    }

    public boolean clickDeleteButton(String setFirstname, String setLastname, String setUserEmail,
                                     String setAge, String setSalary, String setDepartment) throws Exception {
        createRecord(setFirstname, setLastname, setUserEmail, setAge, setSalary, setDepartment);
        driver.findElement(By.xpath(".//div[text()='"+ setFirstname +"']//following::span[@title='Delete']")).click();
        return verifyElementAbsent(setFirstname);
    }
    private void createRecord(String setFirstname, String setLastname, String setUserEmail,
                              String setAge, String setSalary, String setDepartment){
        clickAddButton();
        driver.findElement(firstnameField).sendKeys(setFirstname);
        driver.findElement(lastnameField).sendKeys(setLastname);
        driver.findElement(emailField).sendKeys(setUserEmail);
        driver.findElement(ageField).sendKeys(setAge);
        driver.findElement(salaryField).sendKeys(setSalary);
        driver.findElement(departmentField).sendKeys(setDepartment);
        clickSubmitButton();
    }
    private boolean verifyElementAbsent(String setFirstname) throws Exception { // Метод проверки наличия записи в таблице
        try {
            driver.findElement(By.xpath(".//div[text()='"+ setFirstname +"']"));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public boolean editSalaryField(String setFirstname, String setLastname, String setUserEmail,
                              String setAge, String setSalary, String setDepartment,
                              String setNewSalary){
        createRecord(setFirstname, setLastname, setUserEmail, setAge, setSalary, setDepartment);
        driver.findElement(By.xpath(".//div[text()='"+ setFirstname +"']//following::span[@title='Edit']")).click();
        driver.findElement(salaryField).clear();
        driver.findElement(salaryField).sendKeys(setNewSalary);
        clickSubmitButton();
        driver.findElement(By.xpath(".//div[text()='"+ setFirstname +"']//following::div[text()='"+ setNewSalary +"']"));
        return true;
    }
    public boolean editDepartmentField(String setFirstname, String setLastname, String setUserEmail,
                                   String setAge, String setSalary, String setDepartment,
                                       String newDepartment){
        createRecord(setFirstname, setLastname, setUserEmail, setAge, setSalary, setDepartment);
        driver.findElement(By.xpath(".//div[text()='"+ setFirstname +"']//following::span[@title='Edit']")).click();
        driver.findElement(departmentField).clear();
        driver.findElement(departmentField).sendKeys(newDepartment);
        clickSubmitButton();
        driver.findElement(By.xpath(".//div[text()='"+ setFirstname +"']//following::div[text()='"+ newDepartment +"']"));
        return true;
    }
    public boolean editSalaryAndDepartmentField(String setFirstname, String setLastname, String setUserEmail,
                                       String setAge, String setSalary, String setDepartment,
                                       String newDepartment, String setNewSalary){
        createRecord(setFirstname, setLastname, setUserEmail, setAge, setSalary, setDepartment);
        driver.findElement(By.xpath(".//div[text()='"+ setFirstname +"']//following::span[@title='Edit']")).click();
        driver.findElement(salaryField).clear();
        driver.findElement(salaryField).sendKeys(setNewSalary);
        driver.findElement(departmentField).clear();
        driver.findElement(departmentField).sendKeys(newDepartment);
        clickSubmitButton();
        driver.findElement(By.xpath(".//div[text()='"+ setFirstname +"']//following::div[text()='"+ setNewSalary +"']"));
        driver.findElement(By.xpath(".//div[text()='"+ setFirstname +"']//following::div[text()='"+ newDepartment +"']"));
        return true;
    }

}
