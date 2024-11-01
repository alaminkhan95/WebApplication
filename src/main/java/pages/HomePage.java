package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.Utils.hoverOverElement;
import static utils.Utils.waitUntilVisible;

public class HomePage {
    private WebDriver driver;


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class, 'orangehrm-login-button') and text()=' Login ']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[contains(@class, 'oxd-alert-content-text')]")
    private WebElement errorMessageElement;

    @FindBy(xpath = "//img[@alt='company-branding']")
    private WebElement logo;

    @FindBy(xpath = "//h5[contains(@class, 'orangehrm-login-title') and text()='Login']")
    private WebElement txtLogin;

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']")
    private WebElement iconLinkedin;

    @FindBy(xpath = "//a[@href='https://www.facebook.com/OrangeHRM/']")
    private WebElement iconFacebook;

    @FindBy(xpath = "//a[@href='https://twitter.com/orangehrm?lang=en']")
    private WebElement iconTwitter;

    @FindBy(xpath = "//a[@href='https://www.youtube.com/c/OrangeHRMInc']")
    private WebElement iconYoutube;


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

    public boolean logoDisplayed() {

        waitUntilVisible(driver,logo,30);
        return logo.isDisplayed();
    }

    // Method to get the error message text
    public String getErrorMessage() {
        waitUntilVisible(driver,errorMessageElement,30);
        return errorMessageElement.getText();
    }

    public String getTextLogin(){

       return txtLogin.getText();
    }
    public String getLinkOnHoverLinkedin() {
        hoverOverElement(driver,iconLinkedin);
        return iconLinkedin.getAttribute("href");
    }

    public String getLinkOnHoverFacebook() {

        hoverOverElement(driver,iconFacebook);
        return iconFacebook.getAttribute("href");

    }

    public String getLinkOnHoverTwitter() {
        hoverOverElement(driver,iconTwitter);
        return iconTwitter.getAttribute("href");

    }

    public String getLinkOnHoverYoutube() {
        hoverOverElement(driver,iconYoutube);
        return iconYoutube.getAttribute("href");

    }


}