package com.softserve.test.pt.data;

import org.openqa.selenium.JavascriptExecutor;

import com.softserve.test.at.tools.BrowserUtils;

// TODO +++++

public final class PageLoadComplete { //implements IObserveLoad {
    private final String IS_PAGE_VISIBLE = "return $('.all')[0].style.opacity == ''";

    public boolean loadComplete(){
        return (boolean)((JavascriptExecutor)BrowserUtils.get().getBrowser().getWebDriver())
                .executeScript(IS_PAGE_VISIBLE);
    }
    
}
