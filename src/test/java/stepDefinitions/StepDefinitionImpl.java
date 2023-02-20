package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tests.pageobjects.*;
import utils.Driver;
import java.util.List;

public class StepDefinitionImpl extends Driver {
    LandingPage landingPage = new LandingPage();
    ProductCatalogue productCatalogue = new ProductCatalogue();
    CartPage cart = new CartPage();
    ConfirmationPage confirmationPage = new ConfirmationPage();

    @Given("I landed on E-commerce page")
    public void I_landed_on_Ecommerce_Page()
    {
        //code
        startDriver("Chrome");
        landingPage.goTo();
    }
    //if you put regex, you have to start with cap ^
    @Given("^Logged in with user name (.+) and password (.+)$")
    public void logged_in_username_and_password(String username, String password) {
        //get the data from .feature file
        landingPage.loginApplication(username, password);
        throw new PendingException();
    }
    // When I add product <productName> from Cart
    @When("^I add product (.+) from Cart$")
    public void i_add_product_to_cart(String productName) throws InterruptedException {
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        throw new PendingException();
    }

    //And Checkout <productName> and submit the order
    @And("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String productName) throws InterruptedException {

        cart.goToCartPage();
        Boolean match = cart.verifyProductDisplay(productName);
        Assert.assertTrue(match);

        cart.checkOut();
        PaymentPage payment = new PaymentPage();
        payment.selectCountry();
        throw new PendingException();
    }
    //Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation Page
    @Then("{string} message is displayed on Confirmation Page")
    public void verify_message_displayed(String string)
    {
        String confirmMessage = confirmationPage.getConfirmationText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
        throw new PendingException();
    }

    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
        Assert.assertEquals(strArg1, landingPage.getErrorMessage());
        throw new PendingException();
    }
}
