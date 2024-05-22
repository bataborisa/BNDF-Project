package com.BNDF.StepDefs;

import com.BNDF.Pages.MainPage;
import com.BNDF.Utility.BrowserUtils;
import com.BNDF.Utility.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class LeaveAMessageStepDef {

    MainPage page = new MainPage();
    Faker faker = new Faker();



    @Given("user is on main page")
    public void user_is_on_main_page() {
        System.out.println("User is on main page!");
    }
    @When("user scroll down to the buttom of the page")
    public void user_scroll_down_to_the_buttom_of_the_page() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(page.sendMessageButton).perform();
        BrowserUtils.sleep(3);
    }
    @When("user fill out Leave A Message form, giving {string}, {string} and {string}")
    public void user_fill_out_leave_a_message_form_giving_and(String name, String email, String message) {
        name = faker.name().fullName();
        page.inputName.sendKeys(name);
        email = faker.internet().emailAddress();
        page.emailBox.sendKeys(email);
        message = faker.chuckNorris().fact();
        page.messageBox.sendKeys(message);
        System.out.println(message);


    }
    @When("user clicks on send message button")
    public void user_clicks_on_send_message_button() {
        page.sendMessageButton.click();
    }
    @Then("user see message {string}")
    public void user_see_message(String expectedMessage) {
        String actualMessage = page.successMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }


    @Then("user should see all available features in top menu")
    public void userShouldSeeAllAvailableFeaturesInTopMenu(List<String> expectedMenuFeatures) {
       List<String> actualMenuFeatures = new ArrayList<>();
        for (WebElement listOfFeature : page.listOfFeatures) {
            actualMenuFeatures.add(listOfFeature.getText());
        }
        System.out.println(actualMenuFeatures);
        Assert.assertEquals(expectedMenuFeatures,actualMenuFeatures);
    }

    @When("user hover over {string} tab")
    public void userHoverOverTab(String module) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(page.ourApproach).perform();
        BrowserUtils.sleep(3);
    }

    @Then("user can see the options")
    public void userCanSeeTheOptions(List<String> expectedOptions) {
        List<String> actualOptions = new ArrayList<>();
        for (WebElement options : page.optionsApproach) {
            actualOptions.add(options.getText());
        }
        System.out.println(actualOptions);

    }

    @And("user clicks on {string}")
    public void userClicksOn(String selectOption) {
        MainPage.selectOption(selectOption).click();
    }

    @Then("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
