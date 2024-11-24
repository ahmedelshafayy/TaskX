package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountPage {
    WebDriver driver;

    By orderStatus = By.cssSelector(".pending");
    By orderDetails = By.cssSelector(".last-order table table tbody tr");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderStatusPending() {
        return driver.findElement(orderStatus).getText().contains("Pending");
    }

    public boolean verifyOrderDetails(String firstMovieTitle, String lastMovieTitle, Double firstMoviePrice, Double lastMoviePrice) {
            List<WebElement> itemsCart = driver.findElements(orderDetails);

            int countExistProducts = 0;

            for (WebElement item : itemsCart) {

                WebElement movieTitleElement = item.findElement(By.className("text-link"));
                String movieTitle = movieTitleElement.getText().trim();

                WebElement movieQuantityElement = item.findElement(By.cssSelector("td.right:nth-of-type(2)"));
                double itemQuantity = Double.parseDouble(movieQuantityElement.getText().trim());
                WebElement moviePriceElement = item.findElement(By.cssSelector(".right:last-child"));
                double itemPrice = Double.parseDouble(moviePriceElement.getText().replace("$", "").trim());

                if (movieTitle.equals(firstMovieTitle) || movieTitle.equals(lastMovieTitle)) {
                    countExistProducts++;
                }
                if (itemPrice == (itemQuantity*firstMoviePrice) || itemPrice == (itemQuantity*lastMoviePrice)) {
                    countExistProducts++;
                }
            }
            return countExistProducts == 4;
    }
}
