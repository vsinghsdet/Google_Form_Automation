package google_form_automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import google_form_automation.Wrappers.Wrappers;

public class SubmitForm {

    WebDriver driver;

    @FindBy(xpath="//input[@type='text']")
    WebElement nameInput;

    @FindBy(tagName = "textarea")
    WebElement practicingInput;

    @FindBy(xpath = "//span[contains(@class,'OvPDhc ')]")
    List<WebElement> experience;

    @FindBy(xpath = "//span[contains(@class,'n5vBHf ')]")
    List<WebElement> checkBoxText;

    @FindBy(xpath = "//div[@role='listbox']//div[contains(@class,'KKjvXb ')]")
    WebElement addressList;

    @FindBy(xpath = "//div[@jsname='V68bde']//div[contains(@class,'OIC90c ')]/span")
    List<WebElement> personToBeAddressed;

    @FindBy(xpath = "//input[@type='date']")
    WebElement datePicker;

    @FindBy(xpath = "//input[@aria-label='Hour']")
    WebElement hours;

    @FindBy(xpath = "//input[@aria-label='Minute']")
    WebElement minutes;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitButton;

    public SubmitForm(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void fillName(String name){
        Wrappers.sendKeys(driver, nameInput, name);
    }

    public void fillPractice(String text){
        Wrappers.sendKeys(driver, practicingInput, text);
    }

    public void provideExperience(String givenExp){
        Wrappers.selectExperience(driver, experience, givenExp);
    }

    public void skillsToBeSelected(String skill){
        Wrappers.selectSkills(driver, checkBoxText, skill);
    }

    public void selectHonorificWord(String honorificAddress){
        Wrappers.click(addressList, driver);
        Wrappers.selectAddresse(driver, personToBeAddressed, honorificAddress);
    }

    public void selectDate(int daysAgo){
        String dateToSend = Wrappers.getDaysAgo(daysAgo);
        Wrappers.sendKeys(driver, datePicker, dateToSend);
    }

    public void provideTime(String hour, String minute){
        Wrappers.sendKeys(driver, hours, hour);
        Wrappers.sendKeys(driver, minutes, minute); 
    }

    public void submitForm(){
        Wrappers.click(submitButton, driver);
    }



    
}
