package com.BNDF.Utility;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {



    /*
    This method will accept int (in sec) and execute Thread.sleep method for given duration
     */
    public static void sleep(int second){
        try {
            Thread.sleep(second * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public static void switchWindowAndVerify( String expectedInURL, String expectedInTitle){
        //Return and store all window handles in a Set.
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if(Driver.getDriver().getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }

        //5. Assert: Title contains “Etsy”
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }

    public static void verifyTitleContains(String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    /*
    This method accepts Webelement tatget,and waits for Webelement to not be displayed on page.
     */
    public static void waitForInvisibilityOfGivenElement(WebElement target){

        //Create the object of WebDriverWait class and setup constructor arguments
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /*
    This method accepts String title, and waits for that title to contain given String value.
     */
    public static void waitForTitleContains(String title){

        //Create the object of WebDriverWait class and setup constructor arguments
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));
    }

    /**
     * This method accepts a dropdown element and returns a List<String> that contains all option values as String.
     * @param dropdownElement
     * @return actualMonth_as_STRING
     */
    public static List<String> dropdownOptions_as_STRING(WebElement dropdownElement){


        Select month = new Select(dropdownElement);

        //Storing all of the Actual options in a List of Webelemnts
        List<WebElement> actualMonth_as_WEBELEMENT = month.getOptions();

        //Creating an empty list of String to store ACTUAL <option> as String
        List<String> actualMonth_as_STRING = new ArrayList<>();

        //Looping through the List<Webelement> getting all options texts, and storing them in the List<String>
        for (WebElement each : actualMonth_as_WEBELEMENT) {
            actualMonth_as_STRING.add(each.getText());
        }

        return actualMonth_as_STRING;
    }

    public static void verifyInURL(String expectedInURL) {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    public static void clickRadioButtons(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons) {
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }


}
