package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static By inputKeyword =By.xpath("//input[@id='keywords']");
    private static By inputLoc =By.xpath("//input[@id='location']");
    private static By listDistance= By.xpath("//select[@id='distance']");
    private static By inputMinSalary=By.xpath("//input[@id='salarymin']");
    private static By inputMaxSalary=By.xpath("//input[@id='salarymax']");
    private static By listSalaryType= By.xpath("//select[@id='salarytype']");
    private static By listJobType= By.xpath("//select[@id='tempperm']");
    private static By btnMoreSearchOptions=By.xpath("//button[@id='toggle-hp-search']");
    private static By inputFindJobs=By.xpath("//input[@id='hp-search-btn']");

    public static By getInputKeyword() {
        return inputKeyword;
    }

    public static By getInputLoc() {
        return inputLoc;
    }

    public static By getListDistance() {
        return listDistance;
    }

    public static By getInputMinSalary() {
        return inputMinSalary;
    }

    public static By getInputMaxSalary() {
        return inputMaxSalary;
    }

    public static By getListSalaryType() {
        return listSalaryType;
    }

    public static By getListJobType() {
        return listJobType;
    }

    public static By getBtnMoreSearchOptions() {
        return btnMoreSearchOptions;
    }

    public static By getInputFindJobs() {
        return inputFindJobs;
    }

    public void basicSearch(String Keywords,String Location, String Distance){
        driver.findElement(getInputKeyword()).sendKeys(Keywords);
        driver.findElement(getInputLoc()).sendKeys(Location);
        selectValue(getListDistance(),Distance);
    }

    public void searchWithMoreOptions(String MinSal,String MaxSal, String SalType, String JobType) throws Exception {
//        driver.findElement(getBtnMoreSearchOptions()).click();
        clickWithJS(getBtnMoreSearchOptions());
        Thread.sleep(10000);
        driver.findElement(getInputMinSalary()).sendKeys(MinSal);
        driver.findElement(getInputMaxSalary()).sendKeys(MaxSal);
        selectValue(getListSalaryType(),SalType);
        selectValue(getListJobType(),JobType);
    }


    public void selectValue(By by,String Text){
        WebElement list= driver.findElement(by);
        Select s=new Select(list);
        s.selectByVisibleText(Text);
    }

    public void clickWithJS(By by){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0]. click();",by);
    }
}