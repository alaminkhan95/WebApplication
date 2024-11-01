package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Utils {

    public static void waitUntilVisible(WebDriver driver, WebElement locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(locator));
        } catch (TimeoutException e) {
            System.err.println("Timeout waiting for visibility of element: " + locator + " - " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + locator + " - " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred while waiting for element visibility: " + e.getMessage());
        }
    }

    public static void hoverOverElement(WebDriver driver, WebElement webElement) {
        waitUntilVisible(driver, webElement, 30);

        if (webElement.isDisplayed()) {
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement).perform();
        } else {
            throw new NoSuchElementException("Facebook icon is not displayed");
        }

    }
}
