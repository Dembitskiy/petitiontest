package com.softserve.test.at.tools;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.softserve.test.at.tools.BrowserRepository.BrowserPath;

final class ChromeBrowser extends ABrowser {
    private final String CHROME_PROPERTY = "webdriver.chrome.driver";

    ChromeBrowser() {
        init(BrowserPath.CHROME_PATH.toString());
    }

    ChromeBrowser(String browserPath) {
        init(browserPath);
    }

    private void init(String browserPath) {
        System.setProperty(CHROME_PROPERTY, browserPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-proxy-server");
        options.addArguments("--ignore-certificate-errors");
        setWebDriver(new ChromeDriver(options));
    }

}
