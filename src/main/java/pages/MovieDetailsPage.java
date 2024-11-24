package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovieDetailsPage {
    WebDriver driver;

    By movieTitle = By.cssSelector("#page-title");
    By screenshots = By.cssSelector("#gallery_nav a");
    By quantityField = By.xpath("//form[@id='AddToCartForm']//select[@id='prodQuantityId']");
    By addToCartButton = By.xpath("//a[@onclick=\"addtoCartOrWishListFunc('AddToCartForm')\"][normalize-space()='Add to Cart']");

    public MovieDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMovieTitle() {
        return driver.findElement(movieTitle).getText();
    }

    public int getScreenshotCount() {
        return driver.findElements(screenshots).size();
    }

    public void setQuantity(int quantity) {
        driver.findElement(quantityField).sendKeys(String.valueOf(quantity));
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }
}
