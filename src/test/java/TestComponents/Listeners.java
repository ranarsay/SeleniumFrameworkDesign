package TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterNG;
import utils.Driver;

import java.io.IOException;

public class Listeners extends Driver implements ITestListener {
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());
        String filePath = null;
        //add screenshot to report
        try {
            filePath = getScreenShot(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        //
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
