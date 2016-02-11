package com.softserve.test.pt.data;

import com.softserve.test.at.data.StartData;
import com.softserve.test.at.tools.BrowserUtils;
import com.softserve.test.pt.pages.PetitionPage;

public class StartPage {
    private final String START_PAGE_UNDEFINED = "StartPage is Undefined.";
    private static volatile StartPage instance = null;
    
    private StartPage() {
    }

    public static StartPage get() {
        if (instance == null) {
            synchronized (StartPage.class) {
                if (instance == null) {
                    instance = new StartPage();
                }
            }
        }
        return instance;
    }

    // TODO Add Static
    
    public PetitionPage load() {
        StartData startData = BrowserUtils.get().getStartData();
        if ((startData.getLogin() == null)
                || (startData.getLogin().isEmpty())) {
            // TODO Create class Exception + log + report.
            throw new RuntimeException(START_PAGE_UNDEFINED);
        }
        return login(startData);
    }

    public PetitionPage load(StartData startData) {
        BrowserUtils.get(startData);
        return login(startData);
    }
   
    // TODO Code Duplicate
    public PetitionPage login() {
        StartData startData = BrowserUtils.get().getStartData();
        if ((startData.getLogin() == null)
                || (startData.getLogin().isEmpty())) {
            // TODO Create class Exception + log + report.
            throw new RuntimeException(START_PAGE_UNDEFINED);
        }
        return login(startData);
    }
    
    public PetitionPage login(StartData startData) {
        BrowserUtils.get().getBrowser().loadPage(startData.getLogin());
        return new PetitionPage();
    }

    // TODO Code Duplicate



    public void quit() {
        BrowserUtils.get().getBrowser().quit();
    }
    
    public void closeAll() {
        BrowserUtils.closeAll();
    }

    // TODO Add Observe
    //ControlSearch.get().addLoadCompleteEvent(new PageLoadComplete());

}
