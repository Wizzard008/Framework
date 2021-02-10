package com.epam.automation.PageObject;

import com.epam.automation.Util.ClipboardReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinutesEmailDotComPageObject extends AbstractPage{

    private static final String HOMEPAGE_URL="https://10minutemail.com/";
    private final int MAILBOX_LIFE_CYCLE=10*60;

    public TenMinutesEmailDotComPageObject openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }
    public String getEmailAddress(){
        ClipboardReader.cleanClipboard();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(CustomConditionsScriptsExecutionCompleted.jQueryAJAXsCompleted());

        do {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//div[@id='copy_address']"))).click();
        }while (!ClipboardReader.getLineFromClipboard().contains("@"));

        return ClipboardReader.getLineFromClipboard();
    }

    public TenMinutesEmailDotComPageObject waitAndOpenInboxMail(){
        new WebDriverWait(driver,MAILBOX_LIFE_CYCLE).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='Google Cloud Platform Price Estimate']"))).click();
        return this;
    }

    public Double getTotalEstimatedCost() {
        String textFieldValue=new WebDriverWait(driver, MAILBOX_LIFE_CYCLE).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[contains(text(),'Estimated Monthly Cost:')]"))).getText();

        return Double.parseDouble(textFieldValue.substring(textFieldValue.indexOf(":")+5)
                .replaceAll(",",""));
    }



//        public static void main(String[] args) {
//        WebDriver driver=new ChromeDriver();
//            System.out.println(
//                    new TenMinutesEmailDotComPageObject(driver)
//                            .openPage()
//                            .getEmailAddress());
//
//    }

}
