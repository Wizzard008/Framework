package com.epam.automation.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class  DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (driver==null){
            String browserProperty = System.getProperty("browser");
            if (browserProperty.equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
//            switch (System.getProperty("browser")){
//                case "edge": {
//                    logger.info("Setting up edge");
//                    WebDriverManager.edgedriver().setup();
//                    driver = new EdgeDriver();
//                }
//                case "chrome": {
//                    logger.info(System.getProperty("Setting up chrome"));
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                }
//                default: {
//                    logger.info("Not valid property browser");
//                }
//            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
