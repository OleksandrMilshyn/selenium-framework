package listeners;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

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

        attachScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        logger.error(
                "TEST FAILED: {}",
                testName,
                result.getThrowable()
        );

        attachScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn(
                "TEST SKIPPED: {}",
                result.getMethod().getMethodName()
        );
    }

    private void attachScreenshot(ITestResult result) {
        Object testInstance = result.getInstance();

        if (!(testInstance instanceof BaseTest baseTest)) {
            logger.info(
                    "Screenshot was not attached because the test does not extend BaseTest"
            );
            return;
        }

        if (baseTest.getDriver() == null) {
            logger.error(
                    "Screenshot was not attached because WebDriver is null"
            );
            return;
        }

        try {
            byte[] screenshot = ((TakesScreenshot) baseTest.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    "Screenshot",
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    ".png"
            );

            logger.info(
                    "Screenshot attached to Allure report: {}",
                    result.getMethod().getMethodName()
            );

        } catch (RuntimeException e) {
            logger.error(
                    "Failed to attach screenshot for test: {}",
                    result.getMethod().getMethodName(),
                    e
            );
        }
    }
}