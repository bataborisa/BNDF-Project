package com.BNDF.Pages;

import com.BNDF.Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@data-original_id='name']")
    public WebElement inputName;

    @FindBy(xpath = "//input[@id='et_pb_contact_email_0']")
    public WebElement emailBox;

    @FindBy(xpath = "//textarea[@id='et_pb_contact_message_0']")
    public WebElement messageBox;

    @FindBy(xpath = "//button[@name='et_builder_submit_button']")
    public WebElement sendMessageButton;

    @FindBy (xpath = "//ul[@id='top-menu']/li")
    public List<WebElement> listOfFeatures;

    @FindBy (xpath = "//p[.='Thanks for contacting us']")
    public WebElement successMessage;

    @FindBy (xpath = "(//a[.='"+""+"'])[1]")
    public WebElement carFleetManagement;

    @FindBy (xpath = "//li[@id='menu-item-845']/a")
    public WebElement ourApproach;

    @FindBy (xpath = "//ul[@class='sub-menu']")
    public List<WebElement> optionsApproach;



    public static WebElement selectOption(String option){

        return Driver.getDriver().findElement(By.xpath("(//a[.='"+option+"'])[1]"));
    }




}
