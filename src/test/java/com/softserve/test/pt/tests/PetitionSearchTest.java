package com.softserve.test.pt.tests;

import com.softserve.test.at.data.StartData;
import com.softserve.test.at.tools.BrowserUtils;
import com.softserve.test.pt.data.StartPage;
import com.softserve.test.pt.data.StringSearchRepository;
import com.softserve.test.pt.pages.PetitionPage;
import com.softserve.test.pt.pages.PetitionSearchPage;
import org.testng.Assert;
import org.testng.annotations.*;
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


    @DataProvider
    public Object[][] MetallicaSearch() {
        return new Object[][] { {StringSearchRepository.getMetallicaSearch(), StringSearchRepository.getMetallicaSearchResult()},
                {StringSearchRepository.getMinisterSearch(), StringSearchRepository.getMinisterSearchResult()} };
    }


    @Title("petition search test")
    @Description("check if text is present on the page")
    @Test(dataProvider = "MetallicaSearch")
    public void checkmetallicapetition(String search, String result) {
        PetitionPage petitionPage = StartPage.get().load(startData);
        PetitionSearchPage petitionSearchPage = petitionPage.search(search);
        Assert.assertEquals(petitionSearchPage.findText(result), true);
    }


}
