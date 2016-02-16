package com.softserve.test.at.tools;

import org.openqa.selenium.WebDriver;

public abstract class ABrowser {
    private final String BROWSER_CLOSED = "Browser was Closed.";
    private WebDriver driver = null;

    ABrowser() {
    }

    ABrowser(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getWebDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new RuntimeException(BROWSER_CLOSED);
        }
    }

    void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }
    
    String getWebDriverName() {
        return this.getClass().getName();
    }

    boolean isEnabled() {
        return driver != null;
    }

    public void loadPage(String url) {
        getWebDriver().get(url);
    }

    public void refreshPage() {
        getWebDriver().navigate().refresh();
    }

    public void forwardPage() {
        getWebDriver().navigate().forward();
    }

    public void previousPage() {
        getWebDriver().navigate().back();
    }

    public String getCurrentUrl() {
        return getWebDriver().getCurrentUrl();
    }

    public void close() {
        getWebDriver().close();
        driver = null;
    }

    public void quit() {
        getWebDriver().quit();
        driver = null;
    }

}
