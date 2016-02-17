package com.softserve.test.pt.tests;

import com.softserve.test.at.data.StartData;
import com.softserve.test.at.tools.BrowserUtils;
import com.softserve.test.pt.data.StartPage;
import com.softserve.test.pt.pages.PetitionLoginPage;
import com.softserve.test.pt.pages.PetitionMainPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by rdem on 15.02.2016.
 */
public class PetitionLoginTest {

    private StartData startData;

    @BeforeClass
    public void beforeClass() {
        startData = new StartData("https://petition.president.gov.ua/",
                "explicit", "chrome", "");
    }

    @AfterClass
    public void afterClass() {
        BrowserUtils.get().getBrowser().close();
    }


    @Title("petition login test")
    @Description("check if login page downloaded correctly")
    @Test
    public void checkministrpetition() {
        PetitionMainPage petitionMainPage = StartPage.get().load(startData);
        PetitionLoginPage petitionLoginPage = petitionMainPage.enterLoginPage();
        Assert.assertEquals(petitionLoginPage.checkEnterText(),true);
    }


}



