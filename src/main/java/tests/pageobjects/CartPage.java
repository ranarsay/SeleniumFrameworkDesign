package tests.pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractComponent {

    //Page Factory

    @FindBy (css = ".cartSection h3")
    List<WebElement> cartProducts;

    @FindBy (css = ".totalRow button")
    WebElement checkOutButton;

    public Boolean verifyProductDisplay(String productName) throws InterruptedException {
        Thread.sleep(1000);
        Boolean match = cartProducts.stream().anyMatch(p->p.getText().equalsIgnoreCase(productName));
        return match;
    }
    public void checkOut()
    {
        checkOutButton.click();
    }
}
