package tests;

import tests.pageobjects.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.pageobjects.CartPage;
import tests.pageobjects.LandingPage;
import tests.pageobjects.ProductCatalogue;
import utils.Driver;

import java.util.List;


public class ErrorValidationsTest extends Driver {

    @Test (groups = {"ErrorHandling"})
    public void LoginErrorValidation()  {
        startDriver("Chrome");
        LandingPage landingPage = new LandingPage();
        //login
        landingPage.goTo();
        landingPage.loginApplication("hilal@test.com", "Test123");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
        endDriver();
    }

    String productName = "ZARA COAT 33";
    @Test
    public void ProductErrorValidation() throws InterruptedException {
        startDriver("Chrome");

        LandingPage landingPage = new LandingPage();
        //login
        landingPage.goTo();
        landingPage.loginApplication("hilal@test.com", "Test123.");

        ProductCatalogue productCatalogue = new ProductCatalogue();
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);

        CartPage cart = new CartPage();
        cart.goToCartPage();
        Boolean match = cart.verifyProductDisplay(productName);
        Assert.assertTrue(match);
    }

}
