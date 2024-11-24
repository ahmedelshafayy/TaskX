package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionMoviesPage {
    WebDriver driver;

    By sortDropdown = By.name("orderBy");
    By lastMovie = By.cssSelector(".items ul li:last-child");
    By lastMovieAddToCart = By.cssSelector(".items ul li:last-child .add-to-cart-button");
    By lastMovieLinkTitle = By.cssSelector(".items ul li:last-child .item-title");
    By lastMovieLinkPrice = By.cssSelector(".items ul li:last-child .price");
    By firstMovieLinkTitle = By.cssSelector(".items ul li:first-child .item-title");
    By firstMovieLinkPrice = By.cssSelector(".items ul li:first-child .price");
    By firstMovieLink = By.cssSelector(".items ul li:first-child");
    By cartItemCount = By.cssSelector(".shopping-cart-item:first-child .shopping-cart-item-price");
    By cartIcon = By.cssSelector("#shopping-cart"); // Update the selector based on the actual website

    public ActionMoviesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortByPriceLowToHigh() {
        driver.findElement(sortDropdown).sendKeys("Price: Low to High");
    }

    public void addLastMovieToCart() {
        Actions actions = new Actions(driver);
        WebElement productsMenu = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(lastMovie));
        actions.moveToElement(productsMenu).perform();
        driver.findElement(lastMovieAddToCart).click();
    }

    public Integer getCartItemCount() {

        WebElement cartItemCountItem = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(cartItemCount));
        String text = cartItemCountItem.getText();
        String[] parts = text.split(":");
        return Integer.parseInt(parts[parts.length - 1].trim());
    }

    public void openFirstMovie() {
        driver.findElement(firstMovieLink).click();
    }

    public String getLastMovieTitle() {
        return driver.findElement(lastMovieLinkTitle).getText();
    }
    public Double getLastMoviePrice() {
        return Double.parseDouble(driver.findElement(lastMovieLinkPrice).getText().replace("$", ""));
    }

    public String getFirstMovieTitle() {
        return driver.findElement(firstMovieLinkTitle).getText();
    }

    public Double getFirstMoviePrice() {
        return Double.parseDouble(driver.findElement(firstMovieLinkPrice).getText().replace("$", ""));
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}
