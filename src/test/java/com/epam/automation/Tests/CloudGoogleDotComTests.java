package com.epam.automation.Tests;

import com.epam.automation.PageObject.CloudGoogleDotComPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CloudGoogleDotComTests {
    private WebDriver driver;
    private CloudGoogleDotComPageObject webPage;
    @BeforeMethod(alwaysRun = true)
    public  void resetBrowser() {
        driver=new ChromeDriver();
        webPage=new CloudGoogleDotComPageObject(driver)
                .openPage()
                .submitSearchRequest()
                .openRequestedSearchResult()
                .fillEstimateFormFields()
                .submitAddToEstimate()
                .clickEmailEstimate()
                .generateTemporaryEmail()
                .fillEmailEstimateForm()
                .clickSendEmail();
    }

    @Test(description = "Test for https://cloud.google.com/")
    public  void checkMonthlyPayment() {
        Assert.assertEquals(webPage.getTotalEstimatedCostFromEmail(), 1082, 1.0
                , "Monthly payment value differ from expected!");
    }

    @AfterMethod(alwaysRun = true)
    public  void quiteBrowser() {
        driver.quit();
        driver=null;
    }
}
