package com.softserve.test.pt.pages;

import com.softserve.test.at.controls.ITextField;
import com.softserve.test.at.controls.TextField;
import com.softserve.test.at.tools.BrowserUtils;

/**
 * Created by rdem on 10.02.2016.
 */
public class PetitionSearchPage {
    public static final String FIND_TEXT_METALLICA = "Запросити в Україну легендарну рок-групу Metallica";
    public static final String FIND_TEXT_MINISTER = "Вибори прем'єр-міністра за відкритим конкурсом";
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