package tests;

import AbstractComponents.AbstractComponent;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.pageobjects.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tests.pageobjects.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends AbstractComponent {

    @Test (dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String,String> input) throws InterruptedException {
        startDriver("Chrome");
        LandingPage landingPage = new LandingPage();
        //login
        landingPage.goTo();
        landingPage.loginApplication((input.get("email")),input.get("password"));

        ProductCatalogue productCatalogue = new ProductCatalogue();
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(input.get("product") );

        CartPage cart = new CartPage();
        cart.goToCartPage();
        Boolean match = cart.verifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);

        cart.checkOut();
        PaymentPage payment = new PaymentPage();
        payment.selectCountry();

        ConfirmationPage confirmationPage = new ConfirmationPage();
        String confirmMessage = confirmationPage.getConfirmationText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    //to verify zara coat 3 is displaying in orders page
    @Test(dependsOnMethods = {"submitOrder"})
    public void OrderHistoryTest() throws InterruptedException {
        startDriver("Chrome");
        String productName = "ZARA COAT 3";
        LandingPage landingPage = new LandingPage();
        //login
        landingPage.goTo();
        landingPage.loginApplication("hilal@test.com", "Test123.");

        ProductCatalogue productCatalogue = new ProductCatalogue();
        OrderPage ordersPage = productCatalogue.goToOrderPage();
        Thread.sleep(1000);
        Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));

    }

    //Extent Reports + you can add screenshots here as well

    @DataProvider
    public Object[][] getData() throws IOException {
        /*HashMap<String,String> map = new HashMap<String, String>();
        map.put("email", "hilal@test.com");
        map.put("password", "Test123.");
        map.put("product", "ZARA COAT 3");

        HashMap<String,String> map1 = new HashMap<String, String>();
        map1.put("email", "hilal@gmail.com");
        map1.put("password", "Test123.");
        map1.put("product", "ADIDAS ORIGINAL");*/
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/data/PurchaseOrder.json");
        return new Object[][] {{data.get(0)},{data.get(1)}};
    }
}
