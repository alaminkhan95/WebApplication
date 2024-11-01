package tests;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import utils.ConfigReader;
import utils.Utils;

import static utils.ConstatsCollection.*;

public class HomepageTest extends TestBase {
    private HomePage homePage;
    private Utils utils;

    @BeforeClass
    @Override
    @Parameters("browser")
    public void setUp(String browser) {
        super.setUp(browser);
        homePage = new HomePage(driver);
    }

    @Test(priority = 0,dataProvider = "employeeData")
    public void testInvalidUsernamePassword(String testuser, String Password) {
        // Perform login action
        homePage.enterUsername(testuser);
        homePage.enterPassword(Password);
        homePage.clickLogin();
        Assert.assertEquals(homePage.getErrorMessage(), "Invalid credentials");
    }

    @Test(priority = 7)
    public void optestLogo() {
        Assert.assertTrue(homePage.logoDisplayed());
    }

    @Test(priority = 6)
    public void optestAppUrl() {
        String url = ConfigReader.getProperty("url");
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test(priority = 5)
    public void testLogoText() {
        Assert.assertEquals(homePage.getTextLogin(),"Login");
    }

    @Test(priority = 4)
    public void testFooterIcons(){
        Assert.assertEquals(homePage.getLinkOnHoverLinkedin(),HOMEPAGE_FOOTER_LINKEDIN_LINK);
    }

    @Test(priority = 3)
    public void testFooterIconFaceBook(){
        Assert.assertEquals(homePage.getLinkOnHoverFacebook(),HOMEPAGE_FOOTER_FACEBOOK_LINK);
    }

    @Test(priority = 2)
    public void testFooterIconTweeter(){
        Assert.assertEquals(homePage.getLinkOnHoverTwitter(),HOMEPAGE_FOOTER_TWEETER_LINK);
    }

    @Test(priority = 1)
    public void testFooterIconYoutube(){
        Assert.assertEquals(homePage.getLinkOnHoverYoutube(),HOMEPAGE_FOOTER_YOUTUBE_LINK);
    }

    @DataProvider(name = "employeeData")
    public Object[][] employeeDataProvider() {
        return new Object[][] {
                {"testuser", "password123"},
                {"testuser2", "password123"},

        };
    }




    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}