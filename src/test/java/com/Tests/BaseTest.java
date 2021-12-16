package com.Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
//    public static Properties props;
//    public static FileInputStream fis;
    public ExtentHtmlReporter htmlreporter;
    public static ExtentReports htmlreports;
    public static ExtentTest logger;

    @BeforeTest
    public void beforeTest(){
        htmlreporter= new ExtentHtmlReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"Test Automation Report");
        htmlreporter.config().setEncoding("utf-8");
        htmlreporter.config().setDocumentTitle("Test Automaiton Report");
        htmlreports= new ExtentReports();
        htmlreports.attachReporter(htmlreporter);

    }

    @BeforeMethod
    public void beforeMethod(Method testmethod){
        logger=htmlreports.createTest(testmethod.getName());
        launchBrowser(Properties.browser);
        driver.get(Properties.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS){
            String method=result.getMethod().getMethodName();
            String Test="TestCase: "+method+" Passed";
            Markup m= MarkupHelper.createLabel(Test, ExtentColor.GREEN);
            logger.log(Status.PASS,m);
        }else if(result.getStatus()==ITestResult.FAILURE){
            String method=result.getMethod().getMethodName();
            String Test="TestCase: "+method+" Failed";
            Markup m= MarkupHelper.createLabel(Test, ExtentColor.RED);
            logger.log(Status.FAIL,m);
        }
        driver.quit();
    }

    @AfterTest
    public void afterTest(){
        htmlreports.flush();

    }

    public void launchBrowser(String browser){
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\Inceptica\\drivers\\chromedriver.exe");
            driver=new ChromeDriver();
        }
    }

////    public void loadPropertiesFile() throws IOException {
////        File f=new File("./properties/config");
//        BufferedReader reader;
//        reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\config.properties"));
////        File f=new File(System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\config");
////        fis = new FileInputStream();
//        props.load(reader);
//    }
}
