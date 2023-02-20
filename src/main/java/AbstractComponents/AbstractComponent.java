package AbstractComponents;

import tests.pageobjects.CartPage;
import tests.pageobjects.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class AbstractComponent extends Driver {
    public AbstractComponent(){
        //initialize the driver
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "[routerlink*='cart']")
    WebElement cartPage;

    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderPage;

    public CartPage goToCartPage()
    {
        cartPage.click();
        CartPage cartPage = new CartPage();
        return cartPage;
    }
    public OrderPage goToOrderPage() throws InterruptedException {
        Thread.sleep(1000);
        orderPage.click();
        OrderPage orderPage = new OrderPage();
        return orderPage;
    }

    public void waitForElementToAppear(By findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementToAppear(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToDisappear(WebElement element) throws InterruptedException {
        Thread.sleep(1000);
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));*/

    }
    public void sendKeys(WebElement element, String input)
    {
        Actions action = new Actions(driver);
        action.sendKeys(element, input).build().perform();
    }


}

