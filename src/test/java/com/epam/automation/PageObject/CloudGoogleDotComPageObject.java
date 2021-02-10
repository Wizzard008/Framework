package com.epam.automation.PageObject;

import com.epam.automation.model.GoogleCloud;
import com.epam.automation.model.User;
import com.epam.automation.service.CloudCreator;
import com.epam.automation.service.UserCreator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CloudGoogleDotComPageObject extends AbstractPage{

    private static final String HOMEPAGE_URL="https://cloud.google.com/";
    private TenMinutesEmailDotComPageObject mailBoxWebPage;
    private User currentUser;
    private GoogleCloud googleCloud;

    @FindBy(xpath = "//form[@class='devsite-search-form']")
    WebElement searchButton;

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchInputField;

    @FindBy(xpath = "//iframe[@src='/products/calculator/" +
            "index_ad8ca20a6d1799e286a0c0839aeb86ca523afe927b04501d8ba77dc59e5b8523.frame']")
    WebElement iFrame;

    public CloudGoogleDotComPageObject(){
        PageFactory.initElements(driver,this);
        currentUser= UserCreator.generateUserWithProperties();
        googleCloud= CloudCreator.generateCloudWithProperties();
    }
    public CloudGoogleDotComPageObject submitSearchRequest(){
        searchButton.click();
        searchInputField.sendKeys("Google Cloud Platform Pricing Calculator");
        searchInputField.sendKeys(Keys.ENTER);
        return this;
    }

    public CloudGoogleDotComPageObject openRequestedSearchResult(){
        List<WebElement> titleInputs=new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//div[@class='gsc-thumbnail-inside']/div/a")));
        for (WebElement searchResult:titleInputs) {
            if(searchResult.getText().contains("Google Cloud Platform Pricing Calculator"))searchResult.click();break;
        }
        return this;
    }
    public CloudGoogleDotComPageObject openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }
    public void selectCalculatorFrame(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(iFrame));
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt("myFrame"));
    }

    public CloudGoogleDotComPageObject fillEstimateFormFields(){
        selectCalculatorFrame();
        //Number of instances: 4
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@id='input_63' and @name='quantity']")))
                .sendKeys(googleCloud.getNumberOfInstancesLocator());
        logger.info("Number of instances set to: "+googleCloud.getNumberOfInstances());

        //What are these instances for?: оставить пустым
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("input_64"))).clear();

        //Operating System Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_76"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_option_65"))).click();

        //VM Class: Regular
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_80"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(googleCloud.getVmClassLocator())).click();
        logger.info("Number of instances set to: "+googleCloud.getNumberOfInstances());

        //Instance type: n1
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_88"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_option_188"))).click();

        //Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_90"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(googleCloud.getInstanceTypeLocator())).click();
        logger.info("Instance type set to: "+googleCloud.getInstanceType());

        //Выбрать Add GPUs
        WebElement addGPUCheckBox=new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//md-checkbox[@aria-label='Add GPUs']")));
        if(addGPUCheckBox.getAttribute("aria-checked").equalsIgnoreCase("false"))addGPUCheckBox.click();

        //Number of GPUs: 1
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_394"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//md-option[@ng-repeat='item in listingCtrl" +
                        ".supportedGpuNumbers[listingCtrl.computeServer.gpuType]' " +
                        "and @value='1']"))).click();

        //GPU type: NVIDIA Tesla V100
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_396"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//md-option[@value='NVIDIA_TESLA_V100']"))).click();

        //Local SSD: 2x375 Gb
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//md-select[contains(@aria-label,'Local SSD')]"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(googleCloud.getLocalSSDLocator())).click();
        logger.info("Amount of local SSD set to: "+googleCloud.getLocalSSD());

        //Datacenter location: Frankfurt (europe-west3)
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//md-select[contains(@aria-label,'Datacenter')]"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(googleCloud.getDataCenterLocationLocator())).click();
        logger.info("Datacenter location set to: "+googleCloud.getDataCenterLocation());

        //Committed usage: 1 Year
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//md-select[contains(@aria-label,'Committed usage')]"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(googleCloud.getCommittedUsageLocator())).click();
        logger.info("Committed usage set to: "+googleCloud.getCommittedUsage());

        return this;
    }

    public CloudGoogleDotComPageObject submitAddToEstimate(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(@aria-label,'Add to Estimate')]"))).click();
        return this;
    }

    public int getInstances(){
        String textFieldValue =new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[contains(@class  ,'ng-scope')]")))
                .getText();
        textFieldValue=textFieldValue.substring(0,textFieldValue.indexOf(" "));
    return Integer.parseInt(textFieldValue);
    }

    public List<String> getEstimateFormValues(){
        List<WebElement> elementsOfEstimatedForm = new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class  ,'md-list-item-text ng-binding')]")));
        List<String> valuesOfEstimatedForm = new ArrayList<>();
        for (WebElement element:elementsOfEstimatedForm) {
            valuesOfEstimatedForm.add(element.getText());
        }
        return valuesOfEstimatedForm;
    }

    public Double getTotalEstimatedCost(){
        String textFieldValue =new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id='resultBlock']/md-card/md-card-content//h2/b[@class='ng-binding']")))
                .getText();
        return Double.parseDouble(textFieldValue.substring(textFieldValue.indexOf(":")+5,textFieldValue.indexOf("p")-1)
                .replaceAll(",",""));
    }

    public CloudGoogleDotComPageObject clickEmailEstimate(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(@aria-label,'Email Estimate')]"))).click();
        return this;
    }

    public CloudGoogleDotComPageObject fillEmailEstimateForm(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[contains(@ng-model,'user.firstname')]")))
                .sendKeys(currentUser.getName());
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[contains(@ng-model,'user.lastname')]")))
                .sendKeys(currentUser.getSurname());
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[contains(@ng-model,'user.email')]")))
                .sendKeys(currentUser.getEmailAddress());
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[contains(@ng-model,'projectName')]")))
                .sendKeys(currentUser.getCompany());
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[contains(@ng-model,'user.title')]")))
                .sendKeys(currentUser.getTitle());
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[contains(@ng-model,'user.company')]")))
                .sendKeys(currentUser.getCompany());
        return this;
    }
    public CloudGoogleDotComPageObject clickSendEmail(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(@aria-label,'Send Email')]"))).click();
        return this;
    }
    public CloudGoogleDotComPageObject generateTemporaryEmail(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        mailBoxWebPage=new TenMinutesEmailDotComPageObject();
        currentUser.setEmailAddress(mailBoxWebPage.openPage().getEmailAddress());
        driver.switchTo().window(tabs.get(0));
        selectCalculatorFrame();
        return this;
    }

    public Double getTotalEstimatedCostFromEmail(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return mailBoxWebPage.waitAndOpenInboxMail().getTotalEstimatedCost();
    }
    public Boolean checkVMClass(){
        logger.info("VM class returned: "+getEstimateFormValues().get(1));
        return getEstimateFormValues().get(1).equalsIgnoreCase(googleCloud.getVmClass());
    }
    public Boolean checkInstanceType(){
        logger.info("Instance type returned: "+getEstimateFormValues().get(2));
        return getEstimateFormValues().get(2).equalsIgnoreCase(googleCloud.getInstanceType());
    }
    public Boolean checkRegion(){
        logger.info("Datacenter location returned: "+getEstimateFormValues().get(3));
        return getEstimateFormValues().get(3).equalsIgnoreCase(googleCloud.getDataCenterLocation());
    }
    public Boolean checkLocalSSD(){
        logger.info("Amount of local SSD returned: "+getEstimateFormValues().get(4));
        return getEstimateFormValues().get(4).equalsIgnoreCase(googleCloud.getLocalSSD());
    }
    public Boolean checkCommitmentTerm(){
        logger.info("Committed usage returned: "+getEstimateFormValues().get(5));
        return getEstimateFormValues().get(5).equalsIgnoreCase(googleCloud.getCommittedUsage());
    }
    public Boolean checkEstimateFormFields(){
        return checkVMClass()&checkInstanceType()&checkRegion()&checkLocalSSD()&checkCommitmentTerm();
    }
}
