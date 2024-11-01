package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.PimPage;

public class PimTest extends TestBase{

    private PimPage pimPage;
    @BeforeClass
    @Override
    @Parameters("browser")
    public void setUp(String browser) {
        super.setUp(browser);
        pimPage = new PimPage(driver); // Initialize the PimPage
    }
}
