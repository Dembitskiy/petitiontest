package com.softserve.test.pt.pages;

import com.softserve.test.at.controls.*;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by rdem on 10.02.2016.
 */
public class PetitionMainPage {

    private PetitionPageUIMap controls;

    private class PetitionPageUIMap {
        public ITextField searchfield;
        public ILabelClickable continuesToCollect;
        public ILabelClickable underConsideration;
        public ILabel essenseOfAppeal;
        public IButton searchSubmit;
        public IButton login;

        public PetitionPageUIMap() {
            this.searchfield = TextField.get().getByCssSelector(".txt_input.vat");
            this.continuesToCollect = LabelClickable.get().getByCssSelector("strong.list_filter");
            this.underConsideration = LabelClickable.get().getByCssSelector("[href='?status=in_process']");
            this.essenseOfAppeal = Label.get().getByCssSelector(".list_elem_col_head.list_elem_title");
            this.searchSubmit = Button.get().getByCssSelector(".btn_input.vat.search[type='submit']");
            this.login = Button.get().getByCssSelector("a.login_link");
        }

        public ILabel getEssenseOfAppeal() {
            return essenseOfAppeal;
        }

        public void setEssenseOfAppeal(ILabel essenseOfAppeal) {
            this.essenseOfAppeal = essenseOfAppeal;
        }
    }

    public PetitionMainPage() {
        controls = new PetitionPageUIMap();
    }

    public ITextField getSearchfield() {
        return controls.searchfield;
    }

    public void setSearchfield(String searchfield) {
        this.controls.searchfield.sendKeysClear(searchfield);
    }

    public ILabelClickable getContinuesToCollect() {
        return controls.continuesToCollect;
    }

    public ILabelClickable getUnderConsideration() {
        return controls.underConsideration;
    }

    public IButton getSearchSubmit() {
        return controls.searchSubmit;
    }

    public IButton getlogin() { return controls.login;}

    public void clickSearchSubmit() {
        getSearchSubmit().click();
    }

    @Step("find petitions by search field")
    public PetitionSearchPage search(String search) {
        setSearchfield(search);
        clickSearchSubmit();
        return new PetitionSearchPage();
    }

    public PetitionLoginPage enterLoginPage()
    {
        getlogin().click();
        return new PetitionLoginPage();
    }
}

