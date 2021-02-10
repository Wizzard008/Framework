package com.epam.automation.Tests;

import com.epam.automation.PageObject.CloudGoogleDotComPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CloudGoogleDotComEstimateFormFieldsTest extends CommonConditions {

    private CloudGoogleDotComPageObject webPage;
    @Test(description = "Test for https://cloud.google.com/")
    public  void checkEstimateFields() {
        webPage=new CloudGoogleDotComPageObject()
                .openPage()
                .submitSearchRequest()
                .openRequestedSearchResult()
                .fillEstimateFormFields()
                .submitAddToEstimate();


        Assert.assertTrue(webPage.checkEstimateFormFields()
                ,"Estimate form values differ from expected!");
    }

}
