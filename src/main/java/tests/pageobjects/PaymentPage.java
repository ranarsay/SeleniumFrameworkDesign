package tests.pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PaymentPage extends AbstractComponent {

    @FindBy (css = "input[placeholder='Select Country']")
    WebElement country;
    By resultList = By.cssSelector(".ta-results");
    @FindBy (css = ".ta-item")
    WebElement result;
    @FindBy (css = ".action__submit")
    WebElement submit;


    public void selectCountry()
    {
        sendKeys(country, "turkey");
        waitForElementToAppear(resultList);
        result.click();
        submit.click();
    }

}
