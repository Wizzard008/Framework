package com.epam.automation.Tests;

import com.epam.automation.PageObject.CloudGoogleDotComPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CloudGoogleDotComEmailVerificationTest extends CommonConditions {

    private CloudGoogleDotComPageObject webPage;

    @Test(description = "Test for https://cloud.google.com/")
    public  void checkMonthlyPaymentFromEmail() {
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
        Assert.assertEquals(webPage.getTotalEstimatedCostFromEmail(), 1082, 1.0
                , "Monthly payment value differ from expected!");
    }



}
