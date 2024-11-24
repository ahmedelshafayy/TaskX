package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckoutConfirmationSubmitPage {
    WebDriver driver;

    By orderStatusTitle = By.id("page-title");
    By confirmOrderButton = By.id("continue-button");

    public CheckoutConfirmationSubmitPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderProceeded() {
        return driver.findElement(orderStatusTitle).getText().contains("Your Order Has Been Processed");
    }

    public void continueOrder() {
        driver.findElement(confirmOrderButton).click();
    }
}
