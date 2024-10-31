package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomepageTest extends TestBase {

    private WebDriver driver;
    private HomePage homePage;
    @BeforeMethod
    public void setUpPage() {
        homePage = new HomePage(driver);
    }
    @Test
    public void testSuccessfulLogin() {
        // Initialize page objects


        // Perform login action
        homePage.enterUsername("testuser");
        homePage.enterPassword("password123");
        homePage.clickLogin();

        // Verify the user is redirected to the dashboard

    }

    @Test
    public void testSuccessfulLogin2() {
        // Initialize page objects


        // Perform login action
        homePage.enterUsername("testuser");
        homePage.enterPassword("password123");
        homePage.clickLogin();

        // Verify the user is redirected to the dashboard

    }
}
