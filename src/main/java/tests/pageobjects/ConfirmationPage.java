package tests.pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends AbstractComponent {

    @FindBy (css = ".hero-primary")
    WebElement heroText;

    public String getConfirmationText()
    {
        waitForWebElementToAppear(heroText);
        return heroText.getText();
    }
}
