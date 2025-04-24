package google_form_automation.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import google_form_automation.BaseTest;
import google_form_automation.DriverSingleton;
import google_form_automation.pages.SubmitForm;
import google_form_automation.pages.Submitted;

public class testCase01 extends BaseTest{
    
    WebDriver driver;
    SubmitForm submitForm;
    Submitted submitted;
    SoftAssert softAssert;

    @BeforeClass
    public void config() throws MalformedURLException{
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://docs.google.com/forms/d/1XhHMxrsPIA45wl4fZIU5T7Y4NLj8jxuAogElO4aQQ4M/");
        submitForm = new SubmitForm(driver);
        submitted = new Submitted(driver);
    }

    @Test
    public void submitGoogleForm(){

        submitForm.fillName("Siddharth Singh");
        System.out.println("Name filled successfully");
        submitForm.fillPractice("Practicing to become best SDET");
        System.out.println("Entered text successfully");
        submitForm.provideExperience("3 - 5");
        System.out.println("Selected experience");
        submitForm.skillsToBeSelected("Java");
        submitForm.skillsToBeSelected("Selenium");
        submitForm.skillsToBeSelected("TestNG");
        System.out.println("Selected skills");
        submitForm.selectHonorificWord("Dr");
        System.out.println("Seletec Honorifc Address");
        submitForm.selectDate(7);
        System.out.println("Selected time");
        submitForm.provideTime("10", "30");
        System.out.println("Time Input success");
        submitForm.submitForm();
        System.out.println("Submitted Form successfully");
        submitted.validateThankYouMsg();

    }

    @AfterClass
    public void closeBrowser(){
       // driver.close();
        driver.quit();
    }

}
