package SharonProject.testNG;

import org.testng.*;
import test.java.utilities.Log;

/**
 * Created by SMaymonX054905 on 07/08/2017.
 */
public class TestNGListeners {

    public TestNGListeners() {
    }

    public void onStart(ISuite arg0) {
        Log.info("TestNGListener: Test Suite start: " + arg0.getName());
    }

    public void onFinish(ISuite arg0) {
        Log.info("TestNGListener: Test Suite end: " + arg0.getName());
    }

    public void onStart(ITestContext arg0) {
        Log.info("TestNGListener: Test start: " + arg0.getName());
    }

    public void onFinish(ITestContext arg0) {
        Log.info("TestNGListener: Test end: " + arg0.getName());
    }

    public void onTestSuccess(ITestResult arg0) {
        Log.info("TestNGListener: Test Case passed: " + arg0.getName());
        this.printTestResults(arg0);
    }

    public void onTestFailure(ITestResult arg0) {
        Log.info("TestNGListener: Test Case failed: " + arg0.getName());
        this.printTestResults(arg0);
    }

    public void onTestStart(ITestResult arg0) {
        Log.info("TestNGListener: Test Case start: " + arg0.getName());
        this.printTestResults(arg0);
    }

    public void onTestSkipped(ITestResult arg0) {
        Log.info("TestNGListener: Test Case skipped: " + arg0);
        this.printTestResults(arg0);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    private void printTestResults(ITestResult result) {
        String status;
        if(result.getParameters().length != 0) {
            status = null;
            Object[] var3 = result.getParameters();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Object parameter = var3[var5];
                status = status + parameter.toString() + ",";
            }

            Log.info("TestNGListener: Test Case: " + status);
        }

        status = null;
        switch(result.getStatus()) {
            case 1:
                status = "Pass";
                break;
            case 2:
                status = "Failed";
                break;
            case 3:
                status = "Skipped";
        }

        Log.info("TestNGListener: Test Case status: " + status);
    }

    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
        String textMsg = "About to begin executing following method : " + this.returnMethodName(arg0.getTestMethod());
        Log.info("TestNGListener: " + textMsg);
    }

    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
        String textMsg = "Completed executing following method : " + this.returnMethodName(arg0.getTestMethod());
        Log.info("TestNGListener: " + textMsg);
    }

    private String returnMethodName(ITestNGMethod method) {
        return method.getRealClass().getSimpleName() + "." + method.getMethodName();
    }
}
