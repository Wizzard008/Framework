package com.epam.automation.Tests;

import com.epam.automation.PageObject.CloudGoogleDotComPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CloudGoogleDotComEstimateFormFieldsTest extends CommonConditions {

    private CloudGoogleDotComPageObject webPage;
    @Test(description = "Test for https://cloud.google.com/")
    public  void checkEstimateFields() {
        webPage=new CloudGoogleDotComPageObject(driver)
                .openPage()
                .submitSearchRequest()
                .openRequestedSearchResult()
                .fillEstimateFormFields()
                .submitAddToEstimate();
        List<String> estimateFieldsValues=webPage.getEstimateFormValues();
        Boolean checkVMClass=estimateFieldsValues.get(1).equalsIgnoreCase("VM class: regular");
        Boolean checkInstanceType=estimateFieldsValues.get(2).equalsIgnoreCase("Instance type: n1-standard-8");
        Boolean checkRegion=estimateFieldsValues.get(3).equalsIgnoreCase("Region: Frankfurt");
        Boolean checkLocalSSD=estimateFieldsValues.get(4).equalsIgnoreCase("Total available local SSD space 2x375 GiB");
        Boolean checkCommitmentTerm=estimateFieldsValues.get(5).equalsIgnoreCase("Commitment term: 1 Year");

        Assert.assertTrue(checkVMClass&checkInstanceType&checkRegion&checkLocalSSD&checkCommitmentTerm
                ,"Estimate form values differ from expected!");
    }

}
