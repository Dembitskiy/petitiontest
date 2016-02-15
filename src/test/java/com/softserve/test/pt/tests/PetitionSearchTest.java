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
 * Created by rdem on 10.02.2016.
 */
public class PetitionSearchTest {

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

    @Title("petition metallica test")
    @Description("check if 'Запросити в Україну легендарну рок-групу Metallica' text is present on the page")
    @Test
    public void checkmetallicapetition() {
        PetitionPage petitionPage = StartPage.get().load(startData);
        PetitionSearchPage petitionSearchPage = petitionPage.search(PetitionPage.SEARCH_RESULT_METALLICA);
        softAssert.assertEquals(petitionSearchPage.findText(PetitionSearchPage.FIND_TEXT_METALLICA), true);
        softAssert.assertAll();
    }


}
