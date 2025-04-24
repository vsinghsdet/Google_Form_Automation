package google_form_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Submitted {
    
    WebDriver driver;

    @FindBy(className = "vHW8K")
    WebElement thankYou;

    public Submitted(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void validateThankYouMsg(){
        String thankYouMsg = thankYou.getText();
        if(thankYouMsg.contains("Thank You")){
            System.out.println("Successfully Submitted Google Form: PASS");
        }
        else{
            System.out.println("Successfully Submitted Google Form: FAIL");
        }
    }

}
