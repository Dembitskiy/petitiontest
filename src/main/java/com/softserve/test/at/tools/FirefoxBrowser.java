package com.softserve.test.at.tools;

import org.openqa.selenium.firefox.FirefoxDriver;

final class FirefoxBrowser extends ABrowser {

    FirefoxBrowser() {
        super(new FirefoxDriver());
    }

}
