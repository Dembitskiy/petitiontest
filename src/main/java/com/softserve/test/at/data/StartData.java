package com.softserve.test.at.data;

import com.softserve.test.at.tools.ABrowser;

public final class StartData {
    private String login;
    private String searchStrategy;
    private String browserName;
    private String browserPath;
    private ABrowser browser;

    public StartData() {
        this.login = new String();
        this.searchStrategy = new String();
        this.browserName = new String();
        this.browserPath = new String();
    }

    public StartData(String login, String searchStrategy, String browserName, String browserPath) {
        this.login = login;
        this.searchStrategy = searchStrategy;
        this.browserName = browserName;
        this.browserPath = browserPath;
    }



    public String getLogin() {
        return login;
    }

    public String getSearchStrategy() {
        return searchStrategy;
    }

    public String getBrowserName() {
        return browserName;
    }

    public ABrowser getBrowser() {
        return browser;
    }

    public String getBrowserPath() {
        return browserPath;
    }

    public StartData setLogin(String login) {
        this.login = login;
        return this;
    }


    public StartData setSearchStrategy(String searchStrategy) {
        this.searchStrategy = searchStrategy;
        return this;
    }

    public StartData setBrowserName(String browserName) {
        this.browserName = browserName;
        return this;
    }

    public StartData setBrowserPath(String browserPath) {
        this.browserPath = browserPath;
        return this;
    }

    public StartData setBrowser(ABrowser browser) {
        this.browser = browser;
        return this;
    }

    public StartData clone() {
        StartData startData = new StartData(this.login, this.searchStrategy, this.browserName, this.browserPath);
        startData.setBrowser(this.browser);
        return startData;
    }

}
