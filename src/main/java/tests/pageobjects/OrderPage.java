package tests.pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {

    @FindBy(css = ".totalRow button")
    WebElement checkoutButton;

    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> productNames;

    public Boolean verifyOrderDisplay(String productName)
    {
        Boolean match = productNames.stream().anyMatch(p->p.getText().equalsIgnoreCase(productName));
        return match;
    }
}
