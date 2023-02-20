package tests;

import AbstractComponents.AbstractComponent;

public class StandAloneTest extends AbstractComponent {

    public static void main(String[] args) throws InterruptedException{

     /*   startDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LandingPage landingPage = new LandingPage(driver);
        //login
        landingPage.goTo();
        landingPage.loginApplication("hilal@test.com", "Test123.");
        ProductCatalog productCatalog = new ProductCatalogue();
        List<WebElement> products = productCatalog.getProductList();


        //wait until all products are listed &
        //get all product list
        String productName = "ZARA COAT 3";


        WebElement prod = products.stream().filter(p -> p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        //add prod to the cart
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();


        //wait until loading icon and the success message disappears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        //go to cart
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match = cartProducts.stream().anyMatch(p->p.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);
        driver.findElement(By.cssSelector(".totalRow button")).click();

        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"turkey").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.cssSelector(".ta-item")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();

        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANK YOU FOR THE ORDER"));*/




    }
}
