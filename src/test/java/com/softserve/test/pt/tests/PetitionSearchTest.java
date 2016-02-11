package com.softserve.test.pt.tests;

import com.softserve.test.at.data.StartData;
import com.softserve.test.at.tools.BrowserUtils;
import com.softserve.test.pt.data.StartPage;
import com.softserve.test.pt.pages.PetitionPage;
import com.softserve.test.pt.pages.PetitionSearchPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by rdem on 10.02.2016.
 */
public class PetitionSearchTest {

    private SoftAssert softAssert;
    private StartData startData;
    @BeforeClass
    public void oneTimeSetUp() {
        startData = new StartData("https://petition.president.gov.ua/",
                "implicit","firefox","");
        softAssert = new SoftAssert();
    }
    @Test
    public void test1(){
        PetitionPage petitionPage = StartPage.get().load(startData);
        PetitionSearchPage petitionSearchPage = petitionPage.search(PetitionPage.SEARCH_RESULT);
        softAssert.assertEquals(petitionSearchPage.findText(PetitionSearchPage.FIND_TEXT),true);
        System.out.print(petitionSearchPage.findText(PetitionSearchPage.FIND_TEXT));
    }
}
