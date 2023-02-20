package tests.pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {


    //Page Factory
    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy (css = ".ng-animating")
    WebElement spinner;
    By productList = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");
    public List<WebElement> getProductList(){
        waitForElementToAppear(productList);
        return products;
    }
    public WebElement getProductByName(String productName)
    {
        WebElement prod = getProductList().stream().filter(p -> p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        //add prod to the cart
        return prod;
    }
    public void addProductToCart(String productName) throws InterruptedException {
        WebElement prod = getProductByName(productName);
        waitForElementToAppear(productList);
        prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(spinner);
    }


}
