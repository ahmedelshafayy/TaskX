package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    By paymentMethodField = By.id("paymentDetails");
    By confirmOrderButton = By.id("continue-button");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setPaymentMethod(String paymentType) {
        driver.findElement(paymentMethodField).sendKeys(paymentType);
    }
    public void confirmOrder() {
        driver.findElement(confirmOrderButton).click();
    }
}
