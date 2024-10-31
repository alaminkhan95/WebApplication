package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ExtentReportManager implements ITestListener, ISuiteListener {

    private ExtentSparkReporter sparkReporter; // UI of the report
    private ExtentReports extent; // populate common info on the report
    private ThreadLocal<ExtentTest> test = new ThreadLocal<>(); // ThreadLocal for ExtentTest

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Starting Suite: " + suite.getName());
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");

        sparkReporter.config().setDocumentTitle("Automation Report"); // Title of report
        sparkReporter.config().setReportName("Functional Testing"); // name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Alamin");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Browser Name", "Chrome");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName()); // create new entry in the report
        extentTest.log(Status.PASS, "Test case Passed is : " + result.getName());
        test.set(extentTest); // Store the current test in ThreadLocal
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName()); // create new entry in the report
        extentTest.log(Status.FAIL, "Test Failed ! : " + result.getName());
        extentTest.log(Status.FAIL, "Test case failed cause is : " + result.getThrowable());
        test.set(extentTest); // Store the current test in ThreadLocal
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName()); // create new entry in the report
        extentTest.log(Status.SKIP, "Test case skipped is : " + result.getName());
        test.set(extentTest); // Store the current test in ThreadLocal
    }

    @Override
    public void onFinish(ISuite suite) {
        extent.flush(); // Write the report to file
        test.remove(); // Clear ThreadLocal to prevent memory leaks
        System.out.println("Finished Suite: " + suite.getName());
    }

}
