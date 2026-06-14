package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import UtilitiesPkg.ExtentManager;

public class ExtentReportListner implements ITestListener {


    private static final ExtentReports extent = ExtentManager.createInstance();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);

        extent.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");

        extent.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        test.get().log(Status.FAIL,"Test failed");


        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().log(Status.SKIP, "Test Skipped");


        extent.flush();
    }

    @Override
    public void onFinish(ITestContext context) {
        test.get().log(Status.INFO,"Test Finished");


        extent.flush();
    }
}