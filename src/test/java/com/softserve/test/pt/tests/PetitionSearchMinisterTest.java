package com.softserve.test.pt.tests;

import com.softserve.test.at.data.StartData;
import com.softserve.test.at.tools.BrowserUtils;
import com.softserve.test.pt.data.StartPage;
import com.softserve.test.pt.pages.PetitionPage;
import com.softserve.test.pt.pages.PetitionSearchPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by rdem on 15.02.2016.
 */
public class PetitionSearchMinisterTest {

    private SoftAssert softAssert;
    private StartData startData;

    @BeforeClass
    public void beforeClass() {
        startData = new StartData("https://petition.president.gov.ua/",
                "explicit", "firefox", "");
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void afterClass() {
        BrowserUtils.get().getBrowser().close();
    }


    @Title("petition minister test")
    @Description("check if 'Вибори прем'єр-міністра за відкритим конкурсом' is present on the page")
    @Test
    public void checkministrpetition() {
        PetitionPage petitionPage = StartPage.get().load(startData);
        PetitionSearchPage petitionSearchPage = petitionPage.search(PetitionPage.SEARCH_RESULT_MINISTER);
        softAssert.assertEquals(petitionSearchPage.findText(PetitionSearchPage.FIND_TEXT_MINISTER), true);
        softAssert.assertAll();
    }


}



