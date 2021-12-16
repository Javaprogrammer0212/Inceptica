package com.Tests;

import com.Pages.HomePage;
import org.testng.annotations.Test;

public class SearchJob extends BaseTest{
    HomePage p=new HomePage(driver);
    @Test
    public void searchJOBUsingBasicSearch() throws InterruptedException {
        p.basicSearch("Testing","London","\n" +
                "                                up to 2 miles\n" +
                "                            ");
        Thread.sleep(10000);
        driver.findElement(HomePage.getInputFindJobs()).click();

    }

    @Test
    public void searchJobUsingMoreSearchOptions() throws Exception {
        p.searchWithMoreOptions("5000","10000","Per annum","Permanent");
        Thread.sleep(10000);
        driver.findElement(HomePage.getInputFindJobs()).click();
    }

}
