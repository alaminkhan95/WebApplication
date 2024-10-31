package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import utils.PageLocatorActions;
import utils.Utils;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class HomepageTest extends TestBase {
    private HomePage homePage;
    private WebDriverWait wait;

    @BeforeClass
    @Override
    @Parameters("browser")
    public void setUp(String browser) {
        super.setUp(browser);
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testInvalidUsernamePassword() {
        // Perform login action
        homePage.enterUsername("testuser");
        homePage.enterPassword("password123");
        homePage.clickLogin();

        Assert.assertEquals(homePage.getErrorMessage(), "Invalid credentials");
    }

    @Test
    public void optestLogo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));
        boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Test
    public void optestAppUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}