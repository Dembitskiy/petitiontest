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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by rdem on 12.02.2016.
 */public class ScreenShotMaker extends TestListenerAdapter {

    private ITestContext context;
    private static final String DATE_FORMAT = "MMM-dd-yyy hh:mm:ss";

    @Override
    public void onStart(ITestContext context) {
        this.context = context;
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
       // String currentTestName = "test1";
        WebDriver webDriver = BrowserUtils.get().getBrowser().getWebDriver();
        Preconditions.checkNotNull(webDriver, "WebDriver instance is null!");
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String resultDateTime = sdf.format(today);
        String screenShotName = "Time: " + resultDateTime;
        makeScreenshot(screenShotName);
    }




    @Attachment(value = "{0}", type = "image/png")
    public byte[] makeScreenshot(String name) {
        return ((TakesScreenshot) BrowserUtils.get().getBrowser().getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
