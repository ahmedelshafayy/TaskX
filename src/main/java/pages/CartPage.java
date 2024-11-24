package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CartPage {
    WebDriver driver;

    By cartItems = By.cssSelector(".text-link");
    By subtotal = By.cssSelector("#cost-overview tr:first-child .cost-overview-amounts");
    By proceedCheckoutButton = By.cssSelector("#continue-button");
    By itemPrices = By.cssSelector(".total-price"); // Update with the actual selector for item prices

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean verifyItemsInCart(String firstMovieTitle, String lastMovieTitle) {
        List<WebElement> itemsCart = driver.findElements(cartItems);

        int countExistProducts = 0;

        for (WebElement item : itemsCart) {
            String itemText = item.getText().trim();
            if (itemText.equals(firstMovieTitle) || itemText.equals(lastMovieTitle)) {
                countExistProducts++;
            }
        }
        return countExistProducts == 2;
    }

    public double getSubtotal() {
        return Double.parseDouble(driver.findElement(subtotal).getText().replace("$", ""));
    }

    public void proceedToCheckout() {
        driver.findElement(proceedCheckoutButton).click();
    }

    public double calculateExpectedSubtotal() {
        List<WebElement> prices = driver.findElements(itemPrices);

        double total = 0.0;

        for (int i = 0; i < prices.size(); i++) {
            double price = Double.parseDouble(prices.get(i).getText().replace("$", ""));
            total += price;
        }

        return Math.round(total * 100.0) / 100.0;
    }
}
