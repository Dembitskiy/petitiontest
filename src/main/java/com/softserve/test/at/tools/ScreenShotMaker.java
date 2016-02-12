package com.softserve.test.at.tools;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.Date;

/**
 * Created by rdem on 12.02.2016.
 */public class ScreenShotMaker extends TestListenerAdapter {

    private ITestContext context;
    private WebDriver webDriver;
    private static final String DATE_FORMAT = "MMM-dd-yyy hh:mm:ss";

    @Override
    public void onStart(ITestContext context) {
        this.context = context;
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        String currentTestName = "test1";
        webDriver = BrowserUtils.get().getBrowser().getWebDriver();
        Preconditions.checkNotNull(webDriver, "WebDriver instance is null!");
        String resultDateTime = "12-12-1993 09:25:23";
        String screenShotName = "Time: " + resultDateTime + " Test: "
                + currentTestName;
        makeScreenshot(screenShotName);
    }

    @Attachment(value = "{0}", type = "image/png")
    private byte[] makeScreenshot(String name) {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }

}
