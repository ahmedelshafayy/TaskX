package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;

    By genderField = By.xpath("//input[@value='m']");
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("passwordConfirmation");
    By firstNameField = By.id("firstName");
    By lastNameField = By.id("lastName");
    By addressField = By.id("streetAddress");
    By cityField = By.id("city");
    By postcodeField = By.id("postcode");
    By emailField = By.id("emailAddr");
    By BDField = By.id("datepicker");
    By stateField = By.id("state");
    By phoneField = By.id("telephoneNumber");
    By registerButton = By.id("continue-button");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void register(String username, String password, String firstName, String lastName, String address, String city, String postcode, String email, String BD, String state, String phone) {
        driver.findElement(genderField).click();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(postcodeField).sendKeys(postcode);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(BDField).sendKeys(BD);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(registerButton).click();
    }
}
