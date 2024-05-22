package com.BNDF.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {


    //Create a Private constructor to remove access to this object
    private Driver(){

    }

    /*
    We make te Webdriver private, because we want to close access from outside the class.
    We are making it static, because we will use it in a static method.
     */
    //private static WebDriver driver; // Default value = null

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create re-usable utility method which will return same driver instance once we call it.
    - If an instance does not exist, it will create first, and then it will always return same instance.
     */

    public static WebDriver getDriver(){
        if(driverPool.get() == null){

            /*
            We will read our browserType from configuration.properties file.
            This way, we can control which browser is opened from outside our code.
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on broserType returned from the configuration.properties
            switch statement will determine the "case" , and open the matching browser.
             */
            switch (browserType){
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }

        }
        return driverPool.get();
    }

    /*
    Create a new Driver.closeDriver(); it will use .quit method to quit browsers, and then set the driver value back to null.
     */
    public static void closeDriver(){
        if(driverPool.get() != null){
            /*
            This line will terminate the curently existing driver completely.It will not exist going forward.
             */
            driverPool.get().quit();
            /*
            We asign the value back to "null" so that my "singleton" can create newer one if needed.
             */
            driverPool.remove();
        }
    }

}
