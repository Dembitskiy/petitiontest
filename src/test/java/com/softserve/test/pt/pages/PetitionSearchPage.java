package com.softserve.test.pt.pages;

import com.softserve.test.at.controls.ITextField;
import com.softserve.test.at.controls.TextField;
import com.softserve.test.at.tools.BrowserUtils;

/**
 * Created by rdem on 10.02.2016.
 */
public class PetitionSearchPage {

    private PetitionSearchPageUIMap controls;


    private class PetitionSearchPageUIMap {
       public ITextField searchWordField;

        public PetitionSearchPageUIMap() {
            this.searchWordField = TextField.get().getByCssSelector("div.search_form_el.col-xs-3 input.txt_input");
        }
    }

    public PetitionSearchPage(){
        controls = new PetitionSearchPageUIMap();
    }


    public boolean findText(String findText) {
        return BrowserUtils.get().getBrowser().getWebDriver().getPageSource().contains(findText);
    }
}