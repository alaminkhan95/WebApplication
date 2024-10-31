package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    // Locators using @FindBy annotation
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "error-message") // Assuming this is the locator for the error message
    private WebElement errorMessageElement;

    @FindBy(xpath = "//img[@alt='company-branding']") // Assuming this is the locator for the error message
    private WebElement logoMiddlePage;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements
    }

    // Method to enter username
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    // Method to click the login button
    public void clickLogin() {
        loginButton.click();
    }

    // Method to get the error message text
    public String getErrorMessage() {
        return errorMessageElement.getText();
    }
}
