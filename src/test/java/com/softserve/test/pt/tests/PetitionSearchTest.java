package com.softserve.test.pt.tests;

import com.softserve.test.at.data.StartData;
import com.softserve.test.at.tools.BrowserUtils;
import com.softserve.test.pt.data.StartPage;
import com.softserve.test.pt.data.StringSearchRepository;
import com.softserve.test.pt.pages.PetitionMainPage;
import com.softserve.test.pt.pages.PetitionSearchPage;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by rdem on 10.02.2016.
 */
public class PetitionSearchTest {
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


    @DataProvider
    public Object[][] MetallicaSearch() {
        return new Object[][] { {StringSearchRepository.getMetallicaSearch(), StringSearchRepository.getMetallicaSearchResult()},
                {StringSearchRepository.getMinisterSearch(), StringSearchRepository.getMinisterSearchResult()} };
    }


    @Title("petition search test")
    @Description("check if text of searched petition is present on the page")
    @Test(dataProvider = "MetallicaSearch")
    public void checkmetallicapetition(String search, String result) {
        PetitionMainPage petitionMainPage = StartPage.get().load(startData);
        PetitionSearchPage petitionSearchPage = petitionMainPage.search(search);
        Assert.assertEquals(petitionSearchPage.findText(result), true);
    }


}
