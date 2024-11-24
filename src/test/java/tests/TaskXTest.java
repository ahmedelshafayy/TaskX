package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class TaskXTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Set ChromeOptions to disable save email/password prompt
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble"); // Disables the "Save password" bubble
        options.addArguments("--disable-prompt-on-repost"); // Prevents "Repost form" dialog
        options.addArguments("profile.password_manager_enabled=false"); // Disable password manager

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testSignUpAndShoppingFlow() {
        driver.get("https://www.konakart.com/konakart/CustomerRegistration.action?forceReg=true");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        String username = "testuser" + System.currentTimeMillis() + "@testmail.com";
        registrationPage.register(username, "Password123!", "Test", "User", "123 Test St", "Test City", "12345", username, "19/11/2014","Alabama", "100010101");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToActionCategory();

        ActionMoviesPage actionMoviesPage = new ActionMoviesPage(driver);
        actionMoviesPage.sortByPriceLowToHigh();
        String lastMovieTitle = actionMoviesPage.getLastMovieTitle();
        Double lastMoviePrice = actionMoviesPage.getLastMoviePrice();
        actionMoviesPage.addLastMovieToCart();
        Assert.assertEquals(actionMoviesPage.getCartItemCount(), 1, "Cart count mismatch!");

        String firstMovieTitle = actionMoviesPage.getFirstMovieTitle();
        Double firstMoviePrice = actionMoviesPage.getFirstMoviePrice();
        actionMoviesPage.openFirstMovie();

        MovieDetailsPage movieDetailsPage = new MovieDetailsPage(driver);
        Assert.assertEquals(movieDetailsPage.getMovieTitle(), firstMovieTitle, "Movie title mismatch!");
        Assert.assertEquals(movieDetailsPage.getScreenshotCount(), 4, "Screenshot count mismatch!");

        movieDetailsPage.setQuantity(2);
        movieDetailsPage.addToCart();

        Assert.assertEquals(actionMoviesPage.getCartItemCount(), 2, "Cart count mismatch after adding quantities!");

        actionMoviesPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.verifyItemsInCart(firstMovieTitle, lastMovieTitle), "Not all expected items were found in the cart!");

        double subtotal = cartPage.getSubtotal();
        Assert.assertEquals(subtotal, cartPage.calculateExpectedSubtotal(), "Subtotal mismatch!");

        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setPaymentMethod("cod");
        checkoutPage.confirmOrder();

        CheckoutConfirmationSubmitPage checkoutConfirmationSubmitPage = new CheckoutConfirmationSubmitPage(driver);
        Assert.assertTrue(checkoutConfirmationSubmitPage.isOrderProceeded(), "Order is not processed!");
        checkoutConfirmationSubmitPage.continueOrder();

        MyAccountPage myAccountPage = new MyAccountPage(driver);

        Assert.assertTrue(myAccountPage.isOrderStatusPending(), "Order status is not pending!");
        Assert.assertTrue(myAccountPage.verifyOrderDetails(firstMovieTitle, lastMovieTitle,firstMoviePrice, lastMoviePrice), "Order details mismatch!");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
