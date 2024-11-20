package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.AdminPage;
import utils.ConfigReader;

public class AdminTest extends TestBase{

    private AdminPage adminPage; // Assuming you have an AdminPage class

    @BeforeClass
    @Override
    @Parameters("browser")
    public void setUp(String browser) {
        super.setUp(browser);
        adminPage = new AdminPage(driver); // Initialize the AdminPage

        String url = ConfigReader.getProperty("url");
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
