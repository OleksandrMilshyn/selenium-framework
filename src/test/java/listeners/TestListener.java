package listeners;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info(
                "TEST STARTED: {}",
                result.getMethod().getMethodName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(
                "TEST PASSED: {}",
                result.getMethod().getMethodName()
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        logger.error(
                "TEST FAILED: {}",
                testName,
                result.getThrowable()
        );

        Object testInstance = result.getInstance();

        if (!(testInstance instanceof BaseTest baseTest)) {
            logger.error(
                    "Screenshot was not created because the test does not extend BaseTest"
            );
            return;
        }

        if (baseTest.getDriver() == null) {
            logger.error(
                    "Screenshot was not created because WebDriver is null"
            );
            return;
        }

        try {
            String screenshotPath = ScreenshotUtils.takeScreenshot(
                    baseTest.getDriver(),
                    testName
            );

            logger.error(
                    "Screenshot saved: {}",
                    screenshotPath
            );
        } catch (RuntimeException e) {
            logger.error(
                    "Failed to create screenshot for test: {}",
                    testName,
                    e
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn(
                "TEST SKIPPED: {}",
                result.getMethod().getMethodName()
        );
    }
}
