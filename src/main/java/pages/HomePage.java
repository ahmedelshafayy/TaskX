package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    By productsCategory = By.linkText("Products");
    By dvdMoviesCategory = By.linkText("DVD Movies");
    By actionCategoryButton = By.linkText("Action");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToActionCategory() {
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//html")).click();
        WebElement productsMenu = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(productsCategory));
        actions.moveToElement(productsMenu).perform();
        actions.moveToElement(productsMenu).click().perform();
//        productsMenu.click();

        WebElement dvdMoviesMenu = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(dvdMoviesCategory));
        actions.moveToElement(dvdMoviesMenu).click().perform();

        WebElement actionCategory = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(actionCategoryButton));
        actions.moveToElement(actionCategory).click().perform();
    }

}
