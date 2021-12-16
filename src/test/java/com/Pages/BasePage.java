package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    public static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }


}
