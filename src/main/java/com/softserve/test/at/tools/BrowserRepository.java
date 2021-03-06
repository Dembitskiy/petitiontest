package com.softserve.test.at.tools;

final class BrowserRepository {
    
    public static enum BrowserPath {
        CHROME_PATH("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

        private String field;

        private BrowserPath(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }
    
    private static volatile BrowserRepository instance = null;

    private BrowserRepository() {
    }

    static BrowserRepository get() {
        if (instance == null) {
            synchronized (BrowserRepository.class) {
                if (instance == null) {
                    instance = new BrowserRepository();
                }
            }
        }
        return instance;
    }


    public ABrowser getDefaultBrowser() {
        return getFirefoxByTemporaryProfile();
    }

    public ABrowser getFirefoxByTemporaryProfile() {
        return new FirefoxBrowser();
    }
    
    public ABrowser getChromeByTemporaryProfile() {
        return new ChromeBrowser();
    }

    public ABrowser getChromeByTemporaryProfile(String browserPath) {
        return new ChromeBrowser(browserPath);
    }

}
