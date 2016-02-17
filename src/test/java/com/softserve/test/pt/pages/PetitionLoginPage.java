package com.softserve.test.pt.pages;

import com.softserve.test.at.controls.ILabel;
import com.softserve.test.at.controls.Label;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by rdem on 17.02.2016.
 */
public class PetitionLoginPage {
    private PetitionLoginPageUIMap controls;

    private class PetitionLoginPageUIMap{
        public ILabel enterText;

        public PetitionLoginPageUIMap(){
            this.enterText = Label.get().getByCssSelector("form.login_form h1");
        }
    }
    public  PetitionLoginPage(){
        controls = new PetitionLoginPageUIMap();
    }

    public ILabel getenterText()
    {
        return this.controls.enterText;
    }

    @Step("check if enter text is present on the loginpage")
    public boolean checkEnterText(){
      return  getenterText().isEnabled();
    }

}
