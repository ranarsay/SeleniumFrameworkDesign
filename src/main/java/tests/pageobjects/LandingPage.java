package tests.pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends AbstractComponent {

    //WebElement userEmail = driver.findElement(By.id("userEmail"));
    //Page Factory
    @FindBy (css = "#userEmail")
    WebElement userEmail;

    @FindBy (id = "userPassword")
    WebElement userPassword;

    @FindBy (id = "login")
    WebElement submit;

    @FindBy (css = "#toast-container")
    WebElement errorMessage;

    public void loginApplication(String email, String password) {
        waitForWebElementToAppear(userEmail);
        waitForWebElementToAppear(userPassword);
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        submit.click();
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }

    public String getErrorMessage()
    {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }
}
