package com.sofkau.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class FormPage extends CommonActionOnPage {
    public static ArrayList<String> esperados = new ArrayList<>();
    public static ArrayList<String> obtenidos = new ArrayList<>();
    //constructor
    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    //Localizadores
    @CacheLookup
    @FindBy(xpath = "(//div[@class='card-up'])[2]")
    public WebElement form;
    @CacheLookup
    @FindBy(xpath = "(//div[text()='Elements'])")
    public WebElement elements;
    @CacheLookup
    @FindBy(xpath = "(//li[@class='btn btn-light ' and @id='item-3'])[1]")
    public WebElement practiceTable;
    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    public WebElement botonAdd;
    @CacheLookup
    @FindBy(id = "firstName")
    public WebElement name;
    @CacheLookup
    @FindBy(id = "lastName")
    public WebElement lastName;
    @CacheLookup
    @FindBy(id = "userEmail")
    public WebElement email;
    @CacheLookup
    @FindBy(id = "age")
    public WebElement age;
    @CacheLookup
    @FindBy(id = "salary")
    public WebElement salary;
    @CacheLookup
    @FindBy(id = "department")
    public WebElement department;

    public void clickForm() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("(//div[@class='card-up'])[2]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(200);
        elements.click();
        executor.executeScript("scrollBy(0,500);");
        practiceTable.click();
        botonAdd.click();
    }

    public void fillMandatoryFields(String firstName, String lastName, String userEmail, String age, String salary, String department) {
        this.name.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(userEmail);
        this.age.sendKeys(age);
        this.salary.sendKeys(salary);
        this.department.sendKeys(department);
        resultado();
    }

    public void resultado() {
        WebElement element;
        setZoom(55);
        for (int i = 2; i <= 20; i++) {
            if (i == 16)
                i += 2;
            element = driver.findElement(By.xpath("(//td)[" + i + "]"));
            obtenidos.add(element.getText());
            i++;
        }
    }
}