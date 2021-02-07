package com.epam.automation.Tests;

import com.epam.automation.PageObject.CloudGoogleDotComPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CloudGoogleDotComTotalEstimateTest extends CommonConditions {

    private CloudGoogleDotComPageObject webPage;

    @Test(description = "Test for https://cloud.google.com/")
    public  void checkMonthlyPaymentFromForm() {
        webPage=new CloudGoogleDotComPageObject(driver)
                .openPage()
                .submitSearchRequest()
                .openRequestedSearchResult()
                .fillEstimateFormFields()
                .submitAddToEstimate();

        Assert.assertEquals(webPage.getTotalEstimatedCost(), 1082.77, 0.0
                , "Monthly payment value differ from expected!");
    }

}
